package DZ6;

public class Program {

    public static void main(String[] args) {

        Human man1 = new Human("John");
        Human man2 = new Human("Kristina)");

        //создаем две двери шкафа
        WardrobeDoor wardDoor1 = new WardrobeDoor("WardrobeDoor1");
        WardrobeDoor wardDoor2 = new WardrobeDoor("WardrobeDoor2");

        //создаем две двери авто
        VehicleDoor vehDoor1 = new VehicleDoor("VehicleDoor1");
        VehicleDoor vehDoor2 = new VehicleDoor("VehicleDoor2");

        man1.openDoor(wardDoor1);
        man2.openDoor(wardDoor2);
        man1.closeDoor(wardDoor2);
        man2.closeDoor(wardDoor1);
        man1.closeDoor(wardDoor1);  // пытаемся закрыть уже ранее закрытую дверь шкафа - получаем сообщение, что дверь уже закрыта
        man1.openDoor(vehDoor1);
        man1.closeDoor(vehDoor1);
        man1.closeDoor(vehDoor1);   // повторно пытаемся закрыть уже закрытую дверь авто
        man2.openDoor(vehDoor2);
    }

}