package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity3 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("What is your student number?");
        int studentNumber = sc.nextInt();

        IO.println("What is your name?");
        String fullName = sc.nextLine();

        IO.println("What is your course?");
        String Course = sc.nextLine();

        IO.println("What is your age?");
        int Age = sc.nextInt();

        IO.println("\n----- Student Information-----");
        IO.println("Student Number: " + studentNumber);
        IO.println("Full Name: " + fullName);
        IO.println("Course: " + Course);
        IO.println("Age: " + Age);
    }
}
