/**
 * Created by AnyaVinogradsky on 12/23/15.
 */

import java.io.*;
import java.util.*;

public class Remover {
    private final String toRemove;
    private final Scanner fileScanner;
    private final PrintStream outputStream;
    private final Scanner console = new Scanner(System.in);

    public Remover(String name, Scanner aFileScanner, PrintStream aOutputPrintStream) {
        toRemove = name.toLowerCase();
        fileScanner = aFileScanner;
        outputStream = aOutputPrintStream;
    }

    public void removeName() {
        ArrayList<String> names = getNames();
        ArrayList<Integer> indices = new ArrayList<>(0);
        ArrayList<String> toRemoveNames = new ArrayList<>(0);
        for (int ii = 0; ii < names.size(); ii++) {
            String name = names.get(ii).toLowerCase();
            int place = name.indexOf(toRemove);
            if (place != -1) {
                toRemoveNames.add(name);
                indices.add(ii);
            }
        }
        System.out.println("These names were found: ");
        for (int jj = 0; jj < toRemoveNames.size(); jj++) {
            System.out.printf("\n[%d] %s", jj, toRemoveNames.get(jj));
        }
        if (indices.size() == 0) {
            System.out.println("No names were found.");
        } else {
            System.out.print("\nWhich name would you like to remove? ");
            int wantToRemove = console.nextInt();
            while (wantToRemove >=indices.size() || wantToRemove < 0) {
                System.out.print("Enter an integer between 0 and " + (indices.size() - 1) + ": ");
                wantToRemove = console.nextInt();
            }
            int index = indices.get(wantToRemove);
            names.remove(index);
            printNewNames(names);
            System.out.println("Success!");
        }
    }

    private void printNewNames(ArrayList<String> names) {
        for (String name : names) {
            outputStream.println(name);
        }
    }

    private ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>(0);
        while (fileScanner.hasNextLine()) {
            names.add(fileScanner.nextLine());
        }
        return names;
    }
}
