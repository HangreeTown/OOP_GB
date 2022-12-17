package DZ4;

public class Printer implements IPrinter {

    @Override
    public void outputData (String data) {
        System.out.println(data);
    }
}