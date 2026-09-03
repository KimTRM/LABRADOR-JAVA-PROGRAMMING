package OOP.UniversityClassRecordManagementApp;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    static void main() {
        printBanner();
        while (true) {
            printMenu();
            String choice = prompt("Select option: ");
            switch (choice.trim()) {
//                case "1" -> assignCollegeAndProgram();
//                case "2" -> assignCourse();
//                case "3" -> assignInstructor();
//                case "4" -> addStudent();
//                case "5" -> removeStudent();
//                case "6" -> displayStudentsMenu();
//                case "7" -> record.displayClassRecord();
//                case "8" -> saveRecord();
//                case "9" -> loadRecord();
                case "0" -> {
                    IO.println("Exiting system. Thank you for using UNC Class Record System!");
                    return;
                }
                default -> IO.println(">> Invalid option. Please try again.");
            }
            IO.println();
        }
    }

    private static void printBanner() {
        IO.println("=".repeat(50));
        IO.println("UNIVERSITY OF NUEVA CACERES");
        IO.println("Class Record Management System");
        IO.println("=".repeat(50));
    }

    private static void printMenu() {
        IO.println("\n=== MAIN MENU ===");
        IO.println("[1] Assign College & Program Details");
        IO.println("[2] Assign Subject / Course Details");
        IO.println("[3] Set / Update Assigned Instructor");
        IO.println("[4] Add Enrolled Student");
        IO.println("[5] Remove Student by ID");
        IO.println("[6] Display Enrolled Students (Unsorted / Sorted)");
        IO.println("[7] Display Full Class Record");
        IO.println("[8] Save Class Record to File");
        IO.println("[9] Load Class Record from File");
        IO.println("[0] Exit");
    }

    private static String prompt(String label) {
        IO.print(label);
        return sc.nextLine();
    }
}
