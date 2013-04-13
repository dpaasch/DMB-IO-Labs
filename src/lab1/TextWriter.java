package lab1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * 3. Add a new record by appending the file. Then read all records back in and 
 * output to console to confirm that the new record can be read.
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextWriter implements WriterStrategy {

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
         JOptionPane.showMessageDialog(null, "Wrote to file: " + dataFile.getAbsoluteFile());
//         // List the records after the add:
//         System.out.println("These are the current records:");
         } catch (IOException ioe) {
             if (writer != null) {
                 writer.close();
                 JOptionPane.showMessageDialog(null, ioe.getMessage());
                 System.exit(1);
             }
         }
    }
}
