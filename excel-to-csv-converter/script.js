// Import the necessary modules from the Apache POI library
const XSSFWorkbook = require('poi-bin-5.2.3').XSSFWorkbook;
const Sheet = require('poi-bin-5.2.3').Sheet;
const Row = require('poi-bin-5.2.3').Row;
const Cell = require('poi-bin-5.2.3').Cell;
const FileInputStream = require('poi-bin-5.2.3').FileInputStream;
const FileOutputStream = require('poi-bin-5.2.3').FileOutputStream;

// Import the necessary modules from the Apache POI library
const XSSFWorkbook = require('poi-bin-5.2.3').XSSFWorkbook;
const Sheet = require('poi-bin-5.2.3').Sheet;
const Row = require('poi-bin-5.2.3').Row;
const Cell = require('poi-bin-5.2.3').Cell;
const FileInputStream = require('poi-bin-5.2.3').FileInputStream;
const FileOutputStream = require('poi-bin-5.2.3').FileOutputStream;
const OutputStreamWriter = require('poi-bin-5.2.3').OutputStreamWriter;

// Function to convert an Excel file to a CSV file
function excelToCsv(excelFilePath, csvFilePath) {
  // Open the Excel file
  const workbook = new XSSFWorkbook(new FileInputStream(excelFilePath));
  const sheet = workbook.getSheetAt(0);

  // Open the output CSV file
  const writer = new OutputStreamWriter(new FileOutputStream(csvFilePath), 'UTF-8');

  // Iterate over each row in the Excel file
  for (const row of sheet) {
    let firstCell = true;

    // Iterate over each cell in the row
    for (const cell of row) {
      if (!firstCell) {
        writer.print(',');
      }

      // Get the cell value
      const cellValue = cell.getStringCellValue();

      // Write the cell value to the CSV file
      writer.print(cellValue);

      firstCell = false;
    }

    writer.println();
  }

  // Close the output CSV file
  writer.close();

  // Close the Excel file
  workbook.close();
}

// Example: Convert an Excel file to a CSV file
excelToCsv('input.xlsx', 'output.csv');
