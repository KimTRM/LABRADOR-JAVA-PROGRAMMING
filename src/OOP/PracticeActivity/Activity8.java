package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity8 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("Enter a grade");
        int grade = sc.nextInt();

        if (grade >= 75)
            IO.println("You passed the subject");
        else
            IO.println("You failed the subject");
    }
}
