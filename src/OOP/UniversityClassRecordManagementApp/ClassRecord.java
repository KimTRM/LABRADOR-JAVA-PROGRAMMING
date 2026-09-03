package OOP.UniversityClassRecordManagementApp;

import java.util.ArrayList;
import java.util.List;

public class ClassRecord implements ClassList {
    private Collage college;
    private Program program;
    private Course course;
    private Faculty faculty;
    private final List<Student> students = new ArrayList<>();

    @Override
    public void assignCollege(Collage college) {
        this.college = college;
    }

    @Override
    public void assignProgram(Program program) {
        this.program = program;
    }

    @Override
    public void assignInstructor(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean addStudent(Student student) {
        if (students.size() >= MAX_STUDENTS) {
            return false;
        }
        students.add(student);
        return true;
    }

    @Override
    public boolean removeStudent(String studentNumber) {
        return students.removeIf(s -> s.getStudentNumber().equalsIgnoreCase(studentNumber));
    }

    @Override
    public void displayStudents(boolean sorted) {

    }

    @Override
    public void displayClassRecord() {

    }
}
