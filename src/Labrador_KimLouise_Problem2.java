import java.util.Scanner;

public class Labrador_KimLouise_Problem2 {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        IO.println("Enter Size of Array: ");
        int[] arr = new int[scanner.nextInt()];

        while (true) {
            scanner.nextLine();

            IO.println("""
                    ----- MENU -----
                    a. Fill Array with Values (Rand: 50-100)
                    b. Sort Array
                    c. Insert a Value
                    d. delete a Value
                    e. Print the Values
                    f. exit
                    Enter your choice:
                    """);
            char choice = scanner.next().toLowerCase().charAt(0);

            switch (choice) {
                case 'a' -> arr = fillArray(arr);
                case 'b' -> arr = sortArray(arr);
                case 'c' -> {
                    IO.println("Enter Value to Insert: ");
                    int value = scanner.nextInt();

                    IO.println("What index to be inserted: ");
                    int index = scanner.nextInt();

                    arr[index] = value;
                }
                case 'd' -> {
                    IO.println("What index to be deleted: ");
                    int index = scanner.nextInt();
                    arr[index] = 0;
                }
                case 'e' -> printArray(arr);
                case 'f' -> {
                    return;
                }
                default -> {
                }
            }
        }
    }

    static int[] fillArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) Math.round(Math.random() * 100));
        }

        return arr;
    }

    static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int placeholder = arr[i];

                    arr[i] = arr[j];
                    arr[j] = placeholder;
                }
            }
        }

        return arr;
    }

//    static void insertValue(Scanner scanner) {
//
//    }
//
//    static void deleteValue() {
//
//    }

    static void printArray(int[] arr) {
        for (int v : arr)
            IO.print(v + ", ");

    }
}
