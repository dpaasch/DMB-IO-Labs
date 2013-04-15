package lab4;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class FileService {

    public static void main(String[] args) {
        // Create the strategy objects for the textWriter & textReader
        FileWriterStrategy fileWriterStrategy = new TextFileWriter();
        FileReaderStrategy fileReaderStrategy = new TextFileReader();

        // Create new FileServiceStrategy object
        FileServiceStrategy fileServiceStrategy = new FileServiceStrategy();

        // writeln delegates work to FileWriterStrategy
        fileServiceStrategy.writeln(fileWriterStrategy, fileReaderStrategy);
        

    }
}
