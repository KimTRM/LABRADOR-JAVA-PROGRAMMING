package Intermediate_Prog.task4;

import java.util.ArrayList;
import java.util.Scanner;

public class SubListSum {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IO.print("Enter number of elements: ");
        int numberOfElements = scanner.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numberOfElements; i++) {
            IO.print("Enter number " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        IO.print("Enter target sum: ");
        int targetSum = scanner.nextInt();

        IO.println("Output:");
        boolean found = false;
        for (int i = 0; i < numbers.size(); i++) {
            int currentSum = 0;
            int end = -1;

            for (int j = i; j < numbers.size(); j++) {
                currentSum += numbers.get(j);

                if (currentSum == targetSum) {
                    end = j;
                    found = true;
                    break;
                }

                if (currentSum > targetSum)
                    break;
            }

            if (end != -1) {
                IO.print("[");
                for (int k = i; k <= end; k++) {
                    if (k > i) IO.print(", ");
                    IO.print(numbers.get(k));
                }
                IO.print("] ");
            }
        }


        if (!found)
            IO.println("No matching sequence found.");
    }
}