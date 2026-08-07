package OOP;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        welcomeMessage();

        System.out.print("\nPlease enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Birth Year (e.g., 2005): ");
        int birthYear = scanner.nextInt();

        Student student = new Student(name, birthYear);

        student.greetings();

        int retirementAge = retirementYear(student.getBirthYear());
        System.out.println("You will retire after " + retirementAge + " more years.");
    }

    static void welcomeMessage() {
        System.out.println("====================================");
        System.out.println(" WELCOME 2ND YEAR OOP JAVA STUDENTS!");
        System.out.println("====================================");
    }

    static int retirementYear(int birthYear) {
        return 60 - (2026 - birthYear);
    }
}
