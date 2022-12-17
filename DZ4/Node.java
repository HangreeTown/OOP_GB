package DZ4;

public class Node {

    private Person person1;
    private Relationship relation;
    private Person person2;

    enum Relationship {
        PARENT,
        CHILDREN
    }

    public Node(Person person1, Relationship relation, Person person2) {
        this.person1 = person1;
        this.relation = relation;
        this.person2 = person2;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public Relationship getRelation() {
        return relation;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", person1, relation, person2);
    }
}