package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Dawn Bykowski
 * @version 1.00
 */
public class TextFileWriter {

    /* TextFileWriter variables */
    private String fileName;    // The name of the file being written to
    private boolean append;     // Append data (true) or overwrite (false)

    /* TextFileWriter components */
    private File dataFile;
    private FileFormatStrategy<List<LinkedHashMap<String, String>>, List<String>> formatter;

    /**
     * Constructor instantiates the class by setting the fileName private
     * variable.
     *
     * @param fileName : The file name expressed as a String.
     */
    public TextFileWriter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Writes the provided data to the file specified by the user in the
     * getFileName() method called at instantiation time. The path for this file
     * is currently C:/NetBeansTemp and cannot be changed unless this class is
     * modified in the dataFile variable setting. This method, calls the
     * validateDataFile() method to determine if the file name provided by the
     * user already exists. If it does not, it will create the file
     * automatically. Type specifies the type of list to be used.
     *
     * @param inputData : The data to be written expressed as a String.
     */
//    @Override
    public final String writeToFile(List<LinkedHashMap<String,String>> data)
            throws IOException {
        // Create the PrintWriter object and set it to null
        PrintWriter writer = null;

        try {
            dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + fileName);
            validateDataFile();
            // create a new writer object.
            writer = new PrintWriter(
                    new BufferedWriter(
                    new java.io.FileWriter(dataFile, append)));
//            LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
            // Create an array list to hold the data provided prior to writing
            List<String> inputData = new ArrayList<String>();
            for (String s : inputData) {
                writer.print(s + "\n");
                System.out.println("Write successful.");
            }
            writer.close();
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return formatter.encodeData(data);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String fileName) {
        this.fileName = fileName;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    /**
     * Validates that the dataFile being requested with the getFileName() method
     * already exists. If it doesn't, it will be created automatically.
     *
     * @throws IOException
     */
    public void validateDataFile() throws IOException {
        if (!dataFile.exists()) {
            System.out.println("Creating file: " + dataFile.getCanonicalPath());
            dataFile.createNewFile();
        }
    }

    @Override
    public String toString() {
        return "TextFileWriter{" + "fileName=" + fileName + ", append=" + append 
                + ", dataFile=" + dataFile + ", formatter=" + formatter + '}';
    }

    public static void main(String[] args) throws IOException {
        String fn = "ContactList.csv";
        TextFileWriter writer = new TextFileWriter(fn); 
        List<String> data = new ArrayList<String>();
        data.add(0, "Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        data.add("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        data.add("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        data.add("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile(data);

    }
}
