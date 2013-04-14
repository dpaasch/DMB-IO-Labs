package lab3;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class FileService {
    
    private int recordNum = 1;
    
    public void readln(ReaderStrategy readerStrategy){
        readerStrategy.readSingleRecord(recordNum);
    }
    
}
