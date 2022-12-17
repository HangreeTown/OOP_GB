package HumanAndCat;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private List<Animal> myPets;

    public Human() {
        myPets = new ArrayList<>();
    }

    public void addPet(Animal... args) {
        for (Animal pet : args) {
            myPets.add(pet);
        }
    }

    public void delPet(Animal pet) {
        myPets.remove(pet);
    }

    public String callPet(Animal animal, String value) {
        return String.format("human: calls %s: %s", animal.getName(), value);
    }

    public String callAllPets(String value) {
        StringBuilder res = new StringBuilder();
        res.append("human: " + value + "\n");
        for (Animal pet : myPets) {
            res.append(pet.listenHuman(value) + "\n");
        }
        return res.toString();
    }

    public String touchAnimal(Animal animal) {
        return "human: touch " + animal.getName();
    }

    public List<Animal> getMyPets() {
        return myPets;
    }

}