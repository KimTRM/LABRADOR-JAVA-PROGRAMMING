package Data_Structures_and_Algorithms.FinalProblem1.UniversityCourseEnrollmentSystem;

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
                    3. OOP.ClassDirectoryRecordingApp.Student Hash Table
                    4. Exit
                    """);
            IO.print("Enter choice: ");
            int implementationChoice = scanner.nextInt();

            IO.println();

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
                    name = "OOP.ClassDirectoryRecordingApp.Student Hash Table";

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
                    5. Get Courses for OOP.ClassDirectoryRecordingApp.Student
                    6. Choose Different Implementation
                    """);

            IO.print("Choose an option: ");
            int choice = scanner.nextInt();

            IO.println();

            switch (choice) {
                case 1 -> {
                    IO.println("-- Add Enrollment --");
                    long studentId = getValidStudentId(scanner);
                    int courseId = getValidCourseId(scanner);

                    system.addEnrollment(studentId, courseId);
                    IO.println("Enrollment added " + studentId + " -> " + courseId);
                }
                case 2 -> {
                    IO.println("-- Remove Enrollment --");
                    long studentId = getValidStudentId(scanner);
                    int courseId = getValidCourseId(scanner);

                    system.removeEnrollment(studentId, courseId);
                    IO.println("Enrollment removed " + studentId + " -> " + courseId);
                }
                case 3 -> {
                    IO.println("-- Check Enrollment --");
                    long studentId = getValidStudentId(scanner);
                    int courseId = getValidCourseId(scanner);

                    boolean enrolled = system.isEnrolled(studentId, courseId);
                    IO.println("Enrolled: " + enrolled);
                }
                case 4 -> {
                    IO.println("-- Get Students in Course --");
                    int courseId = getValidCourseId(scanner);

                    var studentsInCourse = system.getStudentsInCourse(courseId);
                    IO.println("Students in Course: " + studentsInCourse);
                }
                case 5 -> {
                    IO.println("-- Get Courses for Students --");
                    long studentId = getValidStudentId(scanner);

                    var coursesForStudent = system.getCoursesForStudent(studentId);
                    IO.println("Courses for OOP.ClassDirectoryRecordingApp.Student: " + coursesForStudent);
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

    static long getValidStudentId(Scanner scanner) {
        long studentId;

        while (true) {
            IO.print("Enter OOP.ClassDirectoryRecordingApp.Student ID: ");
            studentId = scanner.nextLong();

            if (studentId < 1000000 || studentId > 9999999)
                IO.println("Invalid OOP.ClassDirectoryRecordingApp.Student ID. Please enter a 7-digit number.");
            else
                break;
        }

        return studentId;
    }

    static int getValidCourseId(Scanner scanner) {
        int courseId;

        while (true) {
            IO.print("Enter course ID: ");
            courseId = scanner.nextInt();

            if (courseId < 1000 || courseId > 9999)
                IO.println("Invalid course ID. Please enter a 4-digit number.");
            else
                break;
        }

        return courseId;
    }
}
