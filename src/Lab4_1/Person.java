package Lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    // constructor
    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    // getter
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    // setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static ArrayList<Person> readFromCSVFile(String fileName) {
        // Open the file
        Scanner scanner;
        String strLine;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        ArrayList<Person> persons = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] items = line.split(",");
            // trim: eliminates leading and trailing spaces
            String firstName = items[0].trim();
            String lastName = items[1].trim();
            // Convert String → int: Integer.parseInt( String)
            int birtYear = Integer.parseInt(items[2].trim());
            persons.add(new Person(firstName, lastName, birtYear));
        }
        scanner.close();
        return persons;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

}
