package OOP.UniversityClassRecordManagementApp;

public class Student extends Person {
    private String studentNumber;
    private Course courseEnrolled;

    public Student(String studentId, String firstName) {
        super(firstName, firstName);
    }

    public Student(String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
    }

    @Override
    public String getCompleteName() {
        return lastName + ", " + firstName + middleName;
    }

    // ---- Getters ------
    public String getStudentNumber() {
        return studentNumber;
    }

    public Course getCourseEnrolled() {
        return courseEnrolled;
    }

    // ---- Setters ------
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setCourseEnrolled(Course courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }
}
