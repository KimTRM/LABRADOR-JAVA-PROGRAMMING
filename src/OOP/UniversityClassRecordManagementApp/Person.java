package OOP.UniversityClassRecordManagementApp;

public abstract class Person {
    protected String lastName;
    protected String firstName;
    protected String middleName;
    protected String gender;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public abstract String getCompleteName();
}
