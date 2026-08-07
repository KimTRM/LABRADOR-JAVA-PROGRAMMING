package OOP.FloorTilingActivity;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Tile> tiles = new ArrayList<>();

        IO.println("=== FLOOR TILING CALCULATOR ===");
        IO.print("Enter floor length (in meters): ");
        double length = scanner.nextDouble();

        IO.print("Enter floor width (in meters): ");
        double width = scanner.nextDouble();

        FloorArea floorArea = new FloorArea(length, width);

        while (true) {
            IO.println("\n--- Enter Tile Option  ---");
            IO.print("Tile Brand/Name : ");
            String brand = scanner.next();

            IO.print("Tile Length (in cm): ");
            int lengthTile = scanner.nextInt();

            IO.print("Tile Width (in cm): ");
            int widthTile = scanner.nextInt();

            IO.println("Cost per Tile (in PHP): ");
            double costTile = scanner.nextDouble();

            tiles.add(new Tile(brand, lengthTile, widthTile, costTile));

            IO.println("Result:");
            IO.println("- Tiles Needed: ");
            IO.println("- Total Cost: ");

            IO.print("Do you want to add another tile option? (Y/N): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("N"))
                break;
        }


        IO.println("========== SUMMARY ==========");
        IO.println("Highest Budget Needed: ");
        IO.println("- Brand: ");

        IO.println("Lowest Budget Needed: ");
        IO.println("- Brand: ");
        IO.println("==============================");
    }
}
