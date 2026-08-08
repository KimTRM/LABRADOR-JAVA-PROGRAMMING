package OOP.Activity1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Tile> tileOptions = new ArrayList<>();
        String highestTile = "";
        String lowestTile = "";

        double highestBudget = Double.MIN_VALUE;
        double lowestBudget = Double.MAX_VALUE;

        int increment = 1;
        char choice;

        // User input for floor dimensions
        IO.println("=== FLOOR TILING CALCULATOR ===");
        IO.print("Enter floor length (in meters): ");
        double length = scanner.nextDouble();

        IO.print("Enter floor width (in meters): ");
        double width = scanner.nextDouble();

        Floor floorArea = new Floor(length, width);

        do {
            scanner.nextLine(); // Clear input buffer

            // User input for tile options
            IO.println("\n--- Enter OOP.Activity1.Tile Option " + increment + " ---");
            IO.print("OOP.Activity1.Tile Brand/Name : ");
            String brand = scanner.next();

            IO.print("OOP.Activity1.Tile Length (in cm): ");
            int lengthTile = scanner.nextInt();

            IO.print("OOP.Activity1.Tile Width (in cm): ");
            int widthTile = scanner.nextInt();

            IO.print("Cost per OOP.Activity1.Tile (in PHP): ");
            double costTile = scanner.nextDouble();

            // Create a new OOP.Activity1.Tile object and add it to the list
            Tile tile = new Tile(brand, lengthTile, widthTile, costTile);
            tileOptions.add(tile);

            int tilesNeeded = tile.computeTilesNeeded(floorArea.getArea());
            double totalBudget = tile.computeCost(floorArea.getArea());

            // Display the results for the current tile option
            IO.println("\nResult:");
            IO.println("- Tiles Needed: " + tilesNeeded + " tiles");
            System.out.printf("Total Cost: ₱%,.2f%n", totalBudget);

            // Ask the user if they want to add another tile option
            IO.print("\nDo you want to add another tile option? (Y/N): ");
            choice = scanner.next().charAt(0);

            increment++;
        } while (choice == 'Y' || choice == 'y');

        // Compare the budgets of all tile options to find the highest and lowest
        for (Tile tile : tileOptions) {
            double budget = tile.getTotalBudget(floorArea.getArea());

            if (budget > highestBudget) {
                highestBudget = budget;
                highestTile = tile.getBrand();
            }

            if (budget < lowestBudget) {
                lowestBudget = budget;
                lowestTile = tile.getBrand();
            }
        }

        // Display the summary of the highest and lowest budget needed
        IO.println("\n========== SUMMARY ==========");
        IO.println("Highest Budget Needed: ");
        System.out.printf("- Brand: %s (₱%,.2f)%n", highestTile, highestBudget);

        IO.println("\nLowest Budget Needed: ");
        System.out.printf("- Brand: %s (₱%,.2f)%n", lowestTile, lowestBudget);
        IO.println("==============================");

        scanner.close();
    }
}
