package Intermediate_Prog;

import java.util.LinkedList;
import java.util.Scanner;

public class ActivityLinkedList {
//    Group 3:
//    Kim Louise T. Labrador
//    Jennylyn R. Tiquio
//    Jim Raphael A. Azur
//    John Marvin A. Ireno

    static void main() {
        Scanner scanner = new Scanner(System.in);

        // Keep showing the menu until the user chooses to exit
        while (true) {
            IO.println("----- Linked List Activity -----");
            IO.println("1. Grocery List");
            IO.println("2. Search List");
            IO.println("3. Tail-Head Swap");
            IO.println("4. Exit");

            IO.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline after nextInt()

            IO.println("");

            // Route to the corresponding activity based on the user's choice
            switch (choice) {
                case 1:
                    GroceryList(scanner);
                    break;
                case 2:
                    SearchList(scanner);
                    break;
                case 3:
                    TailHeadSwap(scanner);
                    break;
                case 4:
                    IO.println("Exiting...");
                    return; // Exit the loop and end the program
                default:
                    IO.println("Invalid option. Please try again.");
            }
        }
    }

    // Collects 5 grocery items, replaces "Sugar" with "Stevia" if found, then prints the list
    static void GroceryList(Scanner scanner) {
        LinkedList<String> groceryList = new LinkedList<String>();

        IO.println("----- Grocery List -----");

        // Ask the user to enter exactly 5 grocery items
        for (int i = 0; i < 5; i++) {
            IO.print("Input a grocery item: ");
            String item = scanner.nextLine();
            groceryList.add(item); // Append item to the end of the list
        }

        // If "Sugar" is in the list, substitute it with the healthier alternative "Stevia"
        if (groceryList.contains("Sugar"))
            groceryList.set(groceryList.indexOf("Sugar"), "Stevia");
        else
            groceryList.set(0, "Sugar");

        // Print the list directly — LinkedList.toString() produces [item1, item2, ...]
        IO.print("Grocery List: " + groceryList + "\n\n");
    }

    // Collects a list of names, then searches for a user-specified name
    static void SearchList(Scanner scanner) {
        LinkedList<String> searchList = new LinkedList<String>();

        IO.println("----- Search List -----");

        IO.print("Enter number of names: ");
        int numOfNames = scanner.nextInt();

        // Populate the list with the requested number of names
        for (int i = 0; i < numOfNames; i++) {
            IO.print("Enter name: ");
            String name = scanner.next();
            searchList.add(name);
        }

        IO.print("Enter name to search: ");
        String target = scanner.next();

        // Print index if the name is found, -1 otherwise
        IO.print("Output: " + SearchName(searchList, target) + "\n\n");
    }

    // Returns index if target exists in the list, -1 if it does not
    static int SearchName(LinkedList<String> searchList, String target) {
        if (searchList.contains(target))
            return searchList.indexOf(target);  // Name found

        return -1; // Name not found
    }

    // Collects a list of names, then swaps the first (head) and last (tail) elements
    static void TailHeadSwap(Scanner scanner) {
        LinkedList<String> list = new LinkedList<String>();

        IO.println("----- Tail-Head Swap -----");

        IO.print("Enter number of names: ");
        int numOfNames = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline after nextInt()

        // Populate the list with the requested number of names
        for (int i = 0; i < numOfNames; i++) {
            IO.print("Enter name: ");
            String name = scanner.nextLine();
            list.add(name);
        }

        // Save the current head and tail before swapping
        String head = list.getFirst();
        String tail = list.getLast();

        // Place the old tail at index 0 and the old head at the last index
        list.set(0, tail);
        list.set(list.size() - 1, head);

        // Print the list directly — LinkedList.toString() produces [item1, item2, ...]
        IO.print("Output: " + list + "\n\n");
    }
}
