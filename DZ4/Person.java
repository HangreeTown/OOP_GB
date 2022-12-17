package DZ4;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String fullName;

    private List<Person> family = new ArrayList<>();

    public List<Person> getFamily() {
        return family;
    }

    public void appendToFamily(Person p) {
        family.add(p);
    }

    public Person(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}