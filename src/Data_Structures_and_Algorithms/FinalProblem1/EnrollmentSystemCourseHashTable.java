package Data_Structures_and_Algorithms.FinalProblem1;

import java.util.*;

public class EnrollmentSystemCourseHashTable {

    static void main() {
        HashMap<Integer, HashSet<Long>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            IO.println("""
                    Enrollment System Course - Choose an option:
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
                    IO.println("OOP.ClassDirectoryRecordingApp.Student " + studentId + (enrolled ? " is " : " is not ") + "enrolled in course " + courseId + ".");
                }
                case 4 -> {
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    List<Integer> courses = getCoursesForStudent(map, studentId);
                    if (courses.isEmpty()) {
                        IO.println("OOP.ClassDirectoryRecordingApp.Student " + studentId + " is not enrolled in any courses.");
                    } else {
                        IO.println("OOP.ClassDirectoryRecordingApp.Student " + studentId + " is enrolled in courses: " + courses);
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
            }

            IO.println();
        }
    }

    public static void addEnrollment(HashMap<Integer, HashSet<Long>> map, long studentId, int courseId) {
        map.putIfAbsent(courseId, new HashSet<>());
        map.get(courseId).add(studentId);
    }

    public static void removeEnrollment(HashMap<Integer, HashSet<Long>> map, long studentId, int courseId) {
        if (map.containsKey(courseId)) {
            map.get(courseId).remove(studentId);
        }
    }

    public static boolean isEnrolled(HashMap<Integer, HashSet<Long>> map, long studentId, int courseId) {
        return map.containsKey(courseId) && map.get(courseId).contains(studentId);
    }

    public static List<Long> getStudentsInCourse(HashMap<Integer, HashSet<Long>> map, int courseId) {
        if (!map.containsKey(courseId)) return new ArrayList<>();
        return new ArrayList<>(map.get(courseId));
    }

    public static List<Integer> getCoursesForStudent(HashMap<Integer, HashSet<Long>> map, long studentId) {
        List<Integer> result = new ArrayList<>();

        for (Integer courseId : map.keySet())
            if (map.get(courseId).contains(studentId))
                result.add(courseId);

        return result;
    }

}