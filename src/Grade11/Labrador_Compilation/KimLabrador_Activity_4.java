package Grade11.Labrador_Compilation;

import java.util.Scanner;

public class KimLabrador_Activity_4 {

    static void main(String[] args) {
        char ch = 'y';
        Scanner input = new Scanner(System.in);

        System.out.println("Kim Louise Labrador's Compilation\n");
        do {
            System.out.println("Choices:");
            System.out.println("1 = Autobiography");
            System.out.println("2 = Parameter of Trapezoid");
            System.out.println("3 = Time Calculator");
            System.out.println("4 = ACII Code Converter\n");

            System.out.println("Select a Program:");

            int userinput = input.nextInt();

            if (userinput == 1) {
                Autobiography();
            } else if (userinput == 2) {
                Parameter_of_Trapezoid();
            } else if (userinput == 3) {
                Time_Calculator();
            } else if (userinput == 4) {
                ACIICode_Converter();
            } else if (userinput > 4 || userinput < 1) {
                System.out.println("Invalid, pls pick one from the choices above");

            }
            System.out.println("\nDo you want to choose another? (Yes or No)");
            ch = input.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

    }

    public static void Autobiography() {
        System.out.println("\nMY BIBLOIGRAPHY:");
        System.out.println("\nHi");
        System.out.println("My name is Kim Louise T. Labrador ");
        System.out.println("I am 17 years old");
        System.out.println("Male");
        System.out.println("I live at 56 Calauag, Naga City");
        System.out.println();
        System.out.println("My Hobbies are:");
        System.out.println(" Playing the Guitar");
        System.out.println(" Drawing");
        System.out.println(" Photography");
        System.out.println(" Playing online games");
        System.out.println();
        System.out.println("My Favorites:");
        System.out.println(" Food:");
        System.out.println("  Chicken");
        System.out.println("  Sprouted");
        System.out.println("  Pancit");
        System.out.println(" Color:");
        System.out.println("  Red");
        System.out.println("  Black");
        System.out.println("  Gray");
        System.out.println("  Brown");
        System.out.println();
        System.out.println("Why did I choose the programming strand?");
        System.out.println(" I choose this strand because in the furture I would");
        System.out.println(" like to create my own game.");
    }

    public static void Parameter_of_Trapezoid() {

        double perimeter, side1, side2, side3, side4;
        Scanner input = new Scanner(System.in);
        System.out.println("\nPARAMETER OF TRAPEZOID:");
        System.out.println("\nEnter value for side 1:  ");
        side1 = input.nextDouble();

        System.out.println("Enter value for side 2:  ");

        side2 = input.nextDouble();

        System.out.println("Enter value for side 3:  ");
        side3 = input.nextDouble();

        System.out.println("Enter value for side 4:  ");
        side4 = input.nextDouble();

        perimeter = side1 + side2 + side3 + side4;

        System.out.println("The perimeter of the trapezoid is " + perimeter);

        input.close();
    }

    public static void Time_Calculator() {
        int seconds, minutes, hours, days, num;
        int x = 1;
        Scanner input = new Scanner(System.in);

        System.out.println("\nTIME CALCULATOR");
        System.out.print("\nHow many times do you want to calculate? ");
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

    public static void ACIICode_Converter() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nASCII CODE TRANSLATOR");
        System.out.print("Enter a word or phrase: ");
        String userInput = input.nextLine();

        for (int index = 0; index < userInput.length(); index++) {
            char ic = userInput.charAt(index);
            int asciiCode = ic;

            System.out.println("The ASCII code of '" + ic + "' is " + asciiCode);

        }
    }

}
