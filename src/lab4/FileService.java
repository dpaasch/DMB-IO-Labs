package lab4;


public class FileService {
    
    public static void main(String[] args) {
        FileReaderStrategy reader = new CsvFileReader_orig();
        FileWriterStrategy writer = new CsvFileWriter();
        
        writer.writeToFile("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072"); 
        
        reader.readFromFile();
    }

}
