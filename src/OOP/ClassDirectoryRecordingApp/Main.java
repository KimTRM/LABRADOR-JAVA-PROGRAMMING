package OOP.ClassDirectoryRecordingApp;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClassSection classSection = new ClassSection();

    static void main(String[] args) {
        System.out.println("=== WELCOME TO THE SCHOOL CLASS DIRECTORY SYSTEM ===");

        // Detect if a saved Class Section file already exists
        if (classSection.hasExistingDirectoryFile()) {
            System.out.println(">> Existing Class Section file detected (ClassDirectory.txt).");
            System.out.println(">> Automatically loading saved section details...");
            classSection.loadFromFile();
        } else {
            System.out.println("No existing section detected. Please set up initial class section information.");

            System.out.print("Enter Grade Level (e.g., Grade 10): ");
            classSection.setGradeLevel(scanner.nextLine().trim());

            System.out.print("Enter Section Name (e.g., Newton): ");
            classSection.setSectionName(scanner.nextLine().trim());
        }

        while (true) {
            System.out.println("\n=== SCHOOL CLASS DIRECTORY SYSTEM ===");
            System.out.println("""
                    [1] View Class Directory
                    [2] Assign/Update Adviser
                    [3] Add Student
                    [4] Update Student by LRN
                    [5] Save Directory to File
                    [6] Load Directory from File
                    [7] Exit
                    """);

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            System.out.println();

            switch (choice) {
                case "1" -> viewClassDirectory();
                case "2" -> upsertAdviser();
                case "3" -> addStudent();
                case "4" -> updateStudent();
                case "5" -> classSection.saveToFile();
                case "6" -> classSection.loadFromFile();
                case "7" -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please enter a choice between 1 and 7.");
            }
        }
    }

    /**
     * Displays the class directory, including adviser information and enrolled
     * students in the specified formatting layout.
     */
    private static void viewClassDirectory() {
        System.out.println("==================================================");
        System.out.println("CLASS SECTION DIRECTORY");
        System.out.println("Grade Level: " + classSection.getGradeLevel() + " Section Name: " + classSection.getSectionName());

        System.out.println("--------------------------------------------------");
        System.out.println("ADVISER INFORMATION:");

        Adviser adviser = classSection.getAdviser();
        if (adviser != null && adviser.getLastName() != null) {
            System.out.println("Name: Prof. " + adviser.getFirstName() + " " + adviser.getMiddleName() + " " + adviser.getLastName());
            System.out.println("Gender: " + adviser.getGender() + " | Birthdate: " + adviser.getBirthdate() + " (Age: " + adviser.getComputedAge() + ")");
            System.out.println("Contact: " + adviser.getContactNumber() + " | Degree: " + adviser.getHighestDegreeEarned());
        } else {
            System.out.println("No adviser assigned yet.");
        }

        System.out.println("--------------------------------------------------");
        var students = classSection.getStudents();
        System.out.println("ENROLLED STUDENTS (Sorted Alphabetically - Total: " + students.size() + ")");

        if (!students.isEmpty()) {
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.println("[" + (i + 1) + "] LRN: " + student.getLRN());
                System.out.println("Name: " + student.getLastName() + ", " + student.getFirstName() + " " + student.getMiddleName());
                System.out.println("Gender: " + student.getGender() + " | Birthdate: " + student.getBirthdate() + " (Age: " + student.getComputedAge() + ") | Contact: " + student.getContactNumber());
                System.out.println("Address: " + student.getHomeAddress());
            }
        } else {
            System.out.println("No students enrolled yet.");
        }

        System.out.println("==================================================");
    }

    /**
     * Prompt interface for creating or editing the assigned Adviser profile.
     */
    private static void upsertAdviser() {
        Adviser adviser = classSection.getAdviser();
        if (adviser == null) {
            adviser = new Adviser();
        }

        System.out.println("--- ASSIGN/UPDATE ADVISER ---");
        System.out.print("Enter Last Name: ");
        adviser.setLastName(scanner.nextLine().trim());

        System.out.print("Enter First Name: ");
        adviser.setFirstName(scanner.nextLine().trim());

        System.out.print("Enter Middle Name: ");
        adviser.setMiddleName(scanner.nextLine().trim());

        System.out.print("Enter Gender: ");
        adviser.setGender(scanner.nextLine().trim());

        // Validate birthdate input
        while (true) {
            System.out.print("Enter Birthdate (YYYY-MM-DD): ");
            String birthdate = scanner.nextLine().trim();
            String validationMessage = Person.validateBirthdate(birthdate);

            if (validationMessage == null) {
                adviser.setBirthdate(birthdate);
                break;
            } else {
                System.out.println(validationMessage);
            }
        }

        System.out.print("Enter Contact Number: ");
        adviser.setContactNumber(scanner.nextLong());

        System.out.print("Enter Highest Degree Earned: ");
        adviser.setHighestDegreeEarned(scanner.nextLine().trim());

        classSection.setAdviser(adviser);
        System.out.println(">> Adviser information updated successfully!");
    }

    /**
     * Prompt interface for creating a new student record and adding it to the class directory.
     */
    private static void addStudent() {
        Student student = new Student();
        System.out.println("--- ADD NEW STUDENT ---");

        // Validate LRN input and ensure it's unique
        while (true) {
            System.out.print("Enter LRN: ");
            long lrn = scanner.nextLong();
            scanner.nextLine(); // Consume the newline character

            String validationMessage = Student.validateLRN(lrn);

            if (validationMessage != null) {
                System.out.println(validationMessage);
                continue;
            }

            if (Student.findStudentByLRN(lrn, classSection.getStudents()) != null) {
                System.out.println(">> LRN already exists! Student LRN must be unique.");
                continue;
            }

            student.setLRN(lrn);
            break;
        }

        System.out.print("Enter Last Name: ");
        student.setLastName(scanner.nextLine().trim());

        System.out.print("Enter First Name: ");
        student.setFirstName(scanner.nextLine().trim());

        System.out.print("Enter Middle Name: ");
        student.setMiddleName(scanner.nextLine().trim());

        System.out.print("Enter Gender: ");
        student.setGender(scanner.nextLine().trim());

        // Validate birthdate input
        while (true) {
            System.out.print("Enter Birthdate (YYYY-MM-DD): ");
            String birthdate = scanner.nextLine().trim();
            String validationMessage = Person.validateBirthdate(birthdate);

            if (validationMessage == null) {
                student.setBirthdate(birthdate);
                break;
            } else {
                System.out.println(validationMessage);
            }
        }

        System.out.print("Enter Contact Number: ");
        student.setContactNumber(scanner.nextLong());

        scanner.nextLine(); // Consume the newline character after reading the contact number

        System.out.print("Enter Home Address: ");
        student.setHomeAddress(scanner.nextLine().trim());

        classSection.addStudent(student);
        System.out.println(">> Student added successfully!");
    }

    /**
     * Prompt interface to search for a student by LRN and edit their attributes.
     */
    private static void updateStudent() {
        System.out.println("--- UPDATE STUDENT ---");
        System.out.print("Enter LRN to Search: ");
        long lrn = scanner.nextLong();

        Student student = Student.findStudentByLRN(lrn, classSection.getStudents());

        if (student == null) {
            System.out.println(">> Student with LRN " + lrn + " not found!");
            return;
        }

        System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Enter updated details:");

        System.out.print("Enter Last Name: ");
        student.setLastName(scanner.nextLine().trim());

        System.out.print("Enter First Name: ");
        student.setFirstName(scanner.nextLine().trim());

        System.out.print("Enter Middle Name: ");
        student.setMiddleName(scanner.nextLine().trim());

        System.out.print("Enter Gender: ");
        student.setGender(scanner.nextLine().trim());

        while (true) {
            System.out.print("Enter Birthdate (YYYY-MM-DD): ");
            String birthdate = scanner.nextLine().trim();
            String validationMessage = Person.validateBirthdate(birthdate);

            if (validationMessage == null) {
                student.setBirthdate(birthdate);
                break;
            } else {
                System.out.println(validationMessage);
            }
        }

        System.out.print("Enter Contact Number: ");
        student.setContactNumber(scanner.nextLong());

        scanner.nextLine(); // Consume the newline character after reading the contact number

        System.out.print("Enter Home Address: ");
        student.setHomeAddress(scanner.nextLine().trim());

        classSection.sortStudents();
        System.out.println(">> Student updated successfully!");
    }
}