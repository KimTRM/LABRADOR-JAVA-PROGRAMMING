package Data_Structures_and_Algorithms;

import java.util.Scanner;

public class BubbleSortExample {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IO.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            IO.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        bubbleSort(numbers);

        IO.println("\nSorted numbers:");
        for (int num : numbers) {
            IO.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

