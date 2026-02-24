package Intermediate_Prog.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Record_Manager {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> students = new ArrayList<>();

        while (true) {
            IO.println("""
                    STUDENT RECORD MANAGER
                    1. Add Student
                    2. View Student
                    3. Search Student
                    4. Update Student
                    5. Delete Student
                    6. Exit Student""");
            IO.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner, students);
                    break;
                case 2:
                    viewStudent(students);
                    break;
                case 3:
                    searchStudent(scanner, students);
                    break;
                case 4:
                    updateStudent(scanner, students);
                    break;
                case 5:
                    deleteStudent(scanner, students);
                    break;
                case 6:
                    IO.println("Program Ended.");
                    return;
                default:
                    IO.println("Invalid choice. Please enter a number between 1 and 6.\n");
            }
        }
    }

    static void addStudent(Scanner scanner, ArrayList<String> students) {
        IO.print("Enter student name: ");

        String name = scanner.next();
        students.add(name);

        IO.println("Student added.\n");
    }

    static void viewStudent(ArrayList<String> students) {
        IO.println("Student List:");
        for (String student : students)
            IO.println(student);

        IO.println();
    }

    static void searchStudent(Scanner scanner, ArrayList<String> students) {
        IO.print("Enter student name to search: ");
        String name = scanner.next();

        if (students.contains(name))
            IO.println("Student found!\n");
        else
            IO.println("Student not found.\n");
    }

    static void updateStudent(Scanner scanner, ArrayList<String> students) {
        IO.print("Enter index to update: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < students.size()) {
            IO.print("Enter new name: ");
            String newName = scanner.next();
            students.set(index, newName);
            IO.println("Student updated.\n");
        } else
            IO.println("Invalid index. No student updated.\n");
    }

    static void deleteStudent(Scanner scanner, ArrayList<String> students) {
        IO.print("Enter index to delete: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= students.size()) {
            IO.println("Invalid index. No student deleted.\n");
            return;
        }

        students.remove(index);

        IO.println("Student deleted!\n");
    }
}
