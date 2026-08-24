package OOP.ClassDirectoryRecordingApp;

public class Student extends Person {

    // ================ ATTRIBUTES =================

    private long LRN;
    private String homeAddress;


    // ================ GETTERS =================

    public long getLRN() {
        return LRN;
    }

    public String getHomeAddress() {
        return homeAddress;
    }


    // ================ SETTERS =================

    public void setLRN(long LRN) {
        this.LRN = LRN;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }


    // ================ ADDITIONAL METHODS =================

    // Checks if the LRN contains exactly 12 digits
    public static String validateLRN(long LRN) {
        if (String.valueOf(LRN).length() != 12) {
            return ">> LRN must be 12 digits long!";
        }

        return null;
    }
}
