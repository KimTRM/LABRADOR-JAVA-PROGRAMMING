package Intermediate_Prog.task4;

import java.util.Scanner;

public class SearchProtect {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        // Input rows and cols size
        IO.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        IO.print("Enter number of columns: ");
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];

        // Input matrix values
        IO.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.nextLine();

        // Input target Number
        IO.print("Enter target number: ");
        int target = scanner.nextInt();

        // Replace all non-target number with 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != target)
                    matrix[i][j] = 0;

            }
        }

        // Outputs the Updated Matrix
        IO.println("Updated Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                IO.print(matrix[i][j] + " ");
            }
            IO.println();
        }

    }
}
