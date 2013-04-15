package lab4;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class FileServiceStrategy {
    
    public void readln(FileReaderStrategy readerStrategy){
        readerStrategy.readln();
    }
    
    public void writeln(FileWriterStrategy writerStrategy, FileReaderStrategy readerStrategy) 
            throws ArrayIndexOutOfBoundsException {
        writerStrategy.writeln(readerStrategy.readln());
    }    
}
