package Data_Structures_and_Algorithms.FinalProblem1.UniversityCourseEnrollmentSystem;

import java.util.List;

public abstract class EnrollmentSystem {

    /**
     * Adds a student to a course. If the student is already enrolled in the course, this method should have no effect.
     */
    public abstract void addEnrollment(long studentId, int courseId);

    /**
     * Removes a student from a course. If the student is not enrolled in the course, this method should have no effect.
     */
    public abstract void removeEnrollment(long studentId, int courseId);

    /**
     * Checks if a student is enrolled in a course.
     *
     * @return true if the student is enrolled in the course, false otherwise.
     */
    public abstract boolean isEnrolled(long studentId, int courseId);

    /**
     * Retrieves a list of student IDs enrolled in a specific course.
     *
     * @return a list of student IDs enrolled in the course.
     */
    public abstract List<Long> getStudentsInCourse(int courseId);

    /**
     * Retrieves a list of course IDs that a specific student is enrolled in.
     *
     * @return a list of course IDs that the student is enrolled in.
     */
    public abstract List<Integer> getCoursesForStudent(long studentId);
}
