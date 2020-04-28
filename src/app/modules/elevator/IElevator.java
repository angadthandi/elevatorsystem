package app.modules.elevator;

public interface IElevator {
    // constructor - SINGLETON
    int getTotalFloors();
    int getCurrentFloor();
    void moveUp(int gotoFloor);
    void moveDown(int gotoFloor);
    void stop();
}