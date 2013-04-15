package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextFileReader implements FileReaderStrategy {

    @Override
    public String readln() {
    File dataFile = new File(File.separatorChar + "NetBeansTemp"
            + File.separatorChar + "ContactList.txt");
    BufferedReader reader = null;
    String line = null;
        try {
            if (dataFile.exists()) {
                reader = new BufferedReader(new FileReader(dataFile));
                line = reader.readLine();
                reader.close();
            } else {
                System.out.println("File not found - " + dataFile);
                line = null;
            }
        } catch (IOException ioe) {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ioe2) {
                System.out.println(ioe2.getMessage());
            }
            System.out.println(ioe.getMessage());
        }
        return line;
    }
}
