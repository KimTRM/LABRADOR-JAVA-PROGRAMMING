package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity17 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.print("Enter an integer: ");
        int num = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            IO.println(num + " x " + (i + 1) + " = " + (num * (i + 1)));
        }
    }
}
