package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity7 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("What is your age?");
        int Age = sc.nextInt();

        if (Age < 18)
            IO.println("You are eligible to vote.");
    }
}
