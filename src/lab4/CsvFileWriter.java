package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * CsvFileWriter is a low-level class that is used to write input data to a
 * comma separated value (.csv) file. This program uses the FileWriterStrategy
 * interface to provide the method for writing to a file. Currently, the program
 * is rigid, as it does not allow for file path to be entered as input, but 
 * requires that a specific path be used for locating the file being written to. 
 * It uses the inputData provided as a String and writes it into the file, 
 * exactly as it is provided (no formatting).
 *
 * @author Dawn Bykowski
 * @version 1.00
 */
public class CsvFileWriter implements FileWriterStrategy {

    // Create a new Scanner object to hold user input
    Scanner input = new Scanner(System.in);
    // CsvFileWriter components
    private File dataFile;
    private PrintWriter writer;
    private boolean append;
    private String fileName;

    /**
     * Constructor instantiates the class by setting the fileName private
     * variable.
     *
     * @param fileName : The file name expressed as a String.
     */
    public CsvFileWriter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Writes the provided data to the file specified by the user in the
     * getFileName() method called at instantiation time. The path for this file
     * is currently C:/NetBeansTemp and cannot be changed unless this class is
     * modified in the dataFile variable setting. This method, calls the
     * validateDataFile() method to determine if the file name provided by the
     * user already exists. If it does not, it will create the file
     * automatically.
     *
     * @param inputData : The data to be written expressed as a String.
     */
    @Override
    public void writeToFile(String inputData) {
        try {
            dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + fileName);
            validateDataFile();  // calls the validateDataFile() method
            // create the writer object.
            writer = new PrintWriter(
                    new BufferedWriter(
                    new java.io.FileWriter(dataFile, append)));
            writer.println(inputData);
            System.out.println("Write successful.");
            writer.close();
            // if there is no data, exit.
            if (inputData == null) {
                System.exit(0);
            }
        } catch (IOException ioe) {
            if (writer != null) {
                writer.close();
            } else {
                System.err.println(ioe.getMessage());
            }
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
    public String getFileName() {
        String csv = ".csv";  // local variable for file extension
        try {
            System.out.println("Enter the file name to write to as filename.csv");
            String fn = input.nextLine();
            if (fn != null && fn.length() != 0 && (fn.endsWith(csv))) {
                fileName = fn;
                getAppendStatus();  // calls the getAppendStatus method
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

    /**
     * Validates that the dataFile being requested with the getFileName()
     * method already exists. If it doesn't, it will be created automatically.
     *
     * @throws IOException : 
     */
    public void validateDataFile() throws IOException {
            if (!dataFile.exists()) {
                System.out.println("Creating file: " + dataFile.getCanonicalPath());
                dataFile.createNewFile();
            }
    }

    /**
     * Returns the value of whether the file should be overwritten or appended
     * to, in the form of a private variable.
     *
     * @return append : The value of the private variable that identifies the
     * append status. It is set to overwrite (false), upon initialization.
     */
    public boolean getAppendStatus() {
        try {
            append = false;  // local variable sets append to overwrite state
            System.out.println("(A)ppend or (O)verwrite file?");
            String choice = input.nextLine();
            char c = choice.charAt(0);
            if (c == 'A' || c == 'a') {
                append = true;
            } else if (c == 'O' || c == 'o') {
                append = false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
            System.err.println(APPEND_ERR);
            getAppendStatus();
        }
        return append;
    }

    /**
     * Sets the value of append.
     *
     * @return append : The value of the private variable that identifies the
     * append status. It is set to overwrite (false), upon initialization.
     */
    public void setAppendStatus(boolean append) {
        this.append = append;
    }

    public static void main(String[] args) throws NullPointerException,
            DataFormatException {
        String fn = null;
        CsvFileWriter writer = new CsvFileWriter(fn);
        writer.getFileName();
        writer.writeToFile("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072");
    }

}
