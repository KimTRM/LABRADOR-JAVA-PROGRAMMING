package Intro_to_Prog;

import java.util.Scanner;

public class TASK04_ProblemStatement2_Labrador_Kim_Louise {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student name
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        // Input numerical grade
        System.out.print("Enter numerical grade: ");
        double grade = scanner.nextDouble();

        // Convert to letter grade
        String letterGrade;
        if (grade >= 90) {
            letterGrade = "A";
        } else if (grade >= 80) {
            letterGrade = "B";
        } else if (grade >= 70) {
            letterGrade = "C";
        } else if (grade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        // Output results
        System.out.println("\nOOP.ClassDirectoryRecordingApp.Student Name: " + studentName);
        System.out.println("Numerical Grade: " + grade);
        System.out.println("Letter Grade: " + letterGrade);

        scanner.close();
    }
}
