package DZ6;

public class WardrobeDoor extends Door {

    private DoorType doorType;
    //создаем две двери шкафа, которые по умолчанию закрыты
    public WardrobeDoor(String name) {
        this.doorType = DoorType.VEHICLE;
        setState(State.CLOSED);
        setName(name);
    }
}