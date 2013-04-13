package lab1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 3. Add a new record by appending the file. Then read all records back in and 
 * output to console to confirm that the new record can be read.
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextWriter implements WriterStrategy {
     
//     public static void main(String[] args) throws IOException {
//        File dataFile = new File(File.separatorChar + "Temp" + File.separatorChar
//                + "ContactList.txt");
//        
//        // This allows the data to be added to the file, not overwriting what
//        // already exists
//         boolean append = true;
//         PrintWriter writer = new PrintWriter
//                 (new BufferedWriter
//                 (new FileWriter(dataFile, append)));
//         // Add the new record
//         writer.println();
//         writer.println("Lara|Rebholz|487 Westfield Way|Pewaukee|WI|53072|reboholz.lara@gmail.com|262-691-4031");
//         writer.close();
//         System.out.println("Wrote to file: " + dataFile.getAbsoluteFile());
////         // List the records after the add:
//         System.out.println("These are the current records:");
//         TextReader.main(args);      
//     }

    @Override
    public void writeln(String line) {
        File dataFile = new File(File.separatorChar + "NetBeansTemp"
                + File.separatorChar + "ContactList.txt");
        
        // This allows the data to be added to the file, not overwriting what
        // already exists
         boolean append = true;
         PrintWriter writer = null;
         try {
            writer = new PrintWriter
                 (new BufferedWriter
                 (new FileWriter(dataFile, append)));
         // Add the new record
         writer.println();
         writer.println("Pam|Tillis|418 Westfield Way|Pewaukee|WI|53072|mydaddysingstoo@gmail.com|262-691-0098");
         writer.close();
         System.out.println("Wrote to file: " + dataFile.getAbsoluteFile());
//         // List the records after the add:
//         System.out.println("These are the current records:");
         } catch (IOException ioe) {
             if (writer != null) {
                 writer.close();
                 System.out.println(ioe.getMessage());
                 System.exit(1);
             }
         }
    }
}
