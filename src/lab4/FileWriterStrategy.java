/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author tim
 */
public interface FileWriterStrategy {

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
    void writeToFile(List<String> data, boolean append) throws IOException;
    
}
