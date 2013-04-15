package lab4;

/**
 * 
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public interface ReaderStrategy {
    
     public abstract String readln();
     
     public abstract String readSingleRecord(int recordNum);
}
