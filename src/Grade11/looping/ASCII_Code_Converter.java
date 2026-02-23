package Grade11.looping;

import java.util.Scanner;

public class ASCII_Code_Converter {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("ASCII CODE TRANSLATOR");
        System.out.print("Enter a word or phrase: ");
        String userInput = input.nextLine();

        for (int index = 0; index < userInput.length(); index++) {
            char ic = userInput.charAt(index);
            int asciiCode = ic;

            System.out.println("The ASCII code of '" + ic + "' is " + asciiCode);

        }

    }
}

