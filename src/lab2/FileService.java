package lab2;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class FileService {
    
    public void readSingleRecord(ReaderStrategy readerStrategy) {
        readerStrategy.searchForSingleRecord(2);
    }
    public void writeln(WriterStrategy writerStrategy, ReaderStrategy readerStrategy) {
        writerStrategy.writeln(readerStrategy.readln());
    }    
}
