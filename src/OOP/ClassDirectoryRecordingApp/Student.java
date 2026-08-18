package OOP.ClassDirectoryRecordingApp;

import java.util.ArrayList;

public class Student extends Person {

    // ================ ATTRIBUTES =================

    private long LRN;
    private String homeAddress;

    // ================ GETTERS =================

    public long getLRN() {
        return LRN;
    }

    public String getHomeAddress() {
        return homeAddress;
    }


    // ================ SETTERS =================

    public void setLRN(long LRN) {
        this.LRN = LRN;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    // ================ ADDITIONAL METHODS =================

    /**
     * Validates that the LRN contains exactly 12 digits.
     */
    public static String validateLRN(long LRN) {
        if (String.valueOf(LRN).length() != 12)
            return ">> LRN must be 12 digits long!";

        return null;
    }

    /**
     * Finds a student by their LRN in the provided list of students.
     *
     * @param lrn      The LRN of the student to find.
     * @param students The list of students to search through.
     * @return The Student object if found, otherwise null.
     */
    static Student findStudentByLRN(long lrn, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getLRN() == lrn) {
                return student;
            }
        }
        return null;
    }
}
