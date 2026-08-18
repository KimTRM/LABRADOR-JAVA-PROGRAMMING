package OOP.ClassDirectoryRecordingApp;

import java.io.*;
import java.util.ArrayList;

public class ClassSection {

    // ================ ATTRIBUTES =================

    private String gradeLevel;
    private String sectionName;

    // ClassSection contains one adviser
    private Adviser adviser;

    // ClassSection contains a list of enrolled students
    private final ArrayList<Student> students;

    // ================ CONSTRUCTOR =================

    public ClassSection() {
        this.students = new ArrayList<>();
    }

    // ================ GETTERS =================

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Adviser getAdviser() {
        return adviser;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // ================ SETTERS =================

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setAdviser(Adviser adviser) {
        this.adviser = adviser;
    }

    // ================ STUDENT METHODS =================

    /**
     * Adds a student to the roster and sorts the list alphabetically.
     *
     * @param student Student instance to append.
     */
    public void addStudent(Student student) {
        students.add(student);
        sortStudents();
    }

    /**
     * Sorts students alphabetically by Last Name (Primary),
     * using First Name as a secondary sort if Last Names are identical.
     */
    public void sortStudents() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {

                Student first = students.get(i);
                Student second = students.get(j);

                int lastNameCompare = first.getLastName().compareToIgnoreCase(second.getLastName());

                // Swap if the second student's last name comes before the first student's
                if (lastNameCompare > 0) {
                    students.set(i, second);
                    students.set(j, first);
                }
                // If last names match, compare first names
                else if (lastNameCompare == 0) {
                    int firstNameCompare = first.getFirstName().compareToIgnoreCase(second.getFirstName());

                    if (firstNameCompare > 0) {
                        students.set(i, second);
                        students.set(j, first);
                    }
                }
            }
        }
    }

    // ================ FILE PROCESSING & DETECTION =================

    /**
     * Checks if a saved directory file already exists on the local storage.
     *
     * @return true if ClassDirectory.txt exists, false otherwise.
     */
    public boolean hasExistingDirectoryFile() {
        File file = new File("ClassDirectory.txt");
        return file.exists() && file.isFile();
    }

    /**
     * Exports all class section details, adviser profile, and student records
     * to a formatted text file (ClassDirectory.txt).
     */
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ClassDirectory.txt"))) {

            writer.println("GRADE=" + (gradeLevel != null ? gradeLevel : ""));
            writer.println("SECTION=" + (sectionName != null ? sectionName : ""));

            // Save Adviser Profile
            if (adviser != null) {
                writer.println("ADVISER");
                writer.println(adviser.getLastName());
                writer.println(adviser.getFirstName());
                writer.println(adviser.getMiddleName());
                writer.println(adviser.getGender());
                writer.println(adviser.getBirthdate());
                writer.println(adviser.getContactNumber());
                writer.println(adviser.getHighestDegreeEarned());
            }

            // Save Student List
            writer.println("STUDENTS");
            for (Student student : students) {
                writer.println("STUDENT");
                writer.println(student.getLRN());
                writer.println(student.getLastName());
                writer.println(student.getFirstName());
                writer.println(student.getMiddleName());
                writer.println(student.getGender());
                writer.println(student.getBirthdate());
                writer.println(student.getContactNumber());
                writer.println(student.getHomeAddress());
            }

            System.out.println(">> Directory successfully saved to ClassDirectory.txt");

        } catch (IOException e) {
            System.out.println(">> Error saving file: " + e.getMessage());
        }
    }

    /**
     * Parses ClassDirectory.txt and populates the ClassSection, Adviser,
     * and Student objects in memory. Automatically sorts roster after loading.
     */
    public void loadFromFile() {
        if (!hasExistingDirectoryFile()) {
            System.out.println(">> File ClassDirectory.txt not found. No existing section data loaded.");
            return;
        }

        File file = new File("ClassDirectory.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            students.clear();
            String line;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("GRADE=")) {
                    gradeLevel = line.substring(6);
                } else if (line.startsWith("SECTION=")) {
                    sectionName = line.substring(8);
                } else if (line.equals("ADVISER")) {

                    Adviser newAdviser = new Adviser();
                    newAdviser.setLastName(reader.readLine());
                    newAdviser.setFirstName(reader.readLine());
                    newAdviser.setMiddleName(reader.readLine());
                    newAdviser.setGender(reader.readLine());
                    newAdviser.setBirthdate(reader.readLine());
                    newAdviser.setContactNumber(Long.parseLong(reader.readLine()));
                    newAdviser.setHighestDegreeEarned(reader.readLine());

                    adviser = newAdviser;

                } else if (line.equals("STUDENT")) {

                    Student student = new Student();
                    student.setLRN(Long.parseLong(reader.readLine()));
                    student.setLastName(reader.readLine());
                    student.setFirstName(reader.readLine());
                    student.setMiddleName(reader.readLine());
                    student.setGender(reader.readLine());
                    student.setBirthdate(reader.readLine());
                    student.setContactNumber(Long.parseLong(reader.readLine()));
                    student.setHomeAddress(reader.readLine());

                    students.add(student);
                }
            }

            sortStudents();
            System.out.println(">> Existing section directory loaded successfully!");

        } catch (IOException e) {
            System.out.println(">> Error loading file: " + e.getMessage());
        }
    }
}