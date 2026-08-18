package Intro_to_Prog;

import java.util.Scanner;

public class Task07_Labrador_KimLouise_LogicalOperatorsActivity {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Do you have an ID? (true/false): ");
        boolean hasID = scanner.nextBoolean();

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();

        // Logical conditions
        boolean canEnter = (age >= 18) && hasID;                 // Entry Rule
        boolean withDiscount = isStudent || (age < 18);          // Discount Rule
        boolean minorWithoutID = (age < 18) && !hasID;           // Minor without ID
        boolean seniorWithPrivilege = (age >= 60) && (isStudent || hasID); // Senior Privilege

        // Output
        System.out.println("\n--- Event Entry Report ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Has ID: " + hasID);
        System.out.println("Is OOP.ClassDirectoryRecordingApp.Student: " + isStudent);

        System.out.println("\nResults:");
        System.out.println("Can enter the event: " + canEnter);
        System.out.println("With Discount: " + withDiscount);
        System.out.println("Minor without ID: " + minorWithoutID);
        System.out.println("Senior with privilege: " + seniorWithPrivilege);

        scanner.close();
    }
}
