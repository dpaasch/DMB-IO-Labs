package lab2;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class Startup {

    public static void main(String[] args) {
        // Create the strategy objects for the textWriter & textReader
        ReaderStrategy readerStrategy = new TextReader();

        // Create new FileService object
        FileService fileService = new FileService();

        // writeln delegates work to WriterStrategy
        readerStrategy.readSingleRecord(3);
    }   
}
