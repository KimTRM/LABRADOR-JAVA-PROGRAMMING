package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity4 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("What is your name?");
        String name = sc.nextLine();

        IO.println("What is your age?");
        int age = sc.nextInt();

        IO.println("What is your address?");
        String address = sc.nextLine();

        IO.println("What is your favorite food?");
        String favoriteFood = sc.nextLine();

        IO.println("What is your favorite color?");
        String favoriteColor = sc.nextLine();

        IO.println("“Hello!\n" +
                "\n" +
                "My name is " + name + ".\n" +
                "I am " + age + " years old.\n" +
                "I live in " + address + "\n" +
                "My favorite food is " + favoriteFood + ".\n" +
                "My favorite color is " + favoriteColor + ".”\n");
    }
}
