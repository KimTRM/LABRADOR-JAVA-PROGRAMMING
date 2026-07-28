package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity6 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("Enter you English Grade");
        float english = sc.nextFloat();

        IO.println("Enter your Math Grade");
        float mathematics = sc.nextFloat();

        IO.println("Enter your Science Grade");
        float science = sc.nextFloat();

        IO.println("\n Average Grade: " + (english + mathematics + science) / 3);
    }
}
