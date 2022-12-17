package HumanAndWardrobe;

public class WardrobeDoor {

    private  State state;
    private Integer doorIndex;

    public WardrobeDoor(Integer doorIndex, State state) {
        this.state = state;
        this.doorIndex = doorIndex;
    }

    enum State {
        OPENED, CLOSED
    }

    public State getState() {
        return this.state;
    }

    public void setState(State newState) {
        this.state = newState;
    }

    public int getDoorIndex() {
        return this.doorIndex;
    }
}