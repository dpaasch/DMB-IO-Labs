package lab4;

public class FileStartup {

    public static void main(String[] args) {
        // Create the strategy objects for the textWriter & textReader
        FileWriterStrategy writerStrategy = new TextFileWriter();
        FileReaderStrategy readerStrategy = new TextFileReader();

        // Create new FileService object
        FileService fileService = new FileService();

        // writeReadInFile delegates work to FileWriterStrategy
        fileService.writeReadInFile(writerStrategy, readerStrategy);
        readerStrategy.readln();

        System.out.println("Program ended.");
    }
}