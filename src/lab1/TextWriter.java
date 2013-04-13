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
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextWriter implements WriterStrategy {

    private File dataFile = new File(File.separatorChar + "NetBeansTemp"
            + File.separatorChar + "ContactList.txt");
    private boolean append = true;
    private PrintWriter writer = null;

    @Override
    public void writeln(String line) {
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(dataFile, append)));
            // Add the new record
            writer.println();
            writer.println("Pam|Tillis|418 Westfield Way|Pewaukee|WI|53072|mydaddysingstoo@gmail.com|262-691-0098");
            writer.close();
        } catch (IOException ioe) {
            if (writer != null) {
                writer.close();
                JOptionPane.showMessageDialog(null, ioe);
                System.exit(1);
            }
        }
        JOptionPane.showMessageDialog(null, "Wrote to file: " 
                + dataFile.getAbsoluteFile());
    }
}
