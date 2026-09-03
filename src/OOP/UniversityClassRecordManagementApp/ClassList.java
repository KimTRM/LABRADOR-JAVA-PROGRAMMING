package OOP.UniversityClassRecordManagementApp;

public interface ClassList {
    int MAX_STUDENTS = 40;

    default String getInstitutionName() {
        return "University of Nueva Caceres";
    }

    void assignCollege(Collage college);

    void assignProgram(Program program);

    void assignInstructor(Faculty faculty);

    boolean addStudent(Student student);

    boolean removeStudent(String studentNumber);

    void displayStudents(boolean sorted);

    void displayClassRecord();
}
