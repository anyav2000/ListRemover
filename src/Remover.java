/**
 * Created by anyav2000 on 12/23/15.
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
            System.out.printf("\n[%d] %s", jj, capitalizeFirst(toRemoveNames.get(jj)));
        }
        if (indices.size() == 0) {
            System.out.println("No names were found.");
        } else {
            int wantToRemove = Inputter.getNumber(console, "\nWhich name would you like to remove? ", indices.size() -1);
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

    private String capitalizeFirst(String name) {
        Scanner nameScan = new Scanner(name);
        String capitalized;
        String firstName = nameScan.next();
        capitalized = ("" + firstName.charAt(0)).toUpperCase();
        capitalized = capitalized + firstName.substring(1, firstName.length()) + " ";
        String lastName = nameScan.next();
        capitalized = capitalized + (""+ lastName.charAt(0)).toUpperCase();
        capitalized = capitalized + lastName.substring(1, lastName.length());
        return capitalized;

    }

}
