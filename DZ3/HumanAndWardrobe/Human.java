package HumanAndWardrobe;

public class Human {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void closeDoor(WardrobeDoor door) {

        if (door.getState().equals(WardrobeDoor.State.OPENED)) {
            door.setState(WardrobeDoor.State.CLOSED);
            System.out.printf("%s closed door #%d\n", name, door.getDoorIndex());
        } else {
            System.out.printf("%s tryed to close door #%d, but it was closed\n", name, door.getDoorIndex());
        }
    }

    public void openDoor(WardrobeDoor door) {
        if (door.getState().equals(WardrobeDoor.State.CLOSED)) {
            door.setState(WardrobeDoor.State.OPENED);
            System.out.printf("%s opened door #%d\n", name, door.getDoorIndex());
        } else {
            System.out.printf("%s tryed to open door #%d, but it was closed\n", name, door.getDoorIndex());
        }
    }

}