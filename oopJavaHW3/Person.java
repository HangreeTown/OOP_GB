import java.time.LocalDate;

public class Person {
    private final String fName;
    private final String sName;
    private final LocalDate bDate;
    private final Gender gender;

    public Person(String firstName, String surName, LocalDate birthDate, Gender gender) {
        this.fName = firstName;
        this.sName = surName;
        this.bDate = birthDate;
        this.gender = gender;
    }

    public String getFirstName() {
        return this.fName;
    }

    public String getSurName() {
        return this.sName;
    }

    public LocalDate getBirthDate() {
        return this.bDate;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", fName, sName, bDate, gender);
    }
}