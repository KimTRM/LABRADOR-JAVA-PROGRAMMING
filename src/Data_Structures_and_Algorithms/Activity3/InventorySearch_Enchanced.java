package Data_Structures_and_Algorithms.Activity3;

import java.util.Scanner;

public class InventorySearch_Enchanced {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        IO.print("Enter Number of Products: ");
        int numberOfProducts = scanner.nextInt();

        int[] productIDs = new int[numberOfProducts];
        String[] productNames = new String[numberOfProducts];
        double[] productPrices = new double[numberOfProducts];

        for (int i = 0; i < numberOfProducts; i++) {
            IO.print("\nEnter Product ID: ");
            productIDs[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            IO.print("Enter Product Name for Product ID " + productIDs[i] + ": ");
            productNames[i] = scanner.nextLine();

            IO.print("Enter Product Price for Product ID " + productIDs[i] + ": ");
            productPrices[i] = scanner.nextDouble();
        }

        while (true) {
            scanner.nextLine();
            IO.print("\nEnter search option (ID, Name): ");
            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "id":
                    IO.print("Enter Product ID to search: ");
                    int targetID = scanner.nextInt();
                    searchByID(productIDs, productNames, productPrices, targetID);
                    break;
                case "name":
                    IO.print("Enter Product Name to search: ");
                    String targetName = scanner.nextLine();
                    searchByName(productIDs, productNames, productPrices, targetName);
                    break;
                default:
                    IO.println("Invalid option. Please enter 'ID' or 'Name'.");
            }

            IO.print("\nDo you want to search for a product? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes"))
                break;
        }
    }

    static void searchByID(int[] productIDs, String[] productNames, double[] productPrices, int targetID) {
        boolean found = false;
        for (int i = 0; i < productIDs.length; i++) {
            if (productIDs[i] == targetID) {

                IO.println("\nProduct ID\t Product Name\t Product Price");
                IO.println(productIDs[i] + "\t\t\t " + productNames[i] + "\t\t\t\t" + productPrices[i]);

                found = true;
                break;
            }
        }
        if (!found) {
            IO.println("\nProduct with ID " + targetID + " not found.");
        }
    }

    static void searchByName(int[] productIDs, String[] productNames, double[] productPrices, String targetName) {
        boolean found = false;
        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].equalsIgnoreCase(targetName)) {

                IO.println("\nProduct ID\t Product Name\t Product Price");
                IO.println(productIDs[i] + "\t\t\t " + productNames[i] + "\t\t\t\t" + productPrices[i]);

                found = true;
                break;
            }
        }
        if (!found) {
            IO.println("\nProduct with name '" + targetName + "' not found.");
        }
    }
}
