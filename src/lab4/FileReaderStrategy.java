package lab4;

import java.io.IOException;

public interface FileReaderStrategy<T> {
    
   /* FileReaderStrategy common error components */
   final String FILE_NAME_ERR = "File Name invalid: cannot be null";
   final String FILE_NOT_FOUND = "File does not exist";
   final String FILE_EXT = "File extension must be ";
   final String EMPTY_FILE = "File contains no data";

//    public abstract String readFromFile() throws IOException;
    
    T readFromFile() throws IOException;
    
    public abstract String getFileName();
}
