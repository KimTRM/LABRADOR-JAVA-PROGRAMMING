package Intermediate_Prog;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labrador_KimLouise_Task10 {
    static void main(String[] args) {
        System.out.println("--- MODULE 1: GUESTBOOK ---");
        manageGuestbook();
        viewGuestList(); // Bonus Feature

        System.out.println("\n--- MODULE 2: SYSTEM AUDIT ---");
        performAudit();
    }

    public static void manageGuestbook() {
        File file = new File("guestbook.txt");
        try {
            if (!file.exists()) {
                // TODO: Create the file and print "New guestbook initialized."
                file.createNewFile();
                System.out.println("New guestbook initialized.");
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter guest name: ");
                String name = sc.nextLine();

                // TODO: Use a try-with-resources block with BufferedWriter
                // and FileWriter(file, true) to append the name and a new line.
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write(name);
                    writer.newLine(); // go to next line
                }

                System.out.println("Guest added successfully.");
                sc.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewGuestList() {
        System.out.println("\n--- CURRENT GUEST LIST ---");
        // TODO: Use a BufferedReader to read "guestbook.txt"
        // and print every line to the console using a while loop.

        try (BufferedReader reader = new BufferedReader(new FileReader("guestbook.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading guestbook.");
        }
    }

    public static void performAudit() {
        int lines = 0, errors = 0;
        // TODO: Use a try-with-resources block for BufferedReader to read "document.txt"
        try (BufferedReader reader = new BufferedReader(new FileReader("document.txt"))) {
            // TODO: Create a while loop that reads each line
            // 1. Increment 'lines' for every line found
            // 2. Increment 'errors' if the line contains the word "Error"

            String line;

            while ((line = reader.readLine()) != null) {
                lines++;

                if (line.contains("Error")) {
                    errors++;
                }
            }

            System.out.println("Total Lines: " + lines);
            System.out.println("Error Count: " + errors);
        } catch (FileNotFoundException e) {
            System.out.println("Please ensure document.txt is in the project folder.");
        } catch (IOException e) {
            System.out.println("Reading error occurred.");
        }
    }
}
