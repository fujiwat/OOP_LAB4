package Lab4_3;

public class Main {

    public static void main(String[] args) {
        // write your code here
        MyArray a1 = new MyArray(10);
        a1.print("a1");
        a1.fillRandom(0, 9);
        a1.print("a1");
        a1.sort();
        a1.print("a1");
        System.out.printf("\tMean: %10.2f Stddev: %10.2f\n",
                a1.mean(), a1.stddev());
        double[] t = {4, 9, 0, -34, 28, 76, 100, -1};
        MyArray a2 = new MyArray(t);
        a2.print("a2");
        a2.sort();
        a2.print("a2");
        System.out.printf("\tMean: %10.2f Stddev: %10.2f\n",
                a2.mean(), a2.stddev());
        MyArray a3 = new MyArray("lab4_3_input.txt");
        a3.print("a3");
        MyArray a4 = new MyArray(a3);
        a3.sort();
        a3.print("a3");
        System.out.printf("\tMean: %10.2f Stddev: %10.2f\n",
                a3.mean(), a3.stddev());
        a4.print("a4");

//
//        MyArray myArray = new MyArray("lab4_3_input.txt");
//        System.out.println("readFile:   " + myArray.toString());
//        myArray.fillRandom(1.5, 1.6);
//        System.out.println("fillRandom: " + myArray.toString());

    }
}
