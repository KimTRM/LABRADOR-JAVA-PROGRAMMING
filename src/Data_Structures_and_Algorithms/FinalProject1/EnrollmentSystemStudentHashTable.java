package Data_Structures_and_Algorithms.FinalProject1;

import java.util.*;

public class EnrollmentSystemStudentHashTable {

    static void main() {
        HashMap<Long, HashSet<Integer>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            IO.println("""
                    Enrollment System Student - Choose an option:
                    1. Add Enrollment
                    2. Remove Enrollment
                    3. Check Enrollment
                    4. Get Courses for Student
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

                    addEnrollment(map, studentId, courseId);
                    IO.println("Enrollment added.");
                }
                case 2 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    removeEnrollment(map, studentId, courseId);
                    IO.println("Enrollment removed.");
                }
                case 3 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();
                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    boolean enrolled = isEnrolled(map, studentId, courseId);
                    IO.println("Student " + studentId + (enrolled ? " is " : " is not ") + "enrolled in course " + courseId + ".");
                }
                case 4 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    List<Integer> courses = getCoursesForStudent(map, studentId);
                    if (courses.isEmpty()) {
                        IO.println("Student " + studentId + " is not enrolled in any courses.");
                    } else {
                        IO.println("Student " + studentId + " is enrolled in courses: " + courses);
                    }
                }
                case 5 -> {
                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    List<Long> students = getStudentsInCourse(map, courseId);
                    if (students.isEmpty()) {
                        IO.println("No students are enrolled in course " + courseId + ".");
                    } else {
                        IO.println("Students enrolled in course " + courseId + ": " + students);
                    }
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

    public static void addEnrollment(HashMap<Long, HashSet<Integer>> map, long studentId, int courseId) {
        map.putIfAbsent(studentId, new HashSet<>());
        map.get(studentId).add(courseId);
    }

    public static void removeEnrollment(HashMap<Long, HashSet<Integer>> map, long studentId, int courseId) {
        if (map.containsKey(studentId)) {
            map.get(studentId).remove(courseId);
        }
    }

    public static boolean isEnrolled(HashMap<Long, HashSet<Integer>> map, long studentId, int courseId) {
        return map.containsKey(studentId) && map.get(studentId).contains(courseId);
    }

    public static List<Long> getStudentsInCourse(HashMap<Long, HashSet<Integer>> map, int courseId) {
        List<Long> result = new ArrayList<>();

        for (Long studentId : map.keySet())
            if (map.get(studentId).contains(courseId))
                result.add(studentId);

        return result;
    }

    public static List<Integer> getCoursesForStudent(HashMap<Long, HashSet<Integer>> map, long studentId) {
        if (!map.containsKey(studentId)) return new ArrayList<>();
        return new ArrayList<>(map.get(studentId));
    }
}
