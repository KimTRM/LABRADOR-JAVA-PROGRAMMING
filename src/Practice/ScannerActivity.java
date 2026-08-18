package Practice;

import java.util.Scanner;

public class ScannerActivity {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;

        System.out.print("Enter a the Name of the OOP.ClassDirectoryRecordingApp.Student: ");
        name = scanner.nextLine();

        System.out.print("Enter a the Age of the OOP.ClassDirectoryRecordingApp.Student: ");
        age = scanner.nextInt();

        System.out.print("Enter the Monthly Allowance of the OOP.ClassDirectoryRecordingApp.Student: ");
        double allowance = scanner.nextDouble();

        System.out.println("OOP.ClassDirectoryRecordingApp.Student Name: " + name);
        System.out.println("OOP.ClassDirectoryRecordingApp.Student Age: " + age);

        if (age >= 18)
            System.out.println(name + " is an adult.");
        else
            System.out.println(name + " is still a minor.");

        System.out.println("OOP.ClassDirectoryRecordingApp.Student Monthly Allowance: " + allowance);

        scanner.close();
    }
}
