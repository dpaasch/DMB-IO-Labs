/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * TxtFileReader is a low-level class that is used to read input data to a text
 * file.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
public class TextFileReader {

    private String dataFilePath;// The path of the file being read from

    public TextFileReader(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    /**
     * Using a list because it is a variable-length argument that allows for a 
     * variable number of arguments.  The LinkedHashMap allows for a predictable
     * iteration order, the order in which the data was inserted into the table.
     * @return
     * @throws IOException 
     */
    public List<String> readFile() throws IOException {
        // create an array to hold the data from the file
        List<String> rawData = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new java.io.FileReader(dataFilePath));
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
        return rawData;
    }

    public String getDataFilePath() {
        return dataFilePath;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }
      
    public static void main(String[] args) throws IOException {
        TextFileReader reader = 
                new TextFileReader("C:/NetBeansTemp/ContactList.csv");
        System.out.println("Reading file ");
        // create an array to hold the data being read
        List<String> dataFromFile = reader.readFile();
        System.out.println(dataFromFile);
    }
}
