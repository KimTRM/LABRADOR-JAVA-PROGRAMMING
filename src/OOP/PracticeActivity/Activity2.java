package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity2 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("What is your name?");
        String name = sc.nextLine();

        IO.println("Hello " + name + ". Welcome to Java Programming!");
    }
}
