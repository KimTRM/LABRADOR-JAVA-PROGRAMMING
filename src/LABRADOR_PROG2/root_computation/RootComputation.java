package LABRADOR_PROG2.root_computation;

import java.io.*;
import java.util.Scanner;

public class RootComputation {

    static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        char ch = 'y';
        do {
            System.out.println("Chioces:");
            System.out.println("1 = Inputing the Variables(Write)");
            System.out.println("2 = View the answer(Read)");

            System.out.println("\nPlease Select");
            int userinput = input.nextInt();

            if (userinput == 1) {
                KeyInput();
            } else if (userinput == 2) {
                Formula();
            }
            System.out.println("\n\nDo you want to choose another? (Yes or No)");
            ch = input.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

    }

    public static void KeyInput() throws IOException {
        FileWriter fwriter = new FileWriter("Variables.txt", true);
        PrintWriter outputFile = new PrintWriter(fwriter);
        Scanner input = new Scanner(System.in);

        File save_file = new File("Variables.txt");
        Scanner inputp = new Scanner(save_file);
        int lineNum = 1;
        int x = 0;

        while (x == 0 || x == 10) {


            for (x = 1; x <= 2; x++) {
                System.out.println("\nNumber " + lineNum);

                System.out.print("Enter A: ");
                int a = input.nextInt();

                System.out.print("Enter B: ");
                int b = input.nextInt();

                System.out.print("Enter C: ");
                int c = input.nextInt();


                outputFile.print(a + ", " + b + ", " + c + "\n");

                System.out.println("File written");
                lineNum++;
            }
            outputFile.close();
        }
    }


    public static void Formula() throws IOException {
        File save_file = new File("Variables.txt");
        Scanner inputp = new Scanner(save_file);

        int lineNum = 1;
        String a, b, c, line;
        Double A, B, C, determinant, sqrt;
        Double root1, root2;

        while (inputp.hasNext()) {
            line = inputp.nextLine();
            System.out.println("\n\nNumber " + lineNum + ": " + line);
            String[] token = line.split(",");

            a = token[0];
            b = token[1];
            c = token[2];


            A = Double.parseDouble(a);
            B = Double.parseDouble(b);
            C = Double.parseDouble(c);

            determinant = B * B - 4 * A * C;

            if (determinant > 0) {

                root1 = (-B + Math.sqrt(determinant)) / (2 * A);
                root2 = (-B - Math.sqrt(determinant)) / (2 * A);

                System.out.println("Roots are: " + root1 + " and " + root2);
            } else if (determinant == 0) {
                root1 = -B / (2 * A);
                System.out.println("Roots are :: " + root1);


            } else {
                System.out.println("Roots are not real");
                double real = -B / (2 * A);

                double imaginary = Math.sqrt(-determinant) / (2 * A);

                System.out.printf("First Root = %.2f+%.2fi",
                        real, imaginary);
                System.out.printf("\nSecond Root = %.2f-%.2fi",
                        real, imaginary);
            }
            lineNum++;
        }

    }
}