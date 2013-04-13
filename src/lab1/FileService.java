package lab1;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class FileService {
    
    public void writeln(WriterStrategy writerStrategy, ReaderStrategy readerStrategy) {
        writerStrategy.writeln(readerStrategy.readln());
    }    
}
