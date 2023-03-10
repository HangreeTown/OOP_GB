public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Василий", "Иванов", 125845, "12.05.2001", true);
        Person p2 = new Person("Мария", "Иванова", 125854, "01.07.1957", false);
        Person p3 = new Person("Иван", "Иванов", 122554, "15.03.1989", true);
        Person p4 = new Person("Татьяна", "Сидорова", 122574, "11.04.1944", false);
        Person p5 = new Person("Анна", "Смирнова", 123845, "12.06.1999", false);
        Person p6 = new Person ("Петр", "Петров", 112554, "10.02.1946", true);
        Person p7 = new Person ("Алексей", "Смирнов", 158554, "05.01.1991", true);
        Person p8 = new Person ("Елена", "Смирнова", 158984, "25.11.2015", false);
        p2.setChildren(p1, p3);
        p2.setChildren(p5, p6);
        p4.setChildren(p2, null);
        p2.setIsMarried(p3);
        p5.setIsMarried(p7);
        p5.setChildren(p8, p7);
        GenTree gt1 = new GenTree(p2);
        GenTree gt2 = new GenTree(p5);
        gt1.printFamily();
        gt2.writeToFile();;
    }
}