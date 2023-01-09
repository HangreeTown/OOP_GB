import java.util.Iterator;
import java.util.List;

public class Research {
    public static void getRelation(Person person, Relations relation, Tree tree) {
        List<Link> elements = tree.getLinks();
        Iterator<Link> iterator = elements.iterator();
        while (iterator.hasNext()) {
            Link comparable = iterator.next();
            if (comparable.getPeople().getFirstName().equals(person.getFirstName()) && comparable.getPeople().getSurName().equals(person.getSurName())
                    && comparable.getRelationType() == relation) {
                System.out.println(comparable);
            }
        }
    }

    public static void getRelation(Relations relation, Tree tree) {
        List<Link> elements = tree.getLinks();
        Iterator<Link> iterator = elements.iterator();
        while (iterator.hasNext()) {
            Link comparable = iterator.next();
            if (comparable.getRelationType() == relation) {
                System.out.println(comparable);
            }
        }
    }

    public static void getRelation(Person person, Tree tree) {
        List<Link> elements = tree.getLinks();
        Iterator<Link> iterator = elements.iterator();
        while (iterator.hasNext()) {
            Link comparable = iterator.next();
            if (comparable.getPeople().getFirstName().equals(person.getFirstName()) && comparable.getPeople().getSurName().equals(person.getSurName())) {
                System.out.println(comparable);
            }
        }
    }
}