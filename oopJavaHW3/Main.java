import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Person pa = new Person("Sergei", "Pavshin", LocalDate.of(1979, 7, 6), Gender.MALE);
        Person ma = new Person("Natalia", "Pavshina", LocalDate.of(1976, 11, 22), Gender.FEMALE);
        Person so = new Person("Egor", "Pavshin", LocalDate.of(2013, 2, 25), Gender.MALE);
        Person dot = new Person("Lada", "Pavshina", LocalDate.of(2019, 5, 14), Gender.FEMALE);
        Person vi = new Person("Viktoriya", "Danilova", LocalDate.of(2003, 12, 8), Gender.FEMALE);

        tree.addLink(pa, ma, Relations.HUSBAND, Relations.WIFE);
        tree.addLink(pa, so, Relations.FATHER, Relations.SON);
        tree.addLink(pa, dot, Relations.FATHER, Relations.DAUGHTER);
        tree.addLink(pa, vi, Relations.STEPFATHER, Relations.STEPDAUGHTER);

        tree.addLink(ma, so, Relations.MOTHER, Relations.SON);
        tree.addLink(ma, dot, Relations.MOTHER, Relations.DAUGHTER);
        tree.addLink(ma, vi, Relations.MOTHER, Relations.DAUGHTER);

        tree.addLink(so, dot, Relations.BROTHER, Relations.SISTER);
        tree.addLink(so, vi, Relations.BROTHER, Relations.SISTER);

        tree.addLink(dot, vi, Relations.SISTER, Relations.SISTER);

        System.out.println(tree);
        System.out.println("-------------------\n");
        Research.getRelation(pa, tree);

        System.out.println();
    }
}