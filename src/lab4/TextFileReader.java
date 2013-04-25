/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * TxtFileReader is a low-level class that is used to read input data to a text
 * file.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class TextFileReader implements FileReaderStrategy {

    /* TextFileReader variables */
    private String filePath;// The path of the file being read from

    /**
     * TextFileReaderConstructor instantiates the class by setting the filePath
     * private variable.
     *
     * @param filePath : The file path expressed as a String
     */
    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Using a list because it is a variable-length argument that allows for a
     * variable number of arguments. The LinkedHashMap allows for a predictable
     * iteration order, the order in which the data was inserted into the table.
     *
     * @return
     * @throws IOException
     */
    @Override
    public List<LinkedHashMap<String, String>> readFile() throws IOException {
        // create an array to hold the data from the file
        List<String> rawData = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new java.io.FileReader(filePath));
            String line = reader.readLine();  // A line of data from the file
            while (line != null) {
                rawData.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.getCause().getMessage();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return decodeData(rawData, false);
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * encode
     *
     * @param rawData : the data from the file that was read
     * @return
     */
    public String encodeData(List<LinkedHashMap<String, String>> rawData) {
        StringBuilder formattedData = new StringBuilder();

        boolean dataHeader = false; // signifies there is not a header row
        Set<String> dataFields = null;
        if (dataHeader) {
            // takes raw data first row and if there is not a header and sets a
            // key value
            dataFields = rawData.get(0).keySet();  
        }        
        // record defines a row (line) of data
        for (int record = 0; record < rawData.size(); record++) {
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

    public List<LinkedHashMap<String, String>> 
            decodeData(List<String> rawData,  boolean hasHeader) {
        List<LinkedHashMap<String, String>> decodedData =
                new ArrayList<LinkedHashMap<String, String>>();

        int lineCount = 0;
        String[] header = null;
        for (String data : rawData) {
            lineCount++;
            String[] parts = data.split(",");
            if (hasHeader && (lineCount == 1)) {
                header = parts;
            }
            LinkedHashMap<String, String> record =
                        new LinkedHashMap<String, String>();
            for (int i = 0; i < parts.length; i++) {                
                if (hasHeader && (lineCount == 1)) {
                    break;
                } else if (hasHeader) {
                    record.put(header[i], parts[i]);
                } else {
                    record.put("" + i, parts[i]);
                }                
            }
            if (lineCount != 1) {
            decodedData.add(record);
            }
        }
        return decodedData;
    }

    public static void main(String[] args) throws IOException {
        TextFileReader reader =
                new TextFileReader("C:/NetBeansTemp/ContactList.csv");
        System.out.println("Reading file ");
        // create an array to hold the data being read
        List<LinkedHashMap<String, String>> dataFromFile = reader.readFile();
        System.out.println(dataFromFile);
    }
}
