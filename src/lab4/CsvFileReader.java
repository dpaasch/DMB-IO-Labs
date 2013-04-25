package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * CsvFileReader is a low-level class that is used to read input data to a comma
 * separated value (.csv) file. This program uses the FileReaderStrategy
 * interface to provide the method for reading to a file. Currently, the program
 * is rigid, as it does not allow for file path to be entered as input, but
 * requires that a specific path be used for locating the file being read from.
 * It uses the inputData provided as a String and writes it into the file,
 * exactly as it is provided (no formatting).
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class CsvFileReader implements FileReaderStrategy {

    // Create a new Scanner object to hold user input
    Scanner input = new Scanner(System.in);
    // CsvFileReader components
    File dataFile;
    private BufferedReader reader;
    private String data;
    private String fileName;

    /**
     * Constructor instantiates the class by setting the fileName private
     * variable.
     *
     * @param fileName : The file name expressed as a String.
     */
    public CsvFileReader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads the data from the file specified by the user in the getFileName()
     * method called at instantiation time. The path for this file is currently
     * C:/NetBeansTemp and cannot be changed unless this class is modified in
     * the dataFile variable setting.after calling the getFileName() method,
     * which takes user input to know what file to read from.
     *
     * @return data that is found within the specified file
     */
    @Override
    public String readFromFile() throws IOException {

        try {
            // Open the file the user provided
            dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + fileName);
                // Create the reader object
                reader = new BufferedReader(
                        new java.io.FileReader(dataFile));
                System.out.println("\nReading from file: " + dataFile);
                do {
                    int counter = 1;
                    data = reader.readLine();
                    // if there is no data, exit.
                    if (data != null) {
                        System.out.println(data);
                        counter++;
                    }
                } while (data != null);
                reader.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println(FILE_NOT_FOUND);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (reader != null) {
                reader.close();
            }
            return data;
        }
    }

    /**
     * Returns the value of the file name in the form of the private variable.
     * Verifies the file name is not null, and that it ends with an extension of
     * .csv. It calls the getAppendStatus() method to determine if the file
     * should be overwritten or appended to.
     *
     *
     * @return fileName: The value of the private variable that identifies the
     * name of the file to be written to. If there is no value, it is set to
     * null.
     */
    @Override
    public String getFileName()  {
        String csv = ".csv";  // local variable for file extension
        try {
            System.out.println("Enter the file name to read from as filename.csv");
            String fn = input.nextLine();
            if (fn != null && fn.length() != 0 && (fn.endsWith(csv))) {
                fileName = fn;
                return fn;
            } else if (fn == null || fn.length() == 0) {
                throw new NullPointerException();
            } else if (!fn.endsWith(csv)) {
                throw new DataFormatException();
            }
        } catch (NullPointerException npe) {
            System.err.println(FILE_NAME_ERR);
            getFileName();
        } catch (DataFormatException dfe) {
            System.out.println(FILE_EXT + csv);
            getFileName();
        }
        return null;
    }

    /**
     * Sets the user input file name.
     *
     * @param fileName : The value of the private variable that identifies the
     * name of the file to be written to. If there is no value, it is set to
     * null.
     */
    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) throws NullPointerException, DataFormatException, IOException {
        String fn = null;
        CsvFileReader reader = new CsvFileReader(fn);
        reader.getFileName();
        reader.readFromFile();
    }
}
