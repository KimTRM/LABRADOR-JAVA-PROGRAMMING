package Intermediate_Prog;

import java.util.Scanner;

public class Labrador_Kim_Activity2 {
    static void main() {
        // Scanner reads all user input from the console.
        Scanner scanner = new Scanner(System.in);

        // Keep showing the menu until the user chooses to exit.
        while (true) {
            // Display available options.
            IO.print("""
                    Choose an option:
                    1. Enter a string to toggle its case
                    2. Count character frequency.
                    3. Type 'exit' to quit the program.
                    """);
            IO.print("Your choice: ");

            // Read choice as text so both numbers and 'exit' are accepted.
            int choice = scanner.nextInt();

            scanner.nextLine();

            // Run the selected feature.
            switch (choice) {
                case 1:
                    // Ask for text, then print the same text with toggled letter case.
                    IO.print("\nEnter a string to toggle its case: ");
                    String toggleInput = scanner.nextLine();

                    toggleCase(toggleInput);
                    IO.println();
                    break;
                case 2:
                    // Ask for a source string and one character to count.
                    IO.print("\nEnter a string to count character frequency: ");
                    String freqInput = scanner.nextLine();

                    IO.print("Enter letter to count frequency: ");
                    char letter = scanner.nextLine().charAt(0);

                    frequencyCount(freqInput, letter);
                    IO.println();
                    break;
                case 3:
                    IO.println("Exiting the program.");
                    return;
                default:
                    // Handle unsupported numeric options.
                    IO.println("Invalid option. Please try again.");
                    IO.println();
            }
        }
    }

    // Prints the string with uppercase/lowercase letters swapped.
    static void toggleCase(String input) {
        IO.print("Toggled case string: ");

        // Process each character and print immediately (no extra list/builder).
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c))
                IO.print(Character.toLowerCase(c));
            else if (Character.isLowerCase(c))
                IO.print(Character.toUpperCase(c));
            else
                IO.print(c);
        }

        IO.println();
    }

    // Counts how many times the target letter appears in the input.
    static void frequencyCount(String input, char letter) {
        int count = 0;

        // Compare every character in the string to the target letter.
        for (char c : input.toCharArray())
            if (c == letter)
                count++;

        IO.println("Frequency of '" + letter + "': " + count);
    }
}
