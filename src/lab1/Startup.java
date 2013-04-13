package lab1;

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

        // writeln delegates work to WriterStrategy
        fileService.writeln(writerStrategy, readerStrategy);
        readerStrategy.readSingleRecord(2);
        readerStrategy.readln();
        

    }
}
