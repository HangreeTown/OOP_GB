package HW1;

public class EnergyDrink extends Product {
    private Integer caffeine;

    public EnergyDrink(String name) {
        super(name);
        
    }
    public EnergyDrink(String name, Double price) {
        super(name, price);
        
    }
    public EnergyDrink(String name, Double price, Integer caffeine) {
        super(name, price);
        this.caffeine = caffeine;
    }
    public Integer getCaffeine(){
        return this.caffeine;
    }

    @Override
    public String toString() {
        return String.format("%s  %d", super.toString(), getCaffeine());
    }

}
