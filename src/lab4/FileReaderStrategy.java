
package lab4;

import java.io.IOException;

/**
 * The FileReaderStrategy is an interface, providing full abstraction.  It is
 * responsible for providing common file read methods for the low-level classes
 * to utilize (code reuse).  It represents the general contract for all File
 * Strategy implementations. The return type and parameters are generic so 
 * that future implementations can use whatever data type is necessary.
 * @author Dawn Bykowski
 * @version 1.00
 */
public interface FileReaderStrategy<T> {
    
    /**
     * T Represents any return type the user chooses, which if the user needs a
     * different return type format, this code would not need to be changed to
     * implement the different return type.  In this case, I am using a
     * List<LinkedHashMap<String,String>> return.  This allows for the data
     * to be returned in the order in which it is listed within the file.  The
     * first string represents a unique key for the data stored.  The second
     * string represents the data record.
     * @return
     * @throws IOException : Standard input/ouput error message
     */
    T readFile() throws IOException;
}
