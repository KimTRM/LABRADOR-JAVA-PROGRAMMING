package LABRADOR_PROG2.firstprogram;

import java.util.Scanner;

public class Decesion_Structure {

    @SuppressWarnings("ConvertToTryWithResources")
    static void main(String[] args) {

        int x, y;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number:");
        x = input.nextInt();
        System.out.print("Enter a number:");
        y = input.nextInt();

        if (x > 4) {
            System.out.print("one ");
            if (y > 5)
                System.out.print("two ");
            else
                System.out.print("three");
        } else {
            System.out.print("four ");
            if (y < 3)
                System.out.print("five ");
            else
                System.out.print("six");
        }

        input.close();
    }

}
