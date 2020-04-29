package app.modules.elevator;

public class Elevator implements IElevator {

    private static Elevator instance = null;
    private int totalFloors = 0;
    private int currentFloor = 0;

    private Elevator(int totalElevatorFloors) {
        totalFloors = totalElevatorFloors;
    }

    public static Elevator getInstance(int totalFloors) {
        if (instance == null) {
            instance = new Elevator(totalFloors);
        }

        return instance;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveUp(int gotoFloor) {
        while (gotoFloor > currentFloor) {
            currentFloor++;
        }
    }

    public void moveDown(int gotoFloor) {
        while (gotoFloor < currentFloor) {
            currentFloor--;
        }
    }

    public void stop() {

    }

}