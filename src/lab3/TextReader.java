package lab3;

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

    public void readSingleRecord(int recordNum) {

        int counter = 0;
        try {
            reader = new BufferedReader(new FileReader(dataFile));
            line = reader.readLine();
            counter++;
            while (line != null) {
                line = reader.readLine();
                counter++;
                if (counter == 2) {
                    getSplits();
                    System.out.println("Print Record #" + counter + " City only\n"
                            + contact.getCity() + "\n");
                }
                line = reader.readLine();  // strips out any carriage return chars
                counter++;
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
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException oob) {
            System.out.println(oob);
        }
    }

    /**
     * Method: getSplits() - takes the data from a file in the format of:
     * xxx|xxx|xxx, etc. and splits it into individual fields at each |
     *
     * @return splits
     */
    public String[] getSplits() {
        String[] splits = line.split("\\|");;
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
        reader.readSingleRecord(2);
    }
}
