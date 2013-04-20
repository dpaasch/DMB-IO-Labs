package lab4;

public class FileStartup {

    public static void main(String[] args) {
        // Create the strategy objects for the textWriter & textReader
        FileWriterStrategy writer = new CsvFileWriter_Interactive();
        FileReaderStrategy reader = new CsvFileReader();

        // Create new FileService object
        FileService fileService = new FileService();
        fileService.writeToFile(writer);

        // writeReadInFile delegates work to FileWriterStrategy
//        fileService.writeReadInFile(writer, reader);
//        readerStrategy.readln();

        System.out.println("Program ended.");
    }
}
