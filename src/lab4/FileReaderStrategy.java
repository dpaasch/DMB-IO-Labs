/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author tim
 */
public interface FileReaderStrategy {

    public abstract String getFilePath();

    /**
     * Using a list because it is a variable-length argument that allows for a
     * variable number of arguments.  The LinkedHashMap allows for a predictable
     * iteration order, the order in which the data was inserted into the table.
     * @return
     * @throws IOException
     */
    List<LinkedHashMap<String, String>> readFile() throws IOException;

    void setFilePath(String filePath);
    
}
