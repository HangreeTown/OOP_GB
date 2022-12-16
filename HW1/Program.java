package HW1;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Product> prods = new ArrayList<>();
        prods.add(new Milk("Packege milk", 60.0, 5));
        prods.add(new EnergyDrink("Monster", 88.0, 120 ));
        prods.add(new EnergyDrink("Burn", 90.0, 88 ));
        prods.add(new Product("Lays", 60.0));
        prods.add(new Product("Butter", 50.0));
        prods.add(new Product("Bread", 40.0));
        prods.add(new Product("Sneck", 20.0));
        VendingMachine v1 = new VendingMachine(prods);
        System.out.println(v1);
        System.out.println(v1.getProductBy("Lays"));
        System.out.println(v1.getProductBy("Packege milk"));
        System.out.println(v1.getProductBy("Burn"));
    }
}
