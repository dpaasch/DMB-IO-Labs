package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvFileWriter implements FileWriterStrategy {

    // Scanner object for user input
    Scanner input = new Scanner(System.in);
    // CsvFileWriter variables
    private String fileName;
    // CsvFileWriter error messages
    private String EOF_NULL_MSG = "End of File or null encountered ... Exiting";


    @Override
    public void writeln(String inputData) {
        // local variables
        boolean append = true;
        File dataFile = new File(File.separatorChar + "NetBeansTemp"
                + File.separatorChar + "ContactList.csv");
        PrintWriter writer = null;
        try {

            // if the file does not exist, it will automatically be created.
            if (!dataFile.exists()) {
                System.out.println("Creating file: "
                        + dataFile.getCanonicalPath());
                dataFile.createNewFile();
            }
            // create the writer object.
            writer = new PrintWriter(
                    new BufferedWriter(
                    new java.io.FileWriter(dataFile, append)));

            // Validate that the input data is not null
            if (!inputData.isEmpty()) {
                writer.println(inputData);
                System.out.println("Write successful.");
                writer.close();
            } else {        
                throw new NullPointerException();
            }
        } catch (NullPointerException npe) {
            System.err.println(EOF_NULL_MSG);
        } catch (IOException ioe) {
            if (writer != null) {
                writer.close();
            }
            System.err.println(ioe.getMessage());
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        CsvFileWriter writer = new CsvFileWriter();
        writer.writeln("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072,mydaddysingstoo@gmail.com,262-691-0098");
        writer.writeln("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072,mydaddysingstoo@gmail.com,262-691-0098");
        writer.writeln("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072,mydaddysingstoo@gmail.com,262-691-0098");
        writer.writeln("Pam,Tillis,418 Westfield Way,Pewaukee,WI,53072,mydaddysingstoo@gmail.com,262-691-0098");
                writer.writeln(null);
//                writer.writeln("EOF");
    }
}
