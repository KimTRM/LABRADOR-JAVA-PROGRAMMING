package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity9 {
    static void main() {
        Scanner input = new Scanner(System.in);

        IO.println("Enter a grade");
        int grade = input.nextInt();

        if (grade >= 90 && grade <= 100)
            IO.println("Excellent");
        else if (grade >= 85 && grade < 89)
            IO.println("Very Good");
        else if (grade >= 80 && grade < 84)
            IO.println("Good");
        else if (grade >= 75 && grade < 79)
            IO.println("Fair");
        else
            IO.println("Failed");

    }
}
