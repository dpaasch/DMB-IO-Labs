package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFileWriter implements FileWriterStrategy {

    @Override
    public void writeln(String line) {
        boolean append = true;
        File dataFile = new File(File.separatorChar + "NetBeansTemp"
                + File.separatorChar + "ContactList.txt");
        PrintWriter writer = null;

        try {

            writer = new PrintWriter(
                    new BufferedWriter(
                    new java.io.FileWriter(dataFile, append)));
            writer.println(line);
            writer.close();

        } catch (IOException ioe) {
            if (writer != null) {
                writer.close();
            }
            System.out.println(ioe.getMessage());
            System.exit(1);  // 1 = signals program end with error
        }
    }
    public static void main(String[] args) {
        TextFileWriter writer = new TextFileWriter();
        writer.writeln("Pam|Tillis|418 Westfield Way|Pewaukee|WI|53072|mydaddysingstoo@gmail.com|262-691-0098");
        
    }
}
