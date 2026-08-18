package OOP.ClassDirectoryRecordingApp;

public class Student extends Person {
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
}
