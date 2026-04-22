<?php
//convert.php

// Import the Apache POI library
require_once 'lib/poi-bin-5.2.3';

// Initialize variables
$errorMessage = "";
$tempDir = 'tmp/';
$javaBin = '/usr/bin/java';
$javaClass = 'ExcelToCsv';

// Check the value of $errorMessage
// var_dump($errorMessage);

// Check if a file was uploaded
if (isset($_FILES['excelFile']) && !empty($_FILES['excelFile']['name'])) {
    // Get the file details
    $fileName = $_FILES['excelFile']['name'];
    $fileTempName = $_FILES['excelFile']['tmp_name'];

    // Validate the file type
    $fileType = pathinfo($fileName, PATHINFO_EXTENSION);
    if ($fileType != 'xlsx') {
        $errorMessage = "Only .xlsx files are allowed.";
    } 
    
    else {
        // Save the uploaded file to the temp directory
        move_uploaded_file($fileTempName, $tempDir.$fileName);

        // Execute the Java code to convert the Excel file to a CSV file
        exec($javaBin.' -cp .:./lib/* '.$javaClass.' '.$tempDir.$fileName);

        $output = exec('/usr/bin/java -cp .:./lib/* com.example.ConvertExcelToCsv '.$tempDir.$fileName);

        if ($output === null) {
        // The command failed
        echo "An error occurred while converting the file.";
        } 
        else {
        // The command was successful
         echo "The file was successfully converted to CSV.";
        }   

        // Prompt the user to download the CSV file
        header('Content-Type: application/csv');
        header('Content-Disposition:attachment; filename="'.str_replace('.xlsx', '.csv', $fileName).'"');
        header('Content-Length: ' . filesize($tempDir.str_replace('.xlsx', '.csv', $fileName)));
        readfile($tempDir.str_replace('.xlsx', '.csv', $fileName));

        // Delete the temporary files
        unlink($tempDir.$fileName);
        unlink($tempDir.str_replace('.xlsx', '.csv', $fileName));
    }

} 
else {
    // Set an error message if no file was uploaded
    $errorMessage = "No file was uploaded.";
}


// Start output buffering
ob_start();

// Include the HTML file
include './index.html';

// End output buffering and get the output
$output = ob_get_clean();

// Replace any placeholders in the output with the corresponding values
$output = str_replace('{{errorMessage}}', $errorMessage, $output);

// Output the final HTML to the browser
echo $output;
?>

