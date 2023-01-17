import javax.imageio.IIOException;

public class Retional implements MathArithmetcs {
    private double a;
    private double b;
    private String mathOperation;

    public Retional(Parsen parsen){
        this.a = parsen.getFirst();
        this.b = parsen.getSecond();
        this.mathOperation = parsen.getOperation();
    }


    public double solve(){
        switch (mathOperation) {
            case "+":
                return sum();
            case "-":
                return sub();
            case "*":
                return div();
            case "/":
                return nul();
            default:
                throw new IllegalArgumentException("ошибка");
        }
    }


    @Override
    public double sum(){
        return a + b;
    }
    @Override
    public double sub(){
        return a - b;
    }
    @Override
    public double div(){
        return a / b;
    }
    @Override
    public double nul(){
        return a * b;
    }
}