package Data_Structures_and_Algorithms.FinalProject1.UniversityCourseEnrollmentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseHashTableES extends EnrollmentSystem {
    private final HashMap<Integer, HashSet<Long>> map;

    public CourseHashTableES() {
        map = new HashMap<>();
    }

    public void addEnrollment(long studentId, int courseId) {
        map.putIfAbsent(courseId, new HashSet<>());
        map.get(courseId).add(studentId);
    }

    public void removeEnrollment(long studentId, int courseId) {
        if (map.containsKey(courseId)) {
            map.get(courseId).remove(studentId);
        }
    }

    public boolean isEnrolled(long studentId, int courseId) {
        return map.containsKey(courseId) && map.get(courseId).contains(studentId);
    }

    public List<Long> getStudentsInCourse(int courseId) {
        if (!map.containsKey(courseId)) return new ArrayList<>();
        return new ArrayList<>(map.get(courseId));
    }

    public List<Integer> getCoursesForStudent(long studentId) {
        List<Integer> result = new ArrayList<>();

        for (Integer courseId : map.keySet())
            if (map.get(courseId).contains(studentId))
                result.add(courseId);

        return result;
    }
}
