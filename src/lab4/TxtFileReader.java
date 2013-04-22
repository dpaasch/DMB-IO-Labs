package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * TxtFileReader is a low-level class that implements a FileReaderStrategy.
 * It is used to read data from a text (.txt) file.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class TxtFileReader implements FileReaderStrategy {

    // Create a new Scanner object to hold user input for the file name
    Scanner input = new Scanner(System.in);
    // TxtFileReader components
    private BufferedReader reader = null;
    private String data = null;
    private String fileName;
    private String txt = ".txt";
    // TxtFileReader error components
    private final String DF_EX = " invalid: File extension must be .txt";
    private final String FNF_EX = " invalid: File not found";
    private final String NP_EX = " invalid: File name cannot be null or empty";

    public String readFromFile() {

        try {
            // Get the file name that the data will be read from
            getFileName();
            // Open the file the user provided
            File dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + fileName);
            // Validate that the file exists
            if (dataFile.exists()) {
                // Create the reader object
                reader = new BufferedReader(new java.io.FileReader(dataFile));
                System.out.println("\nReading from file: " + dataFile);
                do {
                    // initialize a counter to keep track of the number of
                    // records in the file
                    int counter = 1;
                    // read in the line of data
                    data = reader.readLine();
                    // as long as the file contains data, print out the data
                    // found
                    if (data != null) {
                        System.out.println(data);
                        counter++;
                    } else {
                        // If the data is null, exit the read
                        System.exit(0);
                    }
                } while (data != null);
            } else {
                throw new FileNotFoundException();
            }
            // Close the reader after the file has been read
            reader.close();
          // Catch the errors from the file name and any I/O errors.  If an
          // error is found, exit the program
        } catch (DataFormatException dfe) {
            System.err.println("File name" + DF_EX);
            System.exit(0);
        } catch (FileNotFoundException fnf) {
            System.err.println("File name" + FNF_EX);
        } catch (NullPointerException npe) {
            System.err.println("File name" + NP_EX);
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println(ioe.getCause().getMessage());
            System.exit(0);
          // Verify that thhe reader is not a null value and if it is, close
          // the reader
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception ex) {
                System.err.println(ex.getCause().getMessage());
            }
            return data;
        }
    }

    /**
     * Returns the file name of the file to be read, after getting the file name
     * from the user and verifying that the name is not null and the extension 
     * ends with .txt.
     * @return fileName : The name of the file to be read
     * @throws DataFormatException : if the file extension is not .txt. Program
     * will exit.
     * @throws NullPointerException : if the file name is not populated or if 
     * the length is = 0. Program will exit.
     */
    public String getFileName() throws DataFormatException {
        // Get the file name that the data will be read from
        System.out.println("Enter the file name: ");
        fileName = input.nextLine();
        // Validate that the file name is populated, or throw an error
        if (fileName == null || fileName.length() == 0) {
            // Throw NullPointerException if the file name is not populated
            // and exit program
            throw new NullPointerException();
        } 
        // Validate that the file extension is .txt, or throw an error
        if (!fileName.endsWith(txt)) {
            // Throw DataFormatException if the file extension is not .txt
            // and exit program
            throw new DataFormatException();
        }
        return fileName;
    }

    public static void main(String[] args) throws DataFormatException {
        TxtFileReader reader = new TxtFileReader();
        reader.readFromFile();
    }
}
