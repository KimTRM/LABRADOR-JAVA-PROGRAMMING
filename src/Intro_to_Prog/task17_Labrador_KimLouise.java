package Intro_to_Prog;

import java.util.Scanner;

public class task17_Labrador_KimLouise {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            // Asks the user for the number of students
            System.out.println("\nOOP.ClassDirectoryRecordingApp.Student Information Analytics System\n");
            System.out.print("Number of Students: ");
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine();

            // Declares arrays to store student information
            String[] names = new String[numberOfStudents];
            double[] prelimGrades = new double[numberOfStudents];
            double[] midtermGrades = new double[numberOfStudents];
            double[] finalGrades = new double[numberOfStudents];
            double[] totalAverage = new double[numberOfStudents];
            char[] letterGrades = new char[numberOfStudents];

            // Loops through each student to collect their information
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("\nOOP.ClassDirectoryRecordingApp.Student #" + (i + 1));
                System.out.print("Enter name: ");
                names[i] = scanner.nextLine();

                // Gets grades for prelim, midterm, and final
                prelimGrades[i] = getGrade(scanner, "Prelim");
                midtermGrades[i] = getGrade(scanner, "Midterm");
                finalGrades[i] = getGrade(scanner, "Final");

                // Calculates the average and determines the letter grade
                totalAverage[i] = (prelimGrades[i] + midtermGrades[i] + finalGrades[i]) / 3;
                letterGrades[i] = determineLetterGrade(totalAverage[i]);

                scanner.nextLine();
            }

            // Prints the Summary Table
            printSummary(names, prelimGrades, midtermGrades, finalGrades, totalAverage, letterGrades);

            // Prints the Analysis Results
            printAnalysis(names, totalAverage, letterGrades);

            // Asks the user if they want to try again
            System.out.print("\nDo you want to try again: (Y/N): ");
            choice = scanner.nextLine().toUpperCase().charAt(0);
        } while (choice == 'Y');

        scanner.close();
    }

    // Prompts user for a grade and validates it is between 0 and 100
    public static double getGrade(Scanner scanner, String gradeType) {
        while (true) {
            System.out.print("Enter " + gradeType + " Grade (0-100): ");

            double grade = scanner.nextDouble();
            boolean isValidGrade = grade >= 0 && grade <= 100;

            if (isValidGrade)
                return grade;

            System.out.println("Invalid Grade (0-100) only, Please Try Again");
        }
    }

    // Determines the letter grade based on the average score
    public static char determineLetterGrade(double average) {
        if (average >= 96)
            return 'A';
        else if (average >= 90)
            return 'B';
        else if (average >= 80)
            return 'C';
        else if (average >= 70)
            return 'D';
        else
            return 'F';
    }

    // Prints a summary table of all student grades
    public static void printSummary(String[] names, double[] prelimGrades, double[] midtermGrades, double[] finalGrades, double[] totalAverage, char[] letterGrade) {
        System.out.println("\n====================================================");
        System.out.println("STUDENT SUMMARY");
        System.out.println("====================================================");

        System.out.printf("%-20s %7s %7s %7s %9s %7s\n",
                "Name", "Prelim", "Midterm", "Final", "Average", "Grade");
        System.out.println("----------------------------------------------------");

        // Loops through and prints each student's information
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-20s %7.2f %7.2f %7.2f %9.2f %7c\n",
                    names[i], prelimGrades[i], midtermGrades[i],
                    finalGrades[i], totalAverage[i], letterGrade[i]);
        }
    }

    // Prints analysis results including highest/lowest averages, class average, and grade distribution
    public static void printAnalysis(String[] names, double[] totalAverage, char[] letterGrade) {
        System.out.println("\n====================================================");
        System.out.println("ANALYSIS RESULTS");
        System.out.println("====================================================");

        // Finds the student with the highest average
        double highestAverage = totalAverage[0];
        String highestStudent = names[0];

        for (int i = 1; i < names.length; i++) {
            if (totalAverage[i] > highestAverage) {
                highestAverage = totalAverage[i];
                highestStudent = names[i];
            }
        }
        System.out.printf("Highest Average: %s - %.2f\n", highestStudent, highestAverage);

        // Finds the student with the lowest average
        double lowestAverage = totalAverage[0];
        String lowestStudent = names[0];

        for (int i = 1; i < names.length; i++) {
            if (totalAverage[i] < lowestAverage) {
                lowestAverage = totalAverage[i];
                lowestStudent = names[i];
            }
        }
        System.out.printf("Lowest Average: %s - %.2f\n", lowestStudent, lowestAverage);

        // Calculates the class average
        double sum = 0;
        for (int i = 0; i < names.length; i++) {
            sum += totalAverage[i];
        }

        double classAverage = sum / names.length;
        System.out.printf("Class Average: %.2f\n", classAverage);

        // Counts the number of students for each letter grade
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int i = 0; i < names.length; i++) {
            switch (letterGrade[i]) {
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                case 'F':
                    countF++;
                    break;
            }
        }

        // Prints the grade distribution
        System.out.println("\nGrade Distribution:");
        System.out.println("A: " + countA + " student(s)");
        System.out.println("B: " + countB + " student(s)");
        System.out.println("C: " + countC + " student(s)");
        System.out.println("D: " + countD + " student(s)");
        System.out.println("F: " + countF + " student(s)");
    }

}