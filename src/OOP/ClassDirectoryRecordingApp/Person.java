package OOP.ClassDirectoryRecordingApp;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    // ================ ATTRIBUTES =================

    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private String birthdate;
    private long contactNumber;


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

    public long getContactNumber() {
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

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }


    // ================ ADDITIONAL METHODS =================

    // Calculates the current age based on the birthdate
    public int getComputedAge() {
        LocalDate birthDate = LocalDate.parse(birthdate);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Checks if the birthdate is valid
    public static String validateBirthdate(String birthdate) {
        try {
            LocalDate.parse(birthdate);
            return null;
        } catch (Exception e) {
            return ">> Invalid birthdate. Please use YYYY-MM-DD.";
        }
    }
}
