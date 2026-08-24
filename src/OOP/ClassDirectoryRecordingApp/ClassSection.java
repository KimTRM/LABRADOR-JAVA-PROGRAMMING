package OOP.ClassDirectoryRecordingApp;

import java.io.*;
import java.util.ArrayList;

public class ClassSection {

    // ================ ATTRIBUTES =================

    private String gradeLevel;
    private String sectionName;

    // Composition
    private Adviser adviser;
    private final ArrayList<Student> students;


    // ================ CONSTRUCTOR =================

    public ClassSection() {
        students = new ArrayList<>();
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

    // Adds a student to this class section
    public boolean addStudent(Student student) {
        if (findStudent(student.getLRN()) != null) {
            return false;
        }

        students.add(student);
        sortStudents();

        return true;
    }

    // Searches for a student using LRN
    public Student findStudent(long LRN) {
        for (Student student : students) {
            if (student.getLRN() == LRN) {
                return student;
            }
        }

        return null;
    }

    // Updates an existing student
    public boolean updateStudent(long LRN, Student newStudent) {
        Student student = findStudent(LRN);

        if (student == null) {
            return false;
        }

        student.setLRN(newStudent.getLRN());
        student.setLastName(newStudent.getLastName());
        student.setFirstName(newStudent.getFirstName());
        student.setMiddleName(newStudent.getMiddleName());
        student.setGender(newStudent.getGender());
        student.setBirthdate(newStudent.getBirthdate());
        student.setContactNumber(newStudent.getContactNumber());
        student.setHomeAddress(newStudent.getHomeAddress());

        sortStudents();

        return true;
    }


    // ================ CUSTOM SORTING =================

    // Sorts the students in this class section alphabetically by last name, then first name
    public void sortStudents() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {

                Student first = students.get(i);
                Student second = students.get(j);

                int lastNameCompare = first.getLastName()
                        .compareToIgnoreCase(second.getLastName());

                if (lastNameCompare > 0) {
                    students.set(i, second);
                    students.set(j, first);
                } else if (lastNameCompare == 0) {

                    int firstNameCompare = first.getFirstName()
                            .compareToIgnoreCase(second.getFirstName());

                    if (firstNameCompare > 0) {
                        students.set(i, second);
                        students.set(j, first);
                    }
                }
            }
        }
    }


    // ================ DISPLAY =================

    public void displayDirectory() {
        sortStudents();

        System.out.println("==================================================");
        System.out.println("CLASS SECTION DIRECTORY");
        System.out.println("Grade Level: " + gradeLevel + " Section Name: " + sectionName);
        System.out.println("--------------------------------------------------");
        System.out.println("ADVISER INFORMATION:");

        if (adviser == null) {
            System.out.println("No adviser assigned yet.");
        } else {
            System.out.println("Name: Prof. " + adviser.getFirstName() + " "
                    + adviser.getMiddleName() + " " + adviser.getLastName());

            System.out.println("Gender: " + adviser.getGender()
                    + " | Birthdate: " + adviser.getBirthdate()
                    + " (Age: " + adviser.getComputedAge() + ")");

            System.out.println("Contact: " + adviser.getContactNumber()
                    + " | Degree: " + adviser.getHighestDegreeEarned());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("ENROLLED STUDENTS (Sorted Alphabetically - Total: "
                + students.size() + ")");

        if (students.isEmpty()) {
            System.out.println("No students enrolled yet.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);

                System.out.println("[" + (i + 1) + "] LRN: " + student.getLRN());
                System.out.println("Name: " + student.getLastName() + ", "
                        + student.getFirstName() + " " + student.getMiddleName());

                System.out.println("Gender: " + student.getGender()
                        + " | Birthdate: " + student.getBirthdate()
                        + " (Age: " + student.getComputedAge() + ")"
                        + " | Contact: " + student.getContactNumber());

                System.out.println("Address: " + student.getHomeAddress());
            }
        }

        System.out.println("==================================================");
    }


    // ================ FILE METHODS =================

    // Saves this section to its own text file
    public boolean saveToFile() {
        File folder = new File("ClassDirectories");

        // Creates the folder if it does not exist
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(new File(folder, getFileName())));

            writer.println("GRADE=" + gradeLevel);
            writer.println("SECTION=" + sectionName);

            writer.println("ADVISER");

            if (adviser == null) {
                writer.println("NONE");
            } else {
                writer.println(adviser.getLastName());
                writer.println(adviser.getFirstName());
                writer.println(adviser.getMiddleName());
                writer.println(adviser.getGender());
                writer.println(adviser.getBirthdate());
                writer.println(adviser.getContactNumber());
                writer.println(adviser.getHighestDegreeEarned());
            }

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

            writer.close();
            return true;

        } catch (IOException e) {
            System.out.println(">> Error saving file.");
            return false;
        }
    }

    // Loads this section from its text file
    public boolean loadFromFile() {
        File file = new File("ClassDirectories", getFileName());

        if (!file.exists()) {
            System.out.println(">> File not found.");
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            students.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("GRADE=")) {
                    gradeLevel = line.substring(6);
                } else if (line.startsWith("SECTION=")) {
                    sectionName = line.substring(8);
                } else if (line.equals("ADVISER")) {

                    line = reader.readLine();

                    if (!line.equals("NONE")) {
                        Adviser newAdviser = new Adviser();

                        newAdviser.setLastName(line);
                        newAdviser.setFirstName(reader.readLine());
                        newAdviser.setMiddleName(reader.readLine());
                        newAdviser.setGender(reader.readLine());
                        newAdviser.setBirthdate(reader.readLine());
                        newAdviser.setContactNumber(Long.parseLong(reader.readLine()));
                        newAdviser.setHighestDegreeEarned(reader.readLine());

                        adviser = newAdviser;
                    }

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

            reader.close();
            sortStudents();

            return true;

        } catch (Exception e) {
            System.out.println(">> Error loading file.");
            return false;
        }
    }

    // Creates the filename for this section
    private String getFileName() {
        String name = gradeLevel + "_" + sectionName;
        name = name.replaceAll("[^a-zA-Z0-9_-]", "_");

        return name + ".txt";
    }
}
