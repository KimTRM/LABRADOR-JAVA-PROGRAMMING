package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity11 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("What is your average grade: ");
        int average = sc.nextInt();

        IO.println("What is your attendance grade: ");
        int attendance = sc.nextInt();

        if (average >= 90 && attendance >= 95)
            IO.println("You qualified for the scholarship");
        else
            IO.println("You did not qualify for the scholarship");
    }
}
