/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    /* TextFileReader variables */
    private String filePath;// The path of the file being read from
    private String FNF = "The file does not exist.";
    /* TextFileReader components */
    private FileFormatStrategy<List<LinkedHashMap<String, String>>, 
            List<String>> formatter;

    /**
     * TextFileReaderConstructor instantiates the class by setting the filePath
     * private variable.
     *
     * @param filePath : The file path expressed as a String
     */
    public TextFileReader(String filePath, CsvFileFormatter formatter) {
        this.filePath = filePath;
        this.formatter = formatter;
    }

    /**
     * Using a list because it is a variable-length argument that allows for a
     * variable number of arguments. The LinkedHashMap allows for a predictable
     * iteration order, the order in which the data was inserted into the table.
     *
     * @return
     * @throws IOException
     */
    public List<LinkedHashMap<String, String>> readFile() 
            throws FileNotFoundException, IOException {
        // create an array to hold the data from the file
        List<String> dataFromFile = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new java.io.FileReader(filePath));
            String line = reader.readLine();  // A line of data from the file
            while (line != null) {
                dataFromFile.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(FNF);
            System.exit(0);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return formatter.decodeData(dataFromFile);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        if (filePath != null || filePath.length() != 0) {
            this.filePath = filePath;
        }
    }

    public static void main(String[] args) throws IOException {
        TextFileReader reader =
                new TextFileReader("C:/NetBeansTemp/ContactList.csv",
                new CsvFileFormatter());
        System.out.println("Reading file ");
        List<LinkedHashMap<String, String>> dataFromFile = reader.readFile();
        System.out.println(dataFromFile);

    }
}
