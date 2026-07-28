package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity12 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("Enter Purchase Amount");
        float purchaseAmount = sc.nextFloat();

        IO.println("Are you a Member (true/false)");
        boolean isMember = sc.nextBoolean();

        if (purchaseAmount >= 1000 || isMember)
            IO.println("You are eligible for a discount.");
        else
            IO.println("You are not eligible for a discount.");
    }
}
