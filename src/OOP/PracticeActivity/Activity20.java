package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity20 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("Enter Number of students");
        int numStudents = sc.nextInt();

        int numPassed = 0;
        int numFailed = 0;

        for (int i = 1; i <= numStudents; i++) {
            IO.println("Enter student " + i + " grade :");
            int grade = sc.nextInt();

            if (grade >= 75) {
                IO.println("Passed");
                numPassed++;
            } else {
                IO.println("Failed");
                numFailed++;
            }

            IO.println();
        }

        IO.println("\n----- Summary -----");
        IO.println("Number of students passed: " + numPassed);
        IO.println("Number of students failed: " + numFailed);
        IO.println("Average grade: " + (numPassed + numFailed > 0 ? (double) (numPassed * 75 + numFailed * 74) / (numPassed + numFailed) : 0));
    }
}
