package OOP.Activity2;

public class Student {
    private String name;
    private int birthYear;

    public Student(String nMame, int mBirthYear) {
        name = nMame;
        birthYear = mBirthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }


    public int calculateAge() {
        return 2026 - birthYear;
    }

    public void greetings() {
        int age = calculateAge();

        System.out.println("\n--------------------------------");
        System.out.println("Hello, " + this.name + "!");
        System.out.println("Welcome to OOP Java Class!");
        System.out.println("You are " + age + " years old.");
        System.out.println("----------------------------------");
    }

}
