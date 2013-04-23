/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author tim
 */
public class FileServiceStartup {
    
        public static void main(String[] args) {
        FileReaderStrategy reader = new TxtFileReader();
        FileWriterStrategy writer = new TxtFileWriter();
        
        writer.writeToFile("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072"); 
        
        reader.readFromFile();
    }
}
