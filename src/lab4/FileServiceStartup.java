/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;

/**
 *
 * @author tim
 */
public class FileServiceStartup {
    
        public static void main(String[] args) throws IOException {
            String fn = null;
        FileReaderStrategy reader = new TxtFileReader(fn);
        FileWriterStrategy writer = new TxtFileWriter(fn);
        writer.getFileName();
        
        writer.writeToFile("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Jerry,Reed,419 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Clay,Walker,420 Westfield Way,Pewaukee,WI,53072");
        writer.writeToFile("Patsy,Cline,421 Westfield Way,Pewaukee,WI,53072"); 
                
        reader.readFromFile();
    }
}
