package lab4;

public class FileService {

    public void writeReadInFile(FileWriterStrategy writerStrategy,
            FileReaderStrategy readerStrategy) {
        // Write the read in file line...
        writerStrategy.writeln(readerStrategy.readln());
    }
}
