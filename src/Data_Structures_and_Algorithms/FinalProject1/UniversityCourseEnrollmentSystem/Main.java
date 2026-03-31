package Data_Structures_and_Algorithms.FinalProject1.UniversityCourseEnrollmentSystem;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        EnrollmentSystem system = null;
        String name;

        while (true) {
            IO.println("""
                    Choose Enrollment System Implementation:
                    1. Direct Address Table
                    2. Course Hash Table
                    3. Student Hash Table
                    4. Exit
                    """);
            IO.print("Enter choice: ");
            int implementationChoice = scanner.nextInt();

            switch (implementationChoice) {
                case 1 -> {
                    system = new DirectAddressTableES();
                    name = "Direct Address Table";

                    run(system, scanner, name);
                }
                case 2 -> {
                    system = new CourseHashTableES();
                    name = "Course Hash Table";

                    run(system, scanner, name);
                }
                case 3 -> {
                    system = new StudentHashTableES();
                    name = "Student Hash Table";

                    run(system, scanner, name);
                }
                case 4 -> {
                    IO.println("Exiting...");
                    return;
                }
                default -> IO.println("Invalid choice.");
            }

            IO.println();
        }
    }

    static void run(EnrollmentSystem system, Scanner scanner, String name) {
        while (true) {
            IO.println("----- Current Implementation: " + name + " -----");
            IO.println("""
                    1. Add Enrollment
                    2. Remove Enrollment
                    3. Check Enrollment
                    4. Get Students in Course
                    5. Get Courses for Student
                    6. Choose Different Implementation
                    """);

            IO.print("Choose an option: ");
            int choice = scanner.nextInt();

            IO.println();

            switch (choice) {
                case 1 -> {
                    IO.println("-- Add Enrollment --");
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    system.addEnrollment(studentId, courseId);
                    IO.println("Enrollment added " + studentId + " -> " + courseId);
                }
                case 2 -> {
                    IO.println("-- Remove Enrollment --");
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    system.removeEnrollment(studentId, courseId);
                    IO.println("Enrollment removed " + studentId + " -> " + courseId);
                }
                case 3 -> {
                    IO.println("-- Check Enrollment --");
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    boolean enrolled = system.isEnrolled(studentId, courseId);
                    IO.println("Enrolled: " + enrolled);
                }
                case 4 -> {
                    IO.println("-- Get Students in Course --");
                    IO.print("Enter course ID: ");
                    int courseId = scanner.nextInt();

                    var studentsInCourse = system.getStudentsInCourse(courseId);
                    IO.println("Students in Course: " + studentsInCourse);
                }
                case 5 -> {
                    IO.println("-- Get Courses for Students --");
                    IO.print("Enter student ID: ");
                    long studentId = scanner.nextLong();

                    var coursesForStudent = system.getCoursesForStudent(studentId);
                    IO.println("Courses for Student: " + coursesForStudent);
                }
                case 6 -> {
                    IO.print("Exiting...");
                    return;
                }
                default -> IO.println("Invalid option. Please try again.");
            }

            IO.println();
        }
    }
}
