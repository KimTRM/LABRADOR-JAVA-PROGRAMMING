package LABRADOR_PROG2.root_computation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class try2 {
    static void main(String[] args) throws IOException {
        File save_file = new File("record.txt");
        Scanner input = new Scanner(save_file);

        int lineNum = 1;
        String a, b, c, line;
        Double A, B, C, determinant, sqrt;
        Double root1, root2;

        while (input.hasNext()) {
            line = input.nextLine();
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







