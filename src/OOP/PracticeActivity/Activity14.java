package OOP.PracticeActivity;

import java.util.Scanner;

public class Activity14 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("Enter a positive integer");
        int num = sc.nextInt();

        int tempt = 1;
        while (tempt <= num) {
            IO.println(tempt);
            tempt++;
        }
    }
}
