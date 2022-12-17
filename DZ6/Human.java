package DZ6;

public class Human implements IDoor {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void closeDoor(Door door) {

        if (door.isOpened()) {
            door.setState(Door.State.CLOSED);
            System.out.printf("%s closed %s\n", name, door.getName());
        } else {
            System.out.printf("%s tryed to close %s, but it was closed\n", name, door.getName());
        }
    }

    @Override
    public void openDoor(Door door) {
        if (!door.isOpened()) {
            door.setState(Door.State.OPENED);
            System.out.printf("%s opened %s\n", name, door.getName());

        } else {
            System.out.printf("%s tryed to open %s, but it was closed\n", name, door.getName());
        }
    }

}