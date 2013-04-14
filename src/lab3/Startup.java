package lab3;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class Startup {

    public static void main(String[] args) {
        // Create the strategy objects for the textReader
        ReaderStrategy readerStrategy = new TextReader();

        // Create new FileService object
        FileService fileService = new FileService();

        readerStrategy.readSingleRecord(2);
    }   
}
