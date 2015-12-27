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
                toRemoveNames.add(names.get(ii));
                indices.add(ii);
            }
        }

        if (indices.size() == 0) {
            System.out.println("No names were found.");
        }
        else {
            System.out.println("These names were found: ");
            for (int jj = 0; jj < toRemoveNames.size(); jj++) {
                System.out.printf("\n[%d] %s", jj, toRemoveNames.get(jj));
            }

            int wantToRemove = 0;
            if(indices.size() > 1) {
                wantToRemove = getNumber(console, "\nWhich name would you like to remove? ", indices.size());
            }

            names.remove((int)indices.get(wantToRemove));
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

    private int getNumber(Scanner console, String prompt, int max) {
        while(true) {
            System.out.print(prompt);
            String input = console.next();
            try {
                int index = Integer.parseInt(input);
                if(index >= 0 && index < max)
                    return index;
            }
            catch(NumberFormatException e){
            }
            System.out.print("Input is not valid. Enter a number between 0 and " + max + ".");
        }
    }
}
