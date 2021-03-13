package Lab4_2;

import Lab4_1.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<Customer> customers = new ArrayList<>(); // create an ArrayList object
        Scanner scanner;
        String strLine;
        try {
            scanner = new Scanner(new File("lab4_2_input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        ArrayList<Person> persons = new ArrayList<>();
        Customer newCustomer = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] items = line.split(",");
            String str1stItem = items[0].trim();
            // trim: eliminates leading and trailing spaces
            if (str1stItem.equals("Customer")) {
                String firstName = items[1].trim();
                String lastName = items[2].trim();
                newCustomer = new Customer(firstName, lastName);
                customers.add(newCustomer);
            } else if (str1stItem.equals("Account")) {
                String accountNumber = items[1].trim();
                int balance = Integer.parseInt(items[2].trim());
                if ( newCustomer == null ) {
                    System.out.println("No customer for adding account: " + accountNumber);
                } else {  
                    BankAccount newBankAccount = new BankAccount((accountNumber));
                    newCustomer.addAccount(newBankAccount);
                    newBankAccount.deposit(balance);
                }
            } else {
                System.out.println("unknown operater: " + str1stItem);
            }
        }
        scanner.close();
        System.out.println("---Print the customers");
        for (Customer c: customers) {
            System.out.println(c);
        }
    }
}