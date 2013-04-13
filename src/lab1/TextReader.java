package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextReader implements ReaderStrategy {

    private boolean lineReadFlag = false;
    private BufferedReader reader = null;
    private String line = null;
    private String record = "";

    @Override
    public String readln() {
         File dataFile = new File("src" + File.separatorChar + "Files"
                + File.separatorChar + "ContactList.txt");
        try {
            if (dataFile.exists()) {
                reader = new BufferedReader(new FileReader(dataFile));
                line = reader.readLine();
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
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException oob) {
            System.out.println();
        }
        
        readSingleRecord();
        
        if (lineReadFlag) {
            return null;
        } else {
            lineReadFlag = true;
            return line;
        }
    }

    public String readSingleRecord() {
        // 2. Read just the second record an output to the console
        File dataFile = new File("src" + File.separatorChar + "Files"
                + File.separatorChar + "ContactList.txt");

        try {
            if (dataFile.exists()) {
                reader = new BufferedReader(new FileReader(dataFile));
                line = reader.readLine();
                int counter = 1;
                while (line != null) {
                    line = reader.readLine();  // strips out any carriage return chars
                    counter++;
                    // 2. Read just the second record an output to the console
                    if (line != null && counter == 2) {
                        record += line;
                    }
                }
            } else {
                System.out.println("File not found - " + dataFile);
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
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException oob) {
            System.out.println();
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
        
        if (lineReadFlag) {
            return null;
        } else {
            lineReadFlag = true;
            return line;
        }
        
    }
}

