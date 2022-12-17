package DZ5;

public abstract class Animal {

    private String animalName;

    abstract String listenHuman(String value);

    abstract String say();

    abstract String act1();

    abstract String act2();

    public String getName() {
        return animalName;
    }

    public void setName(String name) {
        animalName = name;
    }
}