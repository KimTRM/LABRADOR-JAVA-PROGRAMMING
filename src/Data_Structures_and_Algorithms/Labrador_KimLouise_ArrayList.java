package Data_Structures_and_Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Labrador_KimLouise_ArrayList {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        IO.print("How many elements do you want in the original list? ");
        int originalCount = scanner.nextInt();
        
        scanner.nextLine();

        for (int i = 0; i < originalCount; i++) {
            IO.print("Enter element " + i + ": ");
            list.add(scanner.nextLine());
        }

        IO.println("\nOriginal List : " + list);
        IO.print("Enter word to add at index 1: ");
        String addWord = scanner.nextLine();
        list.add(1, addWord);

        IO.println("After Adding element at index 1 : " + list);
        list.remove(0);

        IO.println("Element removed from index 0 : " + list);
        if (list.size() > 1) {
            list.remove(1);
        }

        IO.println("Element removed from index 1 : " + list);
        IO.print("Enter word to add at index 1: ");
        String addAgain = scanner.nextLine();
        list.add(1, addAgain);

        IO.println("After Adding element at index 1 : " + list);
        IO.print("Enter new value to update index 0: ");
        String update = scanner.nextLine();
        list.set(0, update);
        if (list.size() > 1) {
            list.remove(1);
        }

        IO.println("List after updating of value : " + list);
        scanner.close();
    }
}
