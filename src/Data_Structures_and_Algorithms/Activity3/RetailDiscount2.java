package Data_Structures_and_Algorithms.Activity3;

import java.util.Scanner;

import java.util.Scanner;

public class RetailDiscount2 {
    static void main(String[] args) {
        // Simulated original prices of products
        // double[] originalPrices = {50.0, 120.0, 80.0, 45.0};
        Scanner scanner = new Scanner(System.in);

        IO.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();
        double[] originalPrices = new double[numProducts];

        // Input original prices of products
        for (int i = 0; i < numProducts; i++) {
            IO.print("Enter original price for product " + (i + 1) + ": ");
            originalPrices[i] = scanner.nextDouble();
        }

        IO.println("\n------------ RESULTS ------------");
        IO.println("Original Prices\t\tDiscounted Prices");

        // Display original prices and Calculate discounted prices
        for (double price : originalPrices) {
            double discountedPrice = applyDiscount(price);
            IO.println(price + "\t\t\t\t" + discountedPrice);
        }
    }

    static double applyDiscount(double price) {
        return price * 0.9; // Apply a 10% discount
    }
}
