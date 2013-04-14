package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Find the second record in your three record text file and make it flexible so 
 * that you can change the record number that you are search for. Then display 
 * that record by itself at the console.
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextReader_orig {

    public static void main(String[] args) throws IOException {
        // Create a Scanner Object to hold the data entered from the user
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What record # do you want to read?");
        int lineNumber = keyboard.nextInt();

        File dataFile = new File(File.separatorChar + "NetBeansTemp" 
                + File.separatorChar + "ContactList.txt");

        BufferedReader reader = null;
        String record = "";
        int counter = 1;
        try {
            reader = new BufferedReader(new FileReader(dataFile));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();  // strips out any carriage return chars
                counter++;
                if (line != null && counter == lineNumber) {
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
        System.out.println("Printing record #" + lineNumber);
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
