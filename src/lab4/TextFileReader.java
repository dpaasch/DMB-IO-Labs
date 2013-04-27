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
    private FileFormatStrategy<List<LinkedHashMap<String, String>>, List<String>> formatter;

    /**
     * TextFileReaderConstructor instantiates the class by setting the filePath
     * private variable.
     *
     * @param filePath : The file path expressed as a String
     */
    public TextFileReader(String filePath, FileFormatStrategy formatter) {
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
                dataFromFile.add(line + "\n");
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
//        return decodeData(dataFromFile);
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

//    public List<LinkedHashMap<String, String>> decodeData(List<String> dataFromFile) {
//        List<LinkedHashMap<String, String>> decodedData =
//                new ArrayList<LinkedHashMap<String, String>>();
//
//        int lineCount = 0;
//        String[] header = null;
//        for (String line : dataFromFile) {
//            lineCount++;
//            String[] parts = line.split(",");
//            if (hasHeader && (lineCount == 1)) {
//                header = parts;
//            }
//            LinkedHashMap<String, String> record =
//                    new LinkedHashMap<String, String>();
//            for (int i = 0; i < parts.length; i++) {
//                if (hasHeader && (lineCount == 1)) {
//                    break;
//                } else if (hasHeader) {
//                    record.put(header[i], parts[i]);
//                } else {
//                    record.put("" + i, parts[i]);
//                }
//            }
//            if (lineCount != 1) {
//                decodedData.add(record);
//            }
//        }
//        return decodedData;
//    }

    public static void main(String[] args) throws IOException {
        TextFileReader reader =
                new TextFileReader("C:/NetBeansTemp/ContactList.csv",
                new CsvFileFormatter());
        System.out.println("Reading file ");
        List<LinkedHashMap<String, String>> dataFromFile = reader.readFile();
        System.out.println(dataFromFile);

    }
}
