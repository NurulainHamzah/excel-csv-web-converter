// ExcelToCsv.java
/* Java code to convert the Excel file to a CSV file */

// Import the Apache POI library
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ExcelToCsv {

    public static void main(String[] args) {
        try {
            // Open the Excel file
            File excelFile = new File(args[0]);
            OPCPackage opcPackage = OPCPackage.open(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

            // Create a DataFormatter to format cell values as text
            DataFormatter dataFormatter = new DataFormatter();

            // Create a CSV file for each sheet in the Excel workbook
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                String csvFileName = args[0].replace(".xlsx", "") + "_" + sheet.getSheetName() + ".csv";

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFileName), "UTF-8"));

                // Write the column names
                Row row = sheet.getRow(0);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    writer.write(dataFormatter.formatCellValue(cell));
                    if (j < row.getLastCellNum() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();

                // Write the cell values
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    row = sheet.getRow(j);
                    if (row != null) {
                        for (int k = 0; k < row.getLastCellNum(); k++) {
                            Cell cell = row.getCell(k);
                            writer.write(dataFormatter.formatCellValue(cell));
                            if (k < row.getLastCellNum() - 1) {
                            writer.write(",");
                            }
                            }
                            writer.newLine();
                            }
                            }
                            writer.close();
                        }
                
                        workbook.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }                
