package Data_Structures_and_Algorithms.FinalProblem1.UniversityCourseEnrollmentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StudentHashTableES extends EnrollmentSystem {
    private final HashMap<Long, HashSet<Integer>> map;

    public StudentHashTableES() {
        map = new HashMap<>();
    }

    public void addEnrollment(long studentId, int courseId) {
        map.putIfAbsent(studentId, new HashSet<>());
        map.get(studentId).add(courseId);
    }

    public void removeEnrollment(long studentId, int courseId) {
        if (map.containsKey(studentId)) {
            map.get(studentId).remove(courseId);
        }
    }

    public boolean isEnrolled(long studentId, int courseId) {
        return map.containsKey(studentId) && map.get(studentId).contains(courseId);
    }

    public List<Long> getStudentsInCourse(int courseId) {
        List<Long> result = new ArrayList<>();

        for (Long studentId : map.keySet())
            if (map.get(studentId).contains(courseId))
                result.add(studentId);

        return result;
    }

    public List<Integer> getCoursesForStudent(long studentId) {
        if (!map.containsKey(studentId)) return new ArrayList<>();
        return new ArrayList<>(map.get(studentId));
    }
}
