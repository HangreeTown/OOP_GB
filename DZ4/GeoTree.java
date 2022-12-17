package DZ4;

import java.util.ArrayList;
import java.util.List;

public class GeoTree implements ITree {

    private List<Node> tree = new ArrayList<>();

    public List<Node> getTree() {
        return tree;
    }

    @Override
    public void append(Person parent, Person children) {
        tree.add(new Node(parent, Node.Relationship.PARENT, children));
        tree.add(new Node(children, Node.Relationship.CHILDREN, parent));
    }

    public List<Person> search(Person pers, Node.Relationship relation) {

        List<Person> result = new ArrayList<>();

        for (Node item : tree) {
            if (item.getPerson1() == pers
                    && item.getRelation() == relation) {
                result.add(item.getPerson2());
            }
        }
        return result;
    }
}