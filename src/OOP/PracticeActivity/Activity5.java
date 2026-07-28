package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity5 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("Enter integer 1:");
        int num1 = sc.nextInt();

        IO.println("Enter integer 2:");
        int num2 = sc.nextInt();

        IO.println("----- Arithmetic Operations -----");
        IO.println("Sum: " + (num1 + num2));
        IO.println("Difference: " + (num1 - num2));
        IO.println("Product: " + (num1 * num2));
        IO.println("Quotient: " + (num1 / num2));
        IO.println("Remainder: " + (num1 % num2));
    }
}
