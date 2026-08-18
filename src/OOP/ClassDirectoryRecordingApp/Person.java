package OOP.ClassDirectoryRecordingApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

    /**
     * Calculates the person's current age based on their birthdate
     * and the current system date.
     */
    public int getComputedAge() {
        // Assuming the birthdate is in the format "YYYY-MM-DD"
        String birthDateRaw = birthdate.replace("-", "");
        int birthDate = Integer.parseInt(birthDateRaw);
        int currentDate = Integer.parseInt(LocalDate.now().toString().replace("-", ""));

        return (currentDate - birthDate) / 10000;
    }

    /**
     * Validates whether a birthdate is a real date
     * and follows the YYYY-MM-DD format.
     */
    static String validateBirthdate(String birthdate) {
        // Validate the birthdate format (YYYY-MM-DD)
        if (!birthdate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Invalid birthdate format. Please use YYYY-MM-DD.";
        }
        return null; // Valid
    }


}
