package OOP.ClassDirectoryRecordingApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<Student>();
    static ClassSection classSection = new ClassSection();
    static Adviser adviser = new Adviser();

    static void main() {

        while (true) {
            IO.println("=== SCHOOL CLASS DIRECTORY SYSTEM ===");
            IO.println("""
                    [1] View Class Directory
                    [2] Assign/Update OOP.ClassDirectoryRecordingApp.Adviser
                    [3] Add OOP.ClassDirectoryRecordingApp.Student
                    [4] Update OOP.ClassDirectoryRecordingApp.Student by LRN
                    [5] Save Directory to File
                    [6] Load Directory from File
                    [7] Exit
                    """);

            IO.print("Enter Your Choice: ");
            int choice = scanner.nextInt();

            IO.println();

            switch (choice) {
                case 1 -> viewClassDirectory();
                case 2 -> upsertAdviser();
                case 3 -> addStudent();
                case 4 -> updateStudent();
                case 5 -> saveDirectory();
                case 6 -> loadDirectory();
                case 7 -> {
                    IO.println("Exiting the program. Goodbye!");
                    return;
                }
                default -> IO.println("Invalid choice. Please try again.");
            }

            IO.println();
        }
    }

    static void viewClassDirectory() {
        IO.println("==================================================");
        IO.println("CLASS SECTION DIRECTORY");
        IO.println("Grade Level: " + classSection.getGradeLevel() + " Section Name: " + classSection.getSectionName());

        IO.println("--------------------------------------------------");
        IO.println("ADVISER INFORMATION:");

        if (adviser.getLastName() != null) {
            IO.println("Name: " + adviser.getLastName() + ", " + adviser.getFirstName() + " " + adviser.getMiddleName());
            IO.println("Gender: " + adviser.getGender() + "| Birthdate: " + adviser.getBirthdate() + " (Age: " + ")");
            IO.println("Contact: " + adviser.getContactNumber() + " | Degree: " + adviser.getHighestDegreeEarned());
        } else
            IO.println("No adviser assigned yet.");

        IO.println("--------------------------------------------------");

        IO.println("ENROLLED STUDENTS (Sorted Alphabetically - Total: " + students.size() + ")");

        if (!students.isEmpty()) {
            for (Student student : students) {
                IO.println("[" + (students.indexOf(student) + 1) + "] LRN: " + student.getLRN());
                IO.println("Name: " + student.getLastName() + ", " + student.getFirstName() + " " + student.getMiddleName());
                IO.println("Gender: " + student.getGender() + " | Birthdate: " + student.getBirthdate() + " (Age: " + student.getComputedAge() + ") | Contact: " + student.getContactNumber());
                IO.println("Address: " + student.getHomeAddress());
            }
        } else
            IO.println("No students enrolled yet.");

        IO.println("==================================================");
    }

    static void upsertAdviser() {
        IO.println("--- ASSIGN/UPDATE ADVISER ---");
        IO.print("Enter Last Name: ");
        adviser.setLastName(scanner.next());

        IO.print("Enter First Name: ");
        adviser.setFirstName(scanner.next());

        IO.print("Enter Middle Name: ");
        adviser.setMiddleName(scanner.next());

        IO.print("Enter Gender: ");
        adviser.setGender(scanner.next());

        while (true) {
            IO.print("Enter Birthdate (YYYY-MM-DD): ");
            String birthdate = scanner.next();
            String validationMessage = validateBirthdate(birthdate);

            if (validationMessage == null) {
                adviser.setBirthdate(birthdate);
                break;
            } else
                IO.println(validationMessage);
        }

        IO.print("Enter Contact Number: ");
        adviser.setContactNumber(scanner.nextInt());

        IO.print("Enter Highest Degree Earned: ");
        adviser.setHighestDegreeEarned(scanner.next());

        IO.println(">> OOP.ClassDirectoryRecordingApp.Adviser information updated successfully!");
    }

    static void addStudent() {
        IO.println("--- ADD NEW STUDENT ---");
        IO.print("Enter LRN: ");
        long lrn = scanner.nextLong();

        if (findStudentByLRN(lrn) != null) {
            IO.println(">> Error: OOP.ClassDirectoryRecordingApp.Student with LRN " + lrn + " already exists!");
            return;
        }

        Student student = new Student();
        student.setLRN(lrn);

        IO.print("Enter Last Name: ");
        student.setLastName(scanner.next());

        IO.print("Enter First Name: ");
        student.setFirstName(scanner.next());

        IO.print("Enter Middle Name: ");
        student.setMiddleName(scanner.next());

        IO.print("Enter Gender: ");
        student.setGender(scanner.next());

        while (true) {
            IO.print("Enter Birthdate (YYYY-MM-DD): ");
            String birthdate = scanner.next();
            String validationMessage = validateBirthdate(birthdate);

            if (validationMessage == null) {
                student.setBirthdate(birthdate);
                break;
            } else
                IO.println(validationMessage);
        }

        IO.print("Enter Contact Number: ");
        student.setContactNumber(scanner.nextInt());

        IO.print("Enter Home Address: ");
        student.setHomeAddress(scanner.next());

        students.add(student);

        IO.println(">> OOP.ClassDirectoryRecordingApp.Student added successfully!");
    }

    static void updateStudent() {
        IO.println("--- UPDATE STUDENT ---");
        IO.print("Enter LRN to Search: ");
        int lrn = scanner.nextInt();

        Student student = findStudentByLRN(lrn);
        if (student == null) {
            IO.println(">> OOP.ClassDirectoryRecordingApp.Student with LRN " + lrn + " not found!");
            return;
        }

        IO.println("OOP.ClassDirectoryRecordingApp.Student found: " + student.getFirstName() + " " + student.getLastName());
        IO.println("Enter updated details:");

        IO.print("Enter Last Name: ");
        student.setLastName(scanner.next());

        IO.print("Enter First Name: ");
        student.setFirstName(scanner.next());

        IO.print("Enter Middle Name: ");
        student.setMiddleName(scanner.next());

        IO.print("Enter Gender: ");
        student.setGender(scanner.next());

        IO.print("Enter Birthdate (YYYY-MM-DD): ");
        student.setBirthdate(scanner.next());

        IO.print("Enter Contact Number: ");
        student.setContactNumber(scanner.nextInt());

        IO.print("Enter Home Address: ");
        student.setHomeAddress(scanner.next());

        IO.println(">> OOP.ClassDirectoryRecordingApp.Student updated successfully!");
    }

    static void saveDirectory() {
        try {
            FileWriter fileWriter = new FileWriter("ClassDirectory.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Student student : students) {
                String line = student.getLRN() + "," +
                        student.getLastName() + "," +
                        student.getFirstName() + "," +
                        student.getMiddleName() + "," +
                        student.getGender() + "," +
                        student.getBirthdate() + "," +
                        student.getContactNumber();
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            IO.println(">> Error saving Class Directory: " + e.getMessage());
        }
    }

    static void loadDirectory() {
        try {
            File file = new File("ClassDirectory.txt");

            if (!file.exists()) {
                boolean created = file.createNewFile();

                if (created)
                    IO.println(">> New Class Directory initialized.");
            }

            Scanner fileScanner = new Scanner(file);
            students.clear(); // Clear existing students before loading

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 7) {
                    Student student = new Student();

                    student.setLRN(Integer.parseInt(parts[0].trim()));
                    student.setLastName(parts[1].trim());
                    student.setFirstName(parts[2].trim());
                    student.setMiddleName(parts[3].trim());
                    student.setGender(parts[4].trim());
                    student.setBirthdate(parts[5].trim());
                    student.setContactNumber(Integer.parseInt(parts[6].trim()));

                    students.add(student);

                    IO.println(">> OOP.ClassDirectoryRecordingApp.Student " + student.getLRN() + " added successfully!");
                }
            }

        } catch (Exception e) {
            IO.println(">> Error loading Class Directory: " + e.getMessage());
        }
    }

    // ---- Helper Methods -----
    static Student findStudentByLRN(long lrn) {
        for (Student student : students) {
            if (student.getLRN() == lrn) {
                return student;
            }
        }
        return null;
    }

    static String validateBirthdate(String birthdate) {
        // Validate the birthdate format (YYYY-MM-DD)
        if (!birthdate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Invalid birthdate format. Please use YYYY-MM-DD.";
        }
        return null; // Valid
    }
}
