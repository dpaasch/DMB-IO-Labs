package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class CsvFileReader implements FileReaderStrategy {

    @Override
    public String readln() {

        File dataFile = new File(File.separatorChar + "NetBeansTemp"
                + File.separatorChar + "ContactList.txt");
        BufferedReader reader = null;
        String line = null;

        try {
            if (dataFile.exists()) {
                reader = new BufferedReader(new java.io.FileReader(dataFile));
                line = reader.readLine();
                reader.close();
            } else {
                System.out.println("File not found - ContactList.txt");
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
            System.exit(1);  // 1 = signals program end with error
        }
        return line;
    }
    
    public static void main(String[] args) {
        CsvFileReader reader = new CsvFileReader();
        System.out.println(reader.readln());
    }
}
