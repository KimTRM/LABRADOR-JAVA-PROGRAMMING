package Grade11.looping;

import java.util.Scanner;

public class Labrador_Act2 {

    static void main(String[] args) {
        int seconds, minutes, hours, days, num;
        int x = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("How many times do you want to calculate? ");
        num = input.nextInt();

        while (x <= num) {


            System.out.print("Enter the number of seconds: ");
            seconds = input.nextInt();

            if (seconds < 3600) {
                minutes = seconds / 60;
                System.out.println("output: " + minutes + " minutes\n");

            } else if (seconds < 86400) {
                hours = seconds / 3600;
                System.out.println("output: " + hours + " hours\n");

            } else if (seconds >= 86400) {
                days = seconds / 86400;
                System.out.println("output: " + days + " days\n");

            }
            x++;
        }
    }
}
