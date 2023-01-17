public class Parsen {
    private double first;
    private double second;

    private String operation;

    public Parsen(String str){
        java.lang.String[] s = str.split(" ");

        first = Double.parseDouble(s[0]);
        operation = s[1];
        second = Double.parseDouble(s[2]);
    }

    public double getFirst(){
        return first;
    }

    public double getSecond(){
        return second;
    }

    public String getOperation(){
        return operation;
    }
}