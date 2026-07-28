package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity10 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("Enter your age");
        int age = sc.nextInt();

        IO.println("Are you an Filipino Citizen (true/false)");
        boolean isFilipino = sc.nextBoolean();

        if (age >= 18) {
            if (isFilipino)
                IO.println("You are eligible to vote.");
        } else
            IO.println("You are not eligible to vote.");

    }
}
