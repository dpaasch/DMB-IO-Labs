package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.UserException;

/**
 * CsvFileWriter_Interactive class, is a low-level concrete class that implements a
 * FileWriterStrategy object. This FileWriter ONLY supports a comma separated
 * value (.csv) format. It is an interactive, console supported program. It
 * creates/updates a file in a file path of: C:\NetBeansTemp, and as the user,
 * you have the choice of what file you will create/update and whether or not to
 * append or overwrite data. Again, the file may ONLY be a comma separated value
 * (.csv) file. If you attempt to write to a file that does not end in .csv, you
 * will receive an error and the program will exit.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class CsvFileWriter_Interactive implements FileWriterStrategy {

    // Create Scanner object for keyboard input
    Scanner input = new Scanner(System.in);
    // CsvFileWriter_Interactive components
    PrintWriter writer = null;
    boolean append = true;
    private String fileName;
    private char fileStatus;
    private String inputData;
    // CsvFileWriter_Interactive message components
    private String ILLEGAL_ARGUMENT = "Input data must contain a comma (,).";
    private String INVALID_EXTENSION = "The filename extension must be .csv";
    private String NULL_POINTER = "Field cannot be null or empty.";

    /**
     * Takes the data that has been input, and writes it to a user specified
     * file, with a .csv format.
     *
     * @throws IOException
     */
    @Override
    public void writeToFile() throws IOException {
        try {
            // Call getFileName to get the file to write to
            fileName = getFileName();
            // Create a new File object that incorporates the path and filename
            File dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + fileName);
            // if the file does not exist, create it.
            if (!dataFile.exists()) {
                System.out.println(dataFile + " not found. Creating it now.");
                dataFile.createNewFile();
            }
            fileStatus = getFileStatus();
            // Call getInputData method to obtain the input data to be written 
            // to the file
            inputData = getInputData();
            // create a new Writer object.
            writer = new PrintWriter(
                    new BufferedWriter(
                    new java.io.FileWriter(dataFile, append)));
            // write the data
            writer.println(inputData);
            // close the writer
            writer.close();
            System.out.println("Write succesful. Exiting program.");
        } catch (IOException ioe) {
            // close the writer if it is not null
            if (writer != null) {
                writer.close();
            }
            System.out.println(ioe.getMessage());
            System.exit(1);  // 1 = signals program end with error
        }
    }

    /**
     * Returns the value of the file name received in the form of the private
     * variable f.
     *
     * @return f : The value of the private variable that identifies the file
     * name. If there is no value, it is set to null.
     * @throws NullPointerException
     */
    @Override
    public String getFileName() throws NullPointerException {
        try {
            // local variable for the file extension
            String csv = ".csv";
            // Request the file name
            System.out.println("Enter the file name as filename.csv: ");
            String f = input.nextLine();
            if (f == null || f.length() == 0) {
                throw new NullPointerException();

                // the file name must end with csv, or it will error   
            } else if (!f.endsWith(csv)) {
                System.out.println(INVALID_EXTENSION);
                System.exit(1);  // 1 = signals program end with error
            } else {
                System.exit(1);
            }

        } catch (NullPointerException npe) {
            System.err.println(NULL_POINTER);
        }
                    return f;
    }

    /**
     * Sets the value of the private variable for the file name.
     *
     * @param fileName : The file name, expressed as a String. Defaults to null
     * if no value is passed in.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Returns the value of the input data received in the form of the private
     * variable d.
     *
     * @return d : The value of the private variable that identifies the input
     * data. If there is no value, it is set to null.
     * @throws NullPointerException
     */
    @Override
    public String getInputData() throws NullPointerException {
        try {
            //Request the data to be added to the file
            System.out.println("Enter the data you wish to input as data,data or X"
                    + " to exit");
            String d = input.nextLine();
            if (d == null || d.length() == 0) {
                throw new NullPointerException();
            }
            if (!d.contains(",")) {
                throw new IllegalArgumentException();
            }
            System.exit(1);
            return d;
        } catch (NullPointerException npe) {
            System.err.println(NULL_POINTER);
        } catch (IllegalArgumentException iae) {
            System.err.println(ILLEGAL_ARGUMENT);
        }



    }

    /**
     * Sets the value of the private variable for the input data.
     *
     * @param inputData : The input data, expressed as a String. Defaults to
     * null if no value is passed in.
     */
    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public char getFileStatus() {
        // Request whether to append data or overwrite
        System.out.println("Do you wish to (a)ppend to existing data or "
                + "(o)verwrite?");
        String choice = input.nextLine();
        char c = choice.charAt(0);
        if (c == 'a' || c == 'A') {
            append = true;
        } else {
            append = false;
        }
        return c;
    }

    public static void main(String[] args) throws IOException {
        CsvFileWriter_Interactive writer = new CsvFileWriter_Interactive();
        writer.writeToFile();
    }
}
