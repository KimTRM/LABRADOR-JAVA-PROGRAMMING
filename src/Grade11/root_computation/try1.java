package Grade11.root_computation;

import java.io.*;
import java.util.Scanner;

public class try1 {

    static void main(String[] args) throws IOException {
        File fwriter = new File("record.txt");
        Scanner input = new Scanner(fwriter);


        int lineNum = 1;
        String line, a, b, c;

        while (input.hasNext()) {
            line = input.nextLine();
            System.out.println("\n\nNumber" + lineNum + ": " + line);
            String[] token = line.split(",");
            a = token[0];
            b = token[1];
            c = token[2];


            double num = Double.parseDouble(a);
            double A = Math.sqrt(num);

            double num1 = Double.parseDouble(b);
            double B = Math.sqrt(num1);

            double num2 = Double.parseDouble(c);
            double C = Math.sqrt(num2);

            System.out.println("A = " + A);
            System.out.println("B = " + B);
            System.out.println("C = " + C);
            lineNum++;
        }


    }

}
