package OOP.ClassDirectoryRecordingApp;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private String birthdate;
    private int contactNumber;

    // ================ GETTERS =================
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    // ================ SETTERS =================
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    // --- Additional Methods ---
    public int getComputedAge() {
        // Assuming the birthdate is in the format "YYYY-MM-DD"
        String[] parts = birthdate.split("-");
        int birthYear = Integer.parseInt(parts[0]);
        int currentYear = java.time.LocalDate.now().getYear();

        return currentYear - birthYear;
    }
}
