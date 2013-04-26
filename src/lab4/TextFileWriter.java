package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dawn Bykowski
 * @version 1.00
 */
public class TextFileWriter {

    /* TextFileWriter variables */
    private String fileName;    // The name of the file being written to
    private boolean append;     // Append data (true) or overwrite (false)
    private boolean hasHeader;  // Has a header row (true) or no header (false)
    private List<String> inputData;

    /* TextFileReader components */
    private File dataFile;
    private PrintWriter writer;
//    private FileFormatStrategy<List<LinkedHashMap<String, String>>, List<String>> formatter;

/**
     * Constructor instantiates the class by setting the fileName private
     * variable.
     *
     * @param fileName : The file name expressed as a String.
     */
    public TextFileWriter(String fileName, boolean append) {
        this.fileName = fileName;
        this.append = append;
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

    public void writeToFile(List<String> inputData) {
        try {
            dataFile = new File(File.separatorChar + "NetBeansTemp"
                    + File.separatorChar + fileName);
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

    public List<String> getInputData() {
        return inputData;
    }

    public void setInputData(List<String> inputData) {
        this.inputData = inputData;
    }
    
    

   public String encodeData(List<String> dataFromFile) {
        StringBuilder formattedData = new StringBuilder();

        boolean dataHeader = false; // signifies there is not a header row
        Set<String> dataFields = null;
//        if (dataHeader) {
//            // takes raw data first row and if there is not a header and sets a
//            // key value
//            dataFields = dataFromFile.get(0).;  
//        }        
        // record defines a row (line) of data
        for (int record = 0; record < dataFromFile.size(); record++) {
            if (dataFields != null) {
                for (String dataField : dataFields) {
                    formattedData.append(dataField);
                    formattedData.append(",");
                    formattedData.append("\n");
                }
            }
        }
        return formattedData.toString();
    }

    public static void main(String[] args) throws IOException {
        List<String> writeStrings = new ArrayList<String>();
        writeStrings.add("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        writeStrings.add("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        writeStrings.add("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        writeStrings.add("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072");
        
        String fn = "ContactList.csv";
        TextFileWriter writer = new TextFileWriter(fn, true);
        writer.writeToFile(writeStrings);

//                writer.writeToFile("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
//        writer.writeToFile("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
//        writer.writeToFile("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
//        writer.writeToFile("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072");
    }
}
