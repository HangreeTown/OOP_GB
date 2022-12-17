package DZ5;

public class Cat extends Animal {

    public Cat(String catName) {
        super.setName(catName);
    }

    @Override
    public String listenHuman(String value) {
        StringBuilder res = new StringBuilder();
        res.append(super.getName() + ": ");
        if (value.contains("kis-kis")) {
            res.append(say());
            res.append(act1());
            return res.toString();
        } else if (value.contains(super.getName())) {
            res.append(sayMur());
            res.append(act1());
            res.append(act2());
            return res.toString();
        } else {
            res.append(say());
            return res.toString();
        }
    }

    @Override
    public String say() {
        return "Meow!";
    }

    public String sayMur() {
        return "Mur-Mur-Mur!";
    }

    @Override
    public String act1() {
        return "\nlooks at human one time and do nothing...";
    }

    @Override
    public String act2() {
        return "\nruns to human and starts to wait something...";
    }

}