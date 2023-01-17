import java.util.Scanner;

public class View {

    public static String getAritmetic(){
        System.out.println("Введите выражение ");
        return new Scanner(System.in).nextLine();
    }

    public static Integer getAritmeticComplexReal(){
        System.out.println("Введите действительную часть ");
        return new Scanner(System.in).nextInt();
    }

    public static Integer getAritmeticComplexImaginary(){
        System.out.println("Введите мнимую часть ");
        return new Scanner(System.in).nextInt();
    }

    public static String getAritmetic2(){
        System.out.println("Введите операцию ");
        return new Scanner(System.in).nextLine();
    }

    public static void printResult(double str){
        System.out.println(str);
    }
    public static void printResultComplex(Complex number){
        System.out.println(number);
    }
}