package lab4;

/**
 *
 * @author Dawn Bykowski
 * @version 1.00
 */
public interface FileFormatStrategy<T,E> {

    T decodeData(E dataFromFile);

    /**
     * encode
     *
     * @param dataFromFile : the data from the file that was read
     * @return
     */
    String encodeData(T dataFromFile);
    
}
