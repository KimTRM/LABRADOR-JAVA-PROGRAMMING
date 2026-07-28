package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity15 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("How many numbers do you want to enter?");
        int num = sc.nextInt();

        int i = 1;
        int sum = 0;
        while (i <= num) {
            IO.println("Enter a number");
            int number = sc.nextInt();

            sum += number;
            i++;
        }

        IO.println(sum);
    }
}
