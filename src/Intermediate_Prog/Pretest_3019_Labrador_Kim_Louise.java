package Intermediate_Prog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Pretest_3019_Labrador_Kim_Louise {
    static void main() {
        ArrayList<Integer> playerTotalPoints = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int tournamentTotal = 0;
        int numberOfPlayers;

        // Input number of players
        IO.println("--- Player Points Calculation System ---");

        while (true) {
            IO.print("Enter number of players: ");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers > 0)
                break;
            else
                IO.println("Error: Number of players must be a positive number (1 or higher). Please try again.");
        }

        // Loop through each player
        for (int i = 1; i <= numberOfPlayers; i++) {
            IO.println("\n--- Player " + i + " ---");

            // Input number of matches played
            IO.print("Enter number of matches played by Player " + i + ": ");
            int numberOfMatches = scanner.nextInt();

            // Sum points from each match
            int totalPoints = 0;
            for (int j = 1; j <= numberOfMatches; j++) {
                int rank = validateRank(scanner, j);
                totalPoints += getRankPoints(rank);
            }

            // Calculate average and apply consistency bonus ONCE
            double average = totalPoints / (double) numberOfMatches;
            if (average > 80) {
                totalPoints += 20;
                IO.println("Consistency bonus applied (+20 points)");
            }

            // Store total points for the player
            playerTotalPoints.add(totalPoints);
            tournamentTotal += totalPoints;
        }

        // Display total points for each player
        IO.println("\n--- Tournament Results ---");
        for (int i = 0; i < playerTotalPoints.size(); i++)
            IO.println("Player " + (i + 1) + " Total Points: " + playerTotalPoints.get(i));

        IO.println("\nTotal Points awarded across the entire tournament: " + tournamentTotal);

        scanner.close();
    }

    static int validateRank(Scanner scanner, int currentMatch) {
        int rank;
        while (true) {
            IO.print("Enter ranks achieved in Match " + currentMatch + ": ");
            rank = scanner.nextInt();
            if (rank >= 1)
                break;
            else
                IO.println("Error: Rank must be a positive number (1 or higher). Please try again.");
        }
        return rank;
    }

    static int getRankPoints(int rank) {
        return switch (rank) {
            case 1 -> 100;
            case 2 -> 75;
            case 3 -> 50;
            default -> 10;
        };
    }
}


