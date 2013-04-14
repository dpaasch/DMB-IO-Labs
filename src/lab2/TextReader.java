package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextReader {

    private File dataFile = new File(File.separatorChar + "NetBeansTemp"
            + File.separatorChar + "ContactList.txt");
    private Contact contact;
    private BufferedReader reader = null;
    private String line = null;
    private String record = "";
    private int recordNum;
    private String INCORRECT_RECORD = "Incorrect record, only supposed to print"
            + " record #2.  Please try again.";

    public String readSingleRecord(int recordNum) {
        int counter = 0;
        try {
            if (dataFile.exists()) {
                reader = new BufferedReader(new FileReader(dataFile));
                line = reader.readLine();
                counter++;
                // if record is not record #2, print an error ...
                if (counter != 2 && recordNum != 2) {
                    System.out.println(INCORRECT_RECORD);
                }
                while (line != null) {
                    if (counter == 2 && recordNum == 2) {
                        getSplits();
                        System.out.println("Record #" + counter + " \n"
                                + contact.toString() + "\n");
                    }
                    line = reader.readLine();  // strips out any carriage return chars
                    counter++;
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
                System.out.println(ioe2);
            }
            System.out.println(ioe);
        } catch (ArrayIndexOutOfBoundsException oob) {
            System.out.println(oob);
        }
        return line;
    }

    /**
     * Method: getSplits() - takes the data from a file in the format of:
     * xxx|xxx|xxx, etc. and splits it into individual fields at each |
     *
     * @return splits
     */
    public String[] getSplits() {
        String[] splits = line.split("\\|");
        contact = new Contact();
        contact.setfirstName(splits[0]);
        contact.setlastName(splits[1]);
        contact.setAddress(splits[2]);
        contact.setCity(splits[3]);
        contact.setState(splits[4]);
        contact.setZipcode(splits[5]);
        contact.setEmail(splits[6]);
        contact.setPhoneNum(splits[7]);
        record += line;
        return splits;
    }

    public static void main(String[] args) {
        TextReader reader = new TextReader();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the record # to read: ");
        int rNum = keyboard.nextInt();
        reader.readSingleRecord(rNum);
    }
}
