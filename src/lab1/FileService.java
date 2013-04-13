package lab1;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class FileService {
    
    public void readln(ReaderStrategy readerStrategy){
        readerStrategy.readln();
    }
    
    public void writeln(WriterStrategy writerStrategy, ReaderStrategy readerStrategy) 
            throws ArrayIndexOutOfBoundsException {
        writerStrategy.writeln(readerStrategy.readln());
    }    
}
