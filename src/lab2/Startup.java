package lab2;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class Startup {

    public static void main(String[] args) {
        // Create the strategy objects for the textWriter & textReader
        WriterStrategy writerStrategy = new TextWriter();
        ReaderStrategy readerStrategy = new TextReader();

        // Create new FileService object
        FileService fileService = new FileService();

        // writeln delegates work to ReaderStrategy
        fileService.writeln(writerStrategy, readerStrategy);
        
        // For lab1, part #2, find record #2
        String record = readerStrategy.searchForSingleRecord(2);
        // For lab1, part #3, find all records after the addition of the 4th
        // record.
        readerStrategy.readln();
    }
}
