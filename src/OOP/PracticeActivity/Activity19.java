package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity19 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("how many numbers they will enter");
        int num = sc.nextInt();

        int oddCount = 0;
        int evenCount = 0;

        for (int i = 1; i <= num; i++) {
            IO.println("Enter a number");
            int number = sc.nextInt();

            if (number % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        IO.println("Number of even numbers: " + evenCount);
        IO.println("Number of odd numbers: " + oddCount);
    }
}
