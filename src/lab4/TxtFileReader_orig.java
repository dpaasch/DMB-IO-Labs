package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * CsvFileReader is a low-level class that is used to read data from a text text
 * (.txt) file.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class TxtFileReader_orig {

    // Create a new Scanner object to hold user input
    Scanner input = new Scanner(System.in);
    // CsvFileReader components
    private BufferedReader reader = null;
    private String data = null;
    private String fileName;
    private String txt = ".txt";
    // CsvFileReader error components
    private final String DF_EX = " invalid: File extension must be .txt";
    private final String FNF_EX = " invalid: File not found";
    private final String NP_EX = " invalid: File name cannot be null or empty";

    public String readFromFile() {

        try {
//            // Get the file name that the data will be read from
//            System.out.println("Enter the file name: ");
//            fileName = input.nextLine();
//            // Validate that the file name is populated, or throw an error
//            if (fileName == null || fileName.length() == 0) {
//                // Throw NullPointerException if the file name is not populated
//                // and exit program
//                throw new NullPointerException();
//            }
//            // Validate that the file extension is .txt, or throw an error
//            if (!fileName.endsWith(txt)) {
//                // Throw DataFormatException if the file extension is not .txt
//                // and exit program
//                throw new DataFormatException();
//            }
            // Get the file name that the data will be read from
            getFileName();
            // Open the file the user provided
            File dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + fileName);
            // Validate that the file exists, or throw an error
            if (!dataFile.exists()) {
                // Throw FileNotFoundException if the file does not exist and 
                // exit program
                throw new FileNotFoundException();
            }
            // initialize a counter to count the records           
            int counter = 0;
            // create the writer object.                
            reader = new BufferedReader(new java.io.FileReader(dataFile));
            System.out.println("Reading from file: " + dataFile);
            data = reader.readLine();
            while (!data.isEmpty() && data != null) {
                // read the data, stripping out any carriage return chars
                data = reader.readLine();
                counter++;
                System.out.println("Read record # " + counter + ": " + data);
//                    System.out.println(data);
            }
            if (data == null) {
                // call close method, if there is no data
                close();
            }
        } catch (DataFormatException dfe) {
            System.err.println("File name" + DF_EX);
            System.exit(0);
        } catch (NullPointerException npe) {
            System.err.println("File name" + NP_EX);
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
//        } finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException ex) {
//                System.err.println(ex.getCause().getMessage());
//            }
//            return data;
        }
        return data;
    }

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
        return null;

    }

    /**
     * Closes the reader.
     *
     * @throws IOException : Exception is thrown only if the close fails
     */
    public void close() throws IOException {
        reader.close();
    }

    public static void main(String[] args) throws DataFormatException {
        TxtFileReader_orig reader = new TxtFileReader_orig();
        reader.readFromFile();
    }
}
