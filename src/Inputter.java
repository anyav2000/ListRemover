/**
 * Created by AnyaVinogradsky on 12/23/15.
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Inputter {

    public static Scanner getFileScanner(Scanner console, String firstFile) {
        Scanner fileScan = null;
        boolean keepRunning;
        File inputFile = Paths.get("src").toAbsolutePath().resolve(firstFile).toFile();
        try {
            fileScan = new Scanner(inputFile);
            keepRunning = false;
        } catch (FileNotFoundException e) {
            System.out.print("File not found. Try again: ");

            keepRunning = true;
        }
        while (keepRunning) {
            String file = console.next();
            inputFile = Paths.get("").toAbsolutePath().resolve(file).toFile();
            try {
                fileScan = new Scanner(inputFile);
                keepRunning = false;
            } catch (FileNotFoundException e) {
                System.out.print("File not found. Try again: ");
                keepRunning = true;
            }
        }
        return fileScan;
    }

    public static PrintStream getOutputStream(Scanner console, String firstFile) {
        PrintStream output = null;
        boolean keepRunning;
        File outputFile = Paths.get("src").toAbsolutePath().resolve(firstFile).toFile();
        try {
            output = new PrintStream(outputFile);
            keepRunning = false;
        } catch (FileNotFoundException e) {
            System.out.print("Error opening file for write. Try again: ");
            keepRunning = true;
        }
        while (keepRunning) {
            String file = console.next();
            outputFile = Paths.get("").toAbsolutePath().resolve(file).toFile();
            try {
                output = new PrintStream(outputFile);
                keepRunning = false;
            } catch (FileNotFoundException e) {
                System.out.print("Error opening file for write. Try again: ");
                keepRunning = true;
            }
        }
        return output;
    }

    public static int getNumber(Scanner console, String prompt, int max) {
        System.out.print(prompt);
        int input = 0;
        boolean keepRunning = true;
        while (keepRunning){
            if (!console.hasNextInt()) {
                System.out.print("Input is not valid, you need to enter a number between 0 and " + max +".");
                System.out.print(prompt);
                console.next();
                keepRunning = true;
            }
            else if (console.hasNextInt()) {
                input = console.nextInt();
                if (input < 0 || input > max) {
                    System.out.print("Input is not valid, you need to enter a number between 0 and " + max +".");
                    System.out.print(prompt);
                    console.next();
                    keepRunning = true;
                } else {
                    keepRunning = false;
                }
            }
        }
        return input;
    }
}

