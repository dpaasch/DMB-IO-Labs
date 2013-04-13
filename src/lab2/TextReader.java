package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class TextReader implements ReaderStrategy {

    private Contact contact;
    private boolean lineReadFlag = false;
    private BufferedReader reader = null;
    private String line = null;
    private String record = "";
    private int recordNum;

    @Override
    public String searchForSingleRecord(int recordNum) {
        File dataFile = new File(File.separatorChar + "NetBeansTemp"
                + File.separatorChar + "ContactList.txt");
        int counter = 1;
        try {
            if (dataFile.exists()) {
                reader = new BufferedReader(new FileReader(dataFile));
                line = reader.readLine();
                while (line != null) {
                    line = reader.readLine();  // strips out any carriage return chars
                    counter++;
                    if (counter == recordNum) {
                        getSplits();
//                        record += line;
                        JOptionPane.showMessageDialog(null, "Record #" + counter
                                + "\n" + contact.toString());
                    }
                    line = reader.readLine();  // strips out any carriage return chars
                    counter++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "File not found - " + dataFile);
            }
        } catch (IOException ioe) {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ioe2) {
                JOptionPane.showMessageDialog(null, ioe2.getMessage());
            }
            JOptionPane.showMessageDialog(null, ioe.getMessage());
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException oob) {
            JOptionPane.showMessageDialog(null, oob.getMessage());
        }
        if (lineReadFlag) {
            return null;
        } else {
            lineReadFlag = true;
            return line;
        }
    }

    public int getRecordNum() {
        return recordNum;
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
}