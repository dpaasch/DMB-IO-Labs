package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * CsvFileReader_orig is a low-level class that is used to read data from a comma
 * separated value (.csv) file.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class CsvFileReader_orig implements FileReaderStrategy {

    // Create a new Scanner object to hold user input
    Scanner input = new Scanner(System.in);
    // CsvFileReader_orig components
    private BufferedReader reader = null;
    private String data = null;
    private String fileName;
    private String csv = ".csv";
    // CsvFileReader_orig error components
    private final String FNF_EX = " invalid: File not found.";

    @Override
    public String readFromFile() {

        try {
            //Get the file name that the data will be read from
//            System.out.println("Enter the file name: ");
//            fileName = input.nextLine();
//            if (fileName == null || fileName.length() == 0) {
//                throw new NullPointerException();
//            } else if (fileName.length() < 1 || fileName.length() > 20) {
//                throw new IllegalArgumentException();
//            } else if (!fileName.endsWith(csv)) {
//                throw new DataFormatException();                
//            }            
//             // Open the file the user provided
//            File dataFile = new File(File.separatorChar + "NetBeansTemp"
//                + File.separatorChar + fileName);
            // Open the file as rigidly set here
            File dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + "ContactList_output.csv");

            // if the file does not exist, an error will be thrown
            if (!dataFile.exists()) {
                // Throw FileNotFoundException if the file does not exist
                throw new FileNotFoundException();
            } else {
                // initialize a counter to count the records           
                int counter = 0;
                // create the writer object.                
                reader = new BufferedReader(new java.io.FileReader(dataFile));
                System.out.println("Reading from file: " + dataFile);
                data = reader.readLine();
                while (!data.isEmpty()) {
                    // read the data, stripping out any carriage return chars
                    data = reader.readLine();  
                    if (data == null) {
                        reader.close();
                } else {
                    counter++;         
                    System.out.println("Read record # " + counter + " : " + data);
//                    System.out.println(data);
                    }                    
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println(FNF_EX);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getCause().getMessage());
            }
            return data;
        }
    }

    public static void main(String[] args) {
        CsvFileReader_orig reader = new CsvFileReader_orig();
        reader.readFromFile();
    }
}
