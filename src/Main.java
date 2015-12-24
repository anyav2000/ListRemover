/**
 * Created by anyav2000 on 12/23/15.
 */
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    static private Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        if(args.length < 2)
        {
            System.out.println("Provide command line arguments: input_file output_file");
            return;
        }

        System.out.print("Who would you like to remove? ");
        String name = console.nextLine();

        Scanner fileScanner = getFileScanner(args[0]);

        PrintStream outputStream = getOutputStream(args[1]);

        Remover list = new Remover(name, fileScanner, outputStream);
        list.removeName();
    }

    private static Scanner getFileScanner(String fileName) throws Exception {
        File inputFile = Paths.get("src").toAbsolutePath().resolve(fileName).toFile();
        try {
            return new Scanner(inputFile);

        } catch (Exception e) {
            System.out.printf("Error %s creating a scanner for the file %s.", e.toString(), inputFile.getAbsolutePath());
            throw e;
        }
    }

    private static PrintStream getOutputStream(String fileName) throws Exception {
        File outputFile = Paths.get("src").toAbsolutePath().resolve(fileName).toFile();
        try {
            return new PrintStream(outputFile);
        } catch (FileNotFoundException e) {
            System.out.printf("Error %s creating a stream for the file %s.", e.toString(), outputFile.getAbsolutePath());
            throw e;
        }
    }
}
