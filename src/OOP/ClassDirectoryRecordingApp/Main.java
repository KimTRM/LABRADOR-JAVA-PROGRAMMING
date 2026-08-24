package OOP.ClassDirectoryRecordingApp;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<ClassSection> sections = new ArrayList<>();

    private static ClassSection currentSection;

    static void main(String[] args) {

        loadAvailableSections();

        IO.println("=== SCHOOL CLASS DIRECTORY SYSTEM ===");

        while (true) {

            IO.println();

            if (currentSection != null) {
                IO.println("Current Section: "
                        + currentSection.getGradeLevel() + " - "
                        + currentSection.getSectionName());
            } else {
                IO.println("Current Section: None");
            }

            IO.println();

            IO.println("""
                    [1] Create New Class Section
                    [2] Select Class Section
                    [3] View Class Section
                    [4] Assign/Update Adviser
                    [5] Add Student
                    [6] Update Student
                    [7] Save Class Section
                    [8] Load Class Section
                    [9] List Class Sections
                    [10] Exit
                    """);

            int choice = readInt("Select an option: ");

            IO.println();

            switch (choice) {
                case 1 -> createSection();
                case 2 -> selectSection();
                case 3 -> viewSection();
                case 4 -> assignAdviser();
                case 5 -> addStudent();
                case 6 -> updateStudent();
                case 7 -> saveSection();
                case 8 -> loadSection();
                case 9 -> listSections();
                case 10 -> {
                    IO.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> IO.println(">> Invalid option. Please choose 1-10.");
            }
        }
    }


    // ================ CREATE SECTION ================
    private static void createSection() {

        IO.println("--- CREATE NEW CLASS SECTION ---");

        String grade = readText("Enter Grade Level: ");
        String name = readText("Enter Section Name: ");

        for (ClassSection section : sections) {
            if (section.getGradeLevel().equalsIgnoreCase(grade)
                    && section.getSectionName().equalsIgnoreCase(name)) {

                IO.println(">> This class section already exists.");
                return;
            }
        }

        ClassSection section = new ClassSection();

        section.setGradeLevel(grade);
        section.setSectionName(name);

        sections.add(section);
        currentSection = section;

        section.saveToFile();

        IO.println(">> Class section created successfully!");
        IO.println(">> File created in ClassDirectories folder.");
    }

    // ================ SELECT SECTION =================
    private static void selectSection() {

        if (sections.isEmpty()) {
            IO.println(">> No class sections available.");
            return;
        }

        listSections();

        int choice = readInt("Select class section number: ");

        if (choice < 1 || choice > sections.size()) {
            IO.println(">> Invalid section number.");
            return;
        }

        currentSection = sections.get(choice - 1);

        IO.println(">> Class section selected successfully.");
    }

    // ================ VIEW SECTION =================
    private static void viewSection() {

        if (checkSection()) {
            return;
        }

        currentSection.displayDirectory();
    }

    // ================ ADVISER =================
    private static void assignAdviser() {

        if (checkSection()) {
            return;
        }

        IO.println("--- ASSIGN/UPDATE ADVISER ---");

        Adviser adviser = new Adviser();

        adviser.setLastName(readText("Enter Last Name: "));
        adviser.setFirstName(readText("Enter First Name: "));
        adviser.setMiddleName(readText("Enter Middle Name: "));
        adviser.setGender(readText("Enter Gender: "));
        adviser.setBirthdate(readBirthdate());
        adviser.setContactNumber(readLong("Enter Contact Number: "));
        adviser.setHighestDegreeEarned(readText("Enter Highest Degree Earned: "));

        currentSection.setAdviser(adviser);

        IO.println(">> Adviser information updated successfully!");
    }

    // ================ ADD STUDENT =================
    private static void addStudent() {

        if (checkSection()) {
            return;
        }

        IO.println("--- ADD NEW STUDENT ---");

        Student student = new Student();

        long LRN;

        while (true) {

            LRN = readLong("Enter LRN: ");

            String message = Student.validateLRN(LRN);

            if (message != null) {
                IO.println(message);
                continue;
            }

            if (currentSection.findStudent(LRN) != null) {
                IO.println(">> LRN already exists!");
                continue;
            }

            break;
        }

        student.setLRN(LRN);
        student.setLastName(readText("Enter Last Name: "));
        student.setFirstName(readText("Enter First Name: "));
        student.setMiddleName(readText("Enter Middle Name: "));
        student.setGender(readText("Enter Gender: "));
        student.setBirthdate(readBirthdate());
        student.setContactNumber(readLong("Enter Contact Number: "));
        student.setHomeAddress(readText("Enter Home Address: "));

        currentSection.addStudent(student);

        IO.println(">> Student added successfully!");
    }

    // ================ UPDATE STUDENT =================
    private static void updateStudent() {

        if (checkSection()) {
            return;
        }

        IO.println("--- UPDATE STUDENT ---");

        long LRN = readLong("Enter LRN to Search: ");

        Student oldStudent = currentSection.findStudent(LRN);

        if (oldStudent == null) {
            IO.println(">> Student with LRN " + LRN + " not found!");
            return;
        }

        IO.println("Student found: " + oldStudent.getFirstName()
                + " " + oldStudent.getLastName());

        Student newStudent = new Student();

        long newLRN;

        while (true) {

            newLRN = readLong("Enter New LRN: ");

            String message = Student.validateLRN(newLRN);

            if (message != null) {
                IO.println(message);
                continue;
            }

            Student existing = currentSection.findStudent(newLRN);

            if (existing != null && existing != oldStudent) {
                IO.println(">> That LRN already belongs to another student.");
                continue;
            }

            break;
        }

        newStudent.setLRN(newLRN);
        newStudent.setLastName(readText("Enter Last Name: "));
        newStudent.setFirstName(readText("Enter First Name: "));
        newStudent.setMiddleName(readText("Enter Middle Name: "));
        newStudent.setGender(readText("Enter Gender: "));
        newStudent.setBirthdate(readBirthdate());
        newStudent.setContactNumber(readLong("Enter Contact Number: "));
        newStudent.setHomeAddress(readText("Enter Home Address: "));

        currentSection.updateStudent(LRN, newStudent);

        IO.println(">> Student updated successfully!");
    }

    // ================ SAVE =================
    private static void saveSection() {

        if (checkSection()) {
            return;
        }

        if (currentSection.saveToFile()) {
            IO.println(">> Class section saved successfully!");
        } else {
            IO.println(">> Failed to save class section.");
        }
    }


    // ================ LOAD =================
    private static void loadSection() {

        if (sections.isEmpty()) {
            IO.println(">> No class sections available.");
            return;
        }

        listSections();

        int choice = readInt("Select section to load: ");

        if (choice < 1 || choice > sections.size()) {
            IO.println(">> Invalid section number.");
            return;
        }

        ClassSection section = sections.get(choice - 1);

        if (section.loadFromFile()) {
            currentSection = section;
            IO.println(">> Class section loaded successfully!");
        } else {
            IO.println(">> Failed to load class section.");
        }
    }

    // Loads existing class section files from the ClassDirectories folder
    private static void loadAvailableSections() {

        File folder = new File("ClassDirectories");

        if (!folder.exists()) {
            folder.mkdirs();
            return;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {

            if (!file.getName().endsWith(".txt")) {
                continue;
            }

            String fileName = file.getName().replace(".txt", "");
            String[] parts = fileName.split("_", 2);

            if (parts.length != 2) {
                continue;
            }

            ClassSection section = new ClassSection();

            section.setGradeLevel(parts[0]);
            section.setSectionName(parts[1]);

            if (section.loadFromFile()) {
                sections.add(section);
            }
        }
    }

    // ================ LIST SECTIONS =================
    private static void listSections() {

        if (sections.isEmpty()) {
            IO.println(">> No class sections found.");
            return;
        }

        IO.println("--- AVAILABLE CLASS SECTIONS ---");

        for (int i = 0; i < sections.size(); i++) {

            ClassSection section = sections.get(i);

            IO.println("[" + (i + 1) + "] "
                    + section.getGradeLevel() + " - "
                    + section.getSectionName());
        }
    }


    // ================ INPUT METHODS =================

    // Reads text input and prevents empty values
    private static String readText(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                IO.println(">> This field cannot be empty.");
            } else {
                return input;
            }
        }
    }

    // Reads a long number without crashing
    private static long readLong(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                IO.println(">> Please enter a valid number.");
            }
        }
    }

    // Reads an integer without crashing
    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                IO.println(">> Please enter a valid number.");
            }
        }
    }

    // Reads and validates a birthdate
    private static String readBirthdate() {

        while (true) {

            String birthdate = readText("Enter Birthdate (YYYY-MM-DD): ");
            String message = Person.validateBirthdate(birthdate);

            if (message == null) {
                return birthdate;
            }

            IO.println(message);
        }
    }

    // Checks if a class section is currently selected
    private static boolean checkSection() {

        if (currentSection == null) {
            IO.println(">> Please select a class section first.");
            return true;
        }

        return false;
    }
}
