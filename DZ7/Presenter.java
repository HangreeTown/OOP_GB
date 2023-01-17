import java.util.Scanner;

public class Presenter {
    public static void start() {

        System.out.println("рациональные или комплексные числа? (1 - рациональные ; 2 - комплексные числа )");

        if(new Scanner(System.in).nextInt() == 1){
            String readText = View.getAritmetic();
            Parsen parsen = new Parsen(readText);
            Retional rational = new Retional(parsen);
            double res = rational.solve();
            View.printResult(res);
        }
        else{
            View.getAritmetic();
            System.out.println("gberbtre");
            Integer RealNumber = View.getAritmeticComplexReal();
            System.out.println("куку");
            Integer ImaginaryNumber = View.getAritmeticComplexImaginary();
            Complex z1 = new Complex(RealNumber,ImaginaryNumber);
            Integer RealNumber2 = View.getAritmeticComplexReal();
            Integer ImaginaryNumber2 = View.getAritmeticComplexImaginary();
            Complex z2 = new Complex(RealNumber2,ImaginaryNumber2);
            String operation = View.getAritmetic2();

            if(operation == "+" ){
                z1.plus(z2);
                z1.print();
            }
            else if(operation == "-"){
                z1.minus(z2);
                z1.print();
            }
            else if(operation == "-"){
                z1.mult(z2);
                z1.print();
            }
            else{
                throw new IllegalArgumentException("ошибка");
            }

        }

    }
}