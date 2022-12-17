package DZ6;

public class VehicleDoor extends Door {

    private DoorType doorType;
    //создаем две двери авто, которые по умолчанию закрыты
    public VehicleDoor(String name) {
        this.doorType = DoorType.VEHICLE;
        setState(State.CLOSED);
        setName(name);
    }
}