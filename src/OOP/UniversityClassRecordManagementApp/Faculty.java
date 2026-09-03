package OOP.UniversityClassRecordManagementApp;

public class Faculty extends Person {
    private String facultyId;
    private String highestDegree;

    public Faculty(String firstName, String lastName) {
        super(lastName, firstName);
    }

    public Faculty(String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
    }

    @Override
    public String getCompleteName() {
        return lastName + ", " + firstName + middleName + ", " + highestDegree;
    }

    // ----- Getters ------
    public String getHighestDegree() {
        return highestDegree;
    }

    public String getFacultyId() {
        return facultyId;
    }

    // ----- Setters ------
    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
}
