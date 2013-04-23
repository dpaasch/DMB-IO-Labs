package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * CsvFileWriter is a low-level class that is used to write input data to a 
 * comma separated value (.csv) file.  This program uses the FileWriterStrategy
 * interface to provide the method for writing to a file.  Currently, the 
 * program is rigid, as it does not allow for file path or file name input, but
 * requires that a specific path and file name are used for locating the file 
 * being written to.  It uses the inputData provided as a String and writes it 
 * into the file, exactly as it is provided (no formatting).
 * 
 * @author Dawn Bykowski
 * @version 1.00
 */
public class CsvFileWriter implements FileWriterStrategy {

    // Create a new Scanner object to hold user input
    Scanner input = new Scanner(System.in);
    // CsvFileWriter components
    private PrintWriter writer = null;
    private boolean append = true;
    private String fileName;
    private String csv = ".csv";
    // CsvFileWriter error components
    private final String DFE_EX = " invalid: File name must end in .csv";
    private final String IA_EX = " invalid: File name length must be > 1 < 20";
    private final String NPE_EX = "Input Data cannot contain a null value ... Exiting";

    @Override
    public void writeToFile(String inputData) {

        try {
            // Get the file name that the data will be written to
//            System.out.println("Enter the file name: ");
//            fileName = input.nextLine();
//            if (fileName == null || fileName.length() == 0) {
//                throw new NullPointerException();
//            } else if (fileName.length() < 1 || fileName.length() > 20) {
//                throw new IllegalArgumentException();
//            } else if (!fileName.endsWith(csv)) {
//                throw new DataFormatException();                
//            }            
            // Open the file the user provided
//            File dataFile = new File(File.separatorChar + "NetBeansTemp"
//                + File.separatorChar + fileName);
            // Open the file as rigidly set here
            File dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + "ContactList_output.csv");

            // if the file does not exist, it will automatically be created.
            if (!dataFile.exists()) {
                System.out.println("Creating file: "
                        + dataFile.getCanonicalPath());
                dataFile.createNewFile();
            }
            // create the writer object.
            writer = new PrintWriter(
                    new BufferedWriter(
                    new java.io.FileWriter(dataFile, append)));
            // Validate that the input data length is not equal to 0
            if (!inputData.isEmpty()) {
                writer.println(inputData);
                System.out.println("Write successful: " + inputData);
                writer.close();
                // Throw NullPointerException if the line is blank or null    
            } else {
                throw new NullPointerException();
            }
            // Catch the NullPointerException and print it to the console
        } catch (NullPointerException npe) {
            System.err.println("Input Data " + NPE_EX);
            System.exit(0);  // 0 = signals program end with no error
//        } catch (DataFormatException dfe) {
//            System.err.println(fileName + DFE_EX);
        } catch (IOException ioe) {
            if (writer != null) {
                writer.close();
            }
            System.err.println(ioe.getMessage());
            System.exit(1);  // 1 = signals program end with error
        } 
    }

    public static void main(String[] args) {
        CsvFileWriter writer = new CsvFileWriter();
        writer.writeToFile("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile(null);
    }
}
