package Grade11.Translator;

import java.util.Scanner;

public class Char_Ascii_Code {

    static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter String: ");
        String userInput = s.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            char currentChar = userInput.charAt(i);

            System.out.println("The ASCII code of '" + currentChar + "' is " + (int) currentChar);

        }

    }
}