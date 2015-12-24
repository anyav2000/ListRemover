/**
 * Created by AnyaVinogradsky on 12/23/15.
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Who would you like to remove? ");
        String name = console.nextLine();
        System.out.print("In what file are the names stored? ");
        String filename = console.next();
        Scanner fileScanner = Inputter.getFileScanner(console, filename);
        System.out.print("To what file should the names be outputted to? ");
        String output = console.next();
        PrintStream outputStream = Inputter.getOutputStream(console, output);
        Remover list = new Remover(name, fileScanner, outputStream);
        list.removeName();
    }
}
