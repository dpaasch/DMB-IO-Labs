package lab4;

import java.io.IOException;

public interface FileWriterStrategy {
    
    /**
     * Write the input data to a specified file. 
     */
    public abstract void writeToFile() throws IOException;
    
    public abstract String getFileName();
    
    public abstract String getInputData();
}
