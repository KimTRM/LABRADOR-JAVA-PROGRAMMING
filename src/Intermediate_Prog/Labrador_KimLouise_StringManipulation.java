package Intermediate_Prog;

import java.util.Scanner;

public class Labrador_KimLouise_StringManipulation {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            IO.println("""
                    Choose a string manipulation option:
                    1. Space Remover
                    2. Password Hider
                    3. Diamond String Pattern
                    4. Snake Case Converter
                    5. Palindrome Checker
                    6. Exit
                    """);
            IO.print("Enter a string manipulation option: ");
            int choice = scanner.nextInt();

            scanner.nextLine();

            // Handle the user's choice
            switch (choice) {
                case 1 -> {
                    IO.print("Enter a string with spaces: ");
                    String input = scanner.nextLine();
                    IO.println("Result: " + spaceRemover(input));
                }
                case 2 -> {
                    IO.print("Enter a password: ");
                    String password = scanner.nextLine();
                    IO.println("Hidden Password: " + passwordHider(password));
                }
                case 3 -> {
                    IO.print("Enter the number of rows for the diamond pattern: ");
                    String n = scanner.nextLine();
                    diamondStringPattern(n);
                }
                case 4 -> {
                    IO.print("Enter a string to convert to snake case: ");
                    String input = scanner.nextLine();
                    IO.println("Snake Case: " + snakeCase(input));
                }
                case 5 -> {
                    IO.print("Enter a string to check for palindrome: ");
                    String input = scanner.nextLine();
                    IO.println("Is Palindrome: " + (isPalindrome(input) ? "Yes" : "No"));
                }
                case 6 -> {
                    IO.println("Exiting...");
                    return;
                }
            }

            IO.println();
        }
    }

    static String spaceRemover(String text) {
        // Remove all spaces from the input string
        if (text.contains(" "))
            text = text.replace(" ", "");

        return text;
    }

    static String passwordHider(String text) {
        if (text.contains("(") && text.contains(")")) {
            // Find the indices of the parentheses
            int start = text.indexOf('(');
            int end = text.indexOf(')');

            // Replace characters between parentheses with asterisks
            String hiddenPart = "*".repeat(end - start - 1);
            text = text.substring(0, start + 1) + hiddenPart + text.substring(end);
        }

        return text;
    }

    static void diamondStringPattern(String text) {
        // Top Half of the diamond
        for (int i = 0; i <= text.length(); i++) {
            IO.println(text.substring(0, i));
        }

        // Lower half of the diamond (inverted pyramid)
        for (int i = text.length() - 1; i >= 0; i--) {
            IO.println(text.substring(0, i));
        }
    }

    static String snakeCase(String input) {
        String[] words = input.split("_");
        String result = "";

        // Capitalize first letter
        for (String word : words)
            if (word.length() % 2 == 0)
                result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
            else
                result += word.toLowerCase() + " ";

        return result;
    }

    static boolean isPalindrome(String text) {
        char[] chars = text.toCharArray();
        String cleaned = "";

        // Remove consecutive duplicate characters
        for (int i = 0; i < chars.length; i++)
            if (i == chars.length - 1 || chars[i] != chars[i + 1])
                cleaned += chars[i];

        IO.println("Compressed: " + cleaned);

        // Reverse the cleaned string
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--)
            reversed += cleaned.charAt(i);

        return cleaned.equals(reversed);
    }
}
