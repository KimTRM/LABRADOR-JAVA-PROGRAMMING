package Data_Structures_and_Algorithms.Activity4;

import java.util.Scanner;

public class Prob003_Labrador_Kim {
    static void main() {
        Scanner scanner = new Scanner(System.in); // Create Scanner object
        int[] scores = new int[30]; // Create array for 30 students
        int sum = 0; // Variable to store total

        for (int i = 0; i < scores.length; i++) { // Loop for input
            IO.print("OOP.ClassDirectoryRecordingApp.Student " + (i + 1) + ": "); // Ask input
            scores[i] = scanner.nextInt(); // Store score
            sum += scores[i]; // Add to total
        }

        double average = (double) sum / scores.length; // Compute average

        IO.println("\nSum of Scores: " + sum); // Print sum
        IO.println("Average: " + average); // Print average

        scanner.close(); // Close scanner
    }
}
