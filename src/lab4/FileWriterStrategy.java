package lab4;

public interface FileWriterStrategy {

    /**
     *
     * @param inputData
     */
    public abstract void writeToFile(String inputData);
}
