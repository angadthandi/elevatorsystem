package app.modules.elevator;

public interface IElevator {
    void moveUp(int gotoFloor);
    void moveDown(int gotoFloor);
    void stop();
}