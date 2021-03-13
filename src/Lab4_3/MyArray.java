package Lab4_3;

import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class

public class MyArray {
    private int length;
    private double[] elements;

    // constructor

    public MyArray(int length) {
        this.elements = new double[length];
        this.length = length;
    }

    public MyArray(double[] elements) {
        this.elements = elements;           // ??: is it correct?
        this.length = elements.length;      // ??: is it correct?
    }

    public MyArray(MyArray myArray) {
        this.length = myArray.length;
        this.elements = myArray.elements; // ??: maybe wrong
    }

    public MyArray(String fileName) {
        Scanner scanner;
        MyArray myArray;
        boolean lineOk;
        String line;
        int length = 0;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        lineOk = false;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] items = line.split(" /");
            length = Integer.parseInt(items[0].trim());
            lineOk = true;
            break;
        }
        if (lineOk == false) {
            System.out.printf("Error!  can not find number of elements. file=%s", fileName);
            return;
        }

        lineOk = false;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] items = line.split(" ");
            double[] itemD = new double[length];
            int itemsLength = items.length;
            for (int i = 0; i < itemsLength; i++) {
                try {
                    itemD[i] = Double.parseDouble(items[i].trim());
                } catch (NumberFormatException e) {
                    itemsLength = i;
                    break;
                }
            }
            if (length < itemsLength) {
                System.out.printf("Warning: 1 line (%d: number of elements) is smaller than the 2nd line values(=%d) -- assume it with the 2nd lines", length, items.length);
                length = items.length;
            }
            if (itemsLength < length) {
                System.out.printf("Warning: 1 line (%d: number of elements) is larger than the 2nd line values(=%d) -- assume it with the 1nd lines", length, items.length);
                length = items.length;
            }
            // ??:  following 3 lines are works but I want to know more good solution.
            this.elements = new double[itemsLength];
            System.arraycopy(itemD, 0, this.elements, 0, itemsLength);
            this.length = itemsLength;
            lineOk = true;
        }
        if (lineOk == false) {
            System.out.printf("Error!  can not find values (2nd line). file=%s", fileName);
            return;
        }
    }

    public void fillRandom(double a, double b) {
        Random rand = new Random();
        for (int i = 0; i < this.length; i++) {
            this.elements[i] = rand.nextDouble() * (b - a) + a;
        }
    }

    public double mean() {
        double total = 0;
        for (int i = 0; i < this.length; i++) {
            total += this.elements[i];
        }
        return total / this.length;
    }

    public double stddev() {
        double total_x_m = 0;
        double mean = this.mean();
        for (int i=0; i<this.length; i++){
             total_x_m += (this.elements[i] - mean) * (this.elements[i] - mean);
        }
        return Math.sqrt(total_x_m / this.length);
    }

    public void sort() {
        Arrays.sort(this.elements);
    }
    public void print(String header) {
        System.out.print(header + ":  ");
        for (int i = 0; i < this.length; i++) {
            System.out.printf("%7.2f", this.elements[i]);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(String.format("MyAccount: length=%-5d value =", this.length));
        for (int i = 0; i < this.length; i++) {
            s.append(String.format(" [%s]", this.elements[i]));
        }
        return s.toString();
    }

}
