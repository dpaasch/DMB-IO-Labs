package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//import java.util.zip.DataFormatException;

/**
 * TxtFileWriter.java is a low-level class that is used to write input data to a 
 * text (.txt) file. This program uses the FileWriterStrategy interface to 
 * provide the method for writing to a file.  Currently, the program is rigid,
 * as it does not allow for file path or file name input, but requires that a
 * specific path and file name are used for locating the file being written to.
 * It uses the inputData provided as a String and writes it into the file, 
 * exactly as it is provided (no formatting).
 * 
 * @author Dawn Bykowski
 * @version 1.00
 */
public class TxtFileWriter implements FileWriterStrategy {

    // Create a new Scanner object to hold user input
    Scanner input = new Scanner(System.in);
    // TxtFileWriter components
    private PrintWriter writer = null;
    private boolean append = true;
    private String fileName;
    private String txt = ".txt";
    // TxtFileWriter error components
//    private final String DFE_EX = " invalid: File name must end in .txt";
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
//            } else if (!fileName.endsWith(txt)) {
//                throw new DataFormatException();                
//            }       
            // Open the file the user provided
//            File dataFile = new File(File.separatorChar + "NetBeansTemp"
//                + File.separatorChar + fileName);
            
            // Open the file as rigidly set here
            File dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + "ContactList2_output.txt");

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

    /**
     * Main test Method.  Only used for testing in the individual class.
     * @param args 
     */
    public static void main(String[] args) {
        TxtFileWriter writer = new TxtFileWriter();
        writer.writeToFile("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072");
//        writer.writeToFile(null);
    }
}
