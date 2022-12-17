package DZ4;

public class Program {
    public static void main(String[] args) {

        Person irina = new Person("Ирина");
        Person vasya = new Person("Вася");
        Person masha = new Person("Маша");
        Person jane = new Person("Женя");
        Person ivan = new Person("Ваня");

        // класс GeoTree  построен на ArrayList, класс NewGeoTree построен на LinkedList
        // если заменить тип, то ничего не должно сломаться

        //GeoTree gt = new GeoTree();
        NewGeoTree gt = new NewGeoTree();
        gt.append(irina, vasya);
        gt.append(irina, masha);
        gt.append(vasya, jane);
        gt.append(vasya, ivan);
        System.out.println("Дети Васи");
        System.out.println(gt.search(vasya, Node.Relationship.PARENT));
        System.out.println("Родители Васи");
        System.out.println(gt.search(vasya, Node.Relationship.CHILDREN));
    }

}