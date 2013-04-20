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
    private final String NPE_EX = "End of File or null encountered ... Exiting";
    private final String IA_EX = " invalid: File name must end in .csv";
    
    @Override
    public void writeln(String inputData) {
        // local variables
        boolean append = true;
        getFileName(fileName);
        File dataFile = new File(File.separatorChar + "NetBeansTemp"
                + File.separatorChar + fileName);
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
            System.err.println(NPE_EX);
        } catch (IOException ioe) {
            if (writer != null) {
                writer.close();
            }
            System.err.println(ioe.getMessage());
            System.exit(0);
        }
    }

    public String getFileName(String fileName) {
        // local Variable
        String csv = ".csv";
        try {
            System.out.println("Enter the file name as filename.csv");
            String fn = input.nextLine();
            // verify file name is not blank
            if (fn != null || fn.length() != 0) {
                // verify file name ends with a .csv extension
                if (!fn.endsWith(csv)) {
                    fileName = fn;
                    return fileName;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            return fileName;

        } catch (IllegalArgumentException iae) {
            System.err.println(IA_EX);
        }
        return null;
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
