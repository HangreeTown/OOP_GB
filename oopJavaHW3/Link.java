public class Link {
    private Person people1;
    private Person people2;
    private Relations relationType;

    public Link(Person person1, Person person2, Relations relation) {
        this.people1 = person1;
        this.people2 = person2;
        this.relationType = relation;
    }

    public Person getPeople() {
        return this.people1;
    }

    public Person getRelationPeople() {
        return this.people2;
    }

    public Relations getRelationType() {
        return relationType;
    }

    @Override
    public String toString() {
        return String.format("%s is %s for %s", this.people1.getFirstName() + " " + this.people1.getSurName(),
                this.relationType, this.people2.getFirstName() + " " + this.people2.getSurName());
    }
}