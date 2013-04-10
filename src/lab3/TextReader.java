package lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Find and display the city only in the second record in your three record text
 * file.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextReader {

    public static void main(String[] args) throws IOException {

        File dataFile = new File(File.separatorChar + "Temp" + File.separatorChar
                + "ContactList.txt");

        BufferedReader reader = null;
        // 2. Read just the second record an output to the console
        String record = "";
        try {
            reader = new BufferedReader(new FileReader(dataFile));
            String line = reader.readLine();
            int counter = 1;
            while (line != null) {
                line = reader.readLine();  // strips out any carriage return chars
                counter++;
                // 2. Read just the second record an output to the console
                if (line != null && counter == 2) {
                    record += line;
                }
            }
        } catch (IOException ioe) {
            System.out.println("Unable to read file - " + dataFile);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
        System.out.println("Print record #2 City only");
        String[] splits = record.split("\\|");
        System.out.println("City: " + splits[3]);
        System.out.println();
    }
}
