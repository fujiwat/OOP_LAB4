package Lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class

public class Main {

    public static void main(String[] args) {
        // write your code here
        readFilePrintItsLineNumbered("lab4_1_input.txt");

    }

    public static void readFilePrintItsLineNumbered(String fileName) {
        // Open the file
        Scanner scanner;
        String strLine;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // read file
        for (int i = 0; scanner.hasNextLine(); i++) {
            strLine = scanner.nextLine();
            System.out.println(i+1 + " " + strLine);
        }
        scanner.close();

        ArrayList<Person> person;   // create an ArrayList object
        person = Person.readFromCSVFile("lab4_1_input.csv");
        System.out.println(person);
    }

}
