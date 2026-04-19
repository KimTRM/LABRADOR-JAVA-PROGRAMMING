package Data_Structures_and_Algorithms.FinalProblem1.UniversityCourseEnrollmentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DirectAddressTableES extends EnrollmentSystem {
    private final HashMap<Long, boolean[]> table;

    private final int COURSE_MIN = 1000;
    private final int COURSE_MAX = 9999;
    private final int COURSE_SIZE = COURSE_MAX - COURSE_MIN + 1;

    public DirectAddressTableES() {
        table = new HashMap<>();
    }

    private int cIndex(int courseId) {
        return courseId - COURSE_MIN;
    }

    public void addEnrollment(long studentId, int courseId) {
        table.putIfAbsent(studentId, new boolean[COURSE_SIZE]);
        table.get(studentId)[cIndex(courseId)] = true;
    }

    public void removeEnrollment(long studentId, int courseId) {
        if (table.containsKey(studentId)) {
            table.get(studentId)[cIndex(courseId)] = false;
        }
    }

    public boolean isEnrolled(long studentId, int courseId) {
        return table.containsKey(studentId) && table.get(studentId)[cIndex(courseId)];
    }

    public List<Integer> getCoursesForStudent(long studentId) {
        List<Integer> result = new ArrayList<>();

        if (!table.containsKey(studentId)) return result;

        boolean[] courses = table.get(studentId);

        for (int i = 0; i < COURSE_SIZE; i++)
            if (courses[i])
                result.add(i + COURSE_MIN);

        return result;
    }

    public List<Long> getStudentsInCourse(int courseId) {
        List<Long> result = new ArrayList<>();
        int cIdx = cIndex(courseId);

        for (Long studentId : table.keySet())
            if (table.get(studentId)[cIdx])
                result.add(studentId);

        return result;
    }
}
