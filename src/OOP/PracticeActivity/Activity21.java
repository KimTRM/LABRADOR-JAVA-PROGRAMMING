package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity21 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.print("Whole number: ");
        int num = sc.nextInt();

        IO.print("Exponent: ");
        int exp = sc.nextInt();

        int result = 1;

        for (int i = 1; i <= exp; i++)
            result *= num;

        IO.println("\nAnswer: " + result);
    }
}
