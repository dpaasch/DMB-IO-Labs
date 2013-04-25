package lab4;

public interface FileWriterStrategy  {

   /* FileWriterStrategy common error components */
   final String FILE_NAME_ERR = "File Name invalid: cannot be null";
   final String FILE_NOT_FOUND = "File does not exist";
   final String FILE_EXT = "File extension must be ";
   final String APPEND_ERR = "Append status must be A or O only";
   
    /**
     *
     * @param inputData
     */
    public abstract void writeToFile(String inputData);
    
    public String getFileName();
}
