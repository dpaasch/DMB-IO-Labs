package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 1. Read all records and output to console
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextReader {

    public static void main(String[] args) throws IOException {
        // 1. Read all records and output to console
        File dataFile = new File(File.separatorChar + "Temp" + File.separatorChar
                + "ContactList.txt");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(dataFile));
            String line = reader.readLine();
            while (line != null) {
                // 1. Read all records and output to console
                String[] splits = line.split("\\|");
                System.out.println("Name: " + splits[0] + " " + splits[1]);
                System.out.println("Addr: " + splits[2]);
                System.out.println("      " + splits[3] + ", " + splits[4] + " "
                        + splits[5]);
                System.out.println("eMail:" + splits[6]);
                System.out.println("Phone:" + splits[7]);
                System.out.println();
                line = reader.readLine();  // strips out any carriage return chars
            }
        } catch (IOException ioe) {
            System.out.println("Unable to read file - " + dataFile);
//        } catch (ArrayIndexOutOfBoundsException oob) {
//            System.out.println();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }

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
        System.out.println("Print record #2 only");
        String[] splits = record.split("\\|");
        System.out.println("Name: " + splits[0] + " " + splits[1]);
        System.out.println("Addr: " + splits[2]);
        System.out.println("      " + splits[3] + ", " + splits[4] + " "
                + splits[5]);
        System.out.println("eMail:" + splits[6]);
        System.out.println("Phone:" + splits[7]);
        System.out.println();
    }       
}
