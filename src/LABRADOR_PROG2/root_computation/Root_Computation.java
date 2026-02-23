package LABRADOR_PROG2.root_computation;

import java.io.*;
import java.util.Scanner;

public class Root_Computation {

    static void main(String[] args) throws IOException {
        FileWriter fwriter = new FileWriter("record.txt", true);
        PrintWriter outputFile = new PrintWriter(fwriter);
        Scanner input = new Scanner(System.in);
        for (int x = 1; x <= 10; x++) {

            System.out.println("Enter A ");
            int a = input.nextInt();

            System.out.println("Enter B ");
            int b = input.nextInt();

            System.out.println("Enter C ");
            int c = input.nextInt();


            outputFile.print(a + ", " + b + ", " + c + "\n");


            outputFile.close();
            System.out.println("File written");
        }

    }

}
