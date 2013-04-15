package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextFileWriter implements FileWriterStrategy {

    @Override
    public void writeln(String line) {
        File dataFile = new File(File.separatorChar + "NetBeansTemp"
                + File.separatorChar + "ContactList.txt");
        boolean append = true;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(dataFile, append)));
            writer.println(line);
            writer.close();
        } catch (IOException ioe) {
            if (writer != null) {
                writer.close();
                System.out.println(ioe.getMessage());
            }
        }
    }
}
