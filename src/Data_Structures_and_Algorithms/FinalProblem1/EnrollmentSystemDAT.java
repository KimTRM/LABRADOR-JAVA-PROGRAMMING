package Data_Structures_and_Algorithms.FinalProblem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EnrollmentSystemDAT {
    private static int COURSE_MIN;
    private static int COURSE_MAX;
    private static int COURSE_SIZE;

    static void main() {
        HashMap<Long, boolean[]> table = new HashMap<>();

        COURSE_MIN = 1000;
        COURSE_MAX = 9999;
        COURSE_SIZE = COURSE_MAX - COURSE_MIN + 1;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            IO.println("""
                    Enrollment System DAT - Choose an option:
                    1. Add Enrollment
                    2. Remove Enrollment
                    3. Check Enrollment
                    4. Get Courses for OOP.ClassDirectoryRecordingApp.Student
                    5. Get Students in Course
                    6. Exit
                    """);
            IO.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    addEnrollment(table, studentId, courseId);
                    IO.println("Enrollment added.");
                }
                case 2 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    removeEnrollment(table, studentId, courseId);
                    IO.println("Enrollment removed.");
                }
                case 3 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();
                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    boolean enrolled = isEnrolled(table, studentId, courseId);
                    IO.println("OOP.ClassDirectoryRecordingApp.Student " + studentId + (enrolled ? " is " : " is not ") + "enrolled in course " + courseId + ".");
                }
                case 4 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    List<Integer> courses = getCoursesForStudent(table, studentId);
                    IO.println("Courses for student " + studentId + ": " + courses);
                }
                case 5 -> {
                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    List<Long> students = getStudentsInCourse(table, courseId);
                    IO.println("Students in course " + courseId + ": " + students);
                }
                case 6 -> {
                    IO.println("Exiting...");
                    return;
                }
                default -> IO.println("Invalid choice. Please try again.");
            }

            IO.println();
        }
    }

    private static int cIndex(int courseId) {
        return courseId - COURSE_MIN;
    }

    public static void addEnrollment(HashMap<Long, boolean[]> table, long studentId, int courseId) {
        table.putIfAbsent(studentId, new boolean[COURSE_SIZE]);
        table.get(studentId)[cIndex(courseId)] = true;
    }

    public static void removeEnrollment(HashMap<Long, boolean[]> table, long studentId, int courseId) {
        if (table.containsKey(studentId)) {
            table.get(studentId)[cIndex(courseId)] = false;
        }
    }

    public static boolean isEnrolled(HashMap<Long, boolean[]> table, long studentId, int courseId) {
        return table.containsKey(studentId) && table.get(studentId)[cIndex(courseId)];
    }

    public static List<Integer> getCoursesForStudent(HashMap<Long, boolean[]> table, long studentId) {
        List<Integer> result = new ArrayList<>();

        if (!table.containsKey(studentId)) return result;

        boolean[] courses = table.get(studentId);

        for (int i = 0; i < COURSE_SIZE; i++)
            if (courses[i])
                result.add(i + COURSE_MIN);

        return result;
    }

    public static List<Long> getStudentsInCourse(HashMap<Long, boolean[]> table, int courseId) {
        List<Long> result = new ArrayList<>();
        int cIdx = cIndex(courseId);

        for (Long studentId : table.keySet())
            if (table.get(studentId)[cIdx])
                result.add(studentId);

        return result;
    }
}
