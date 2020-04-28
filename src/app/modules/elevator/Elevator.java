package app.modules.elevator;

public class Elevator implements IElevator {

    private static Elevator instance = null;
    private int currentFloor = 0;

    private Elevator() {

    }

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }

        return instance;
    }

    public void moveUp(int gotoFloor) {

    }

    public void moveDown(int gotoFloor) {

    }

    public void stop() {

    }
}