package lab4;

/**
 * File Service used to manage the reader and writer strategy's
 * 
 * @author Dawn Bykowski
 * @version 1.00
 */
public class FileService {
    // FileService Components
    FileReaderStrategy reader;
    FileWriterStrategy writer;
    private String inputData;
    
    /**
     * Constructor used to create a reader
     * @param reader 
     */
    public FileService(FileReaderStrategy reader) {
        this.reader = reader;
    }
    
    /**
     * Constructor used to create a writer
     * @param writer 
     */
    public FileService(FileWriterStrategy writer) {
        this.writer = writer;
    }
    
    /**
     * Writes given input data to a specified file
     */
    public void writeToFile() {
        writer.writeToFile(inputData);
    }

    /**
     * Reads data from a specified file
     * @return data that is read from the file
     */
    public String readFromFile() {
        return reader.readFromFile();
    }

}
