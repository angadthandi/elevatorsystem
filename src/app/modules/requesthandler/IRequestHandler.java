package app.modules.requesthandler;

import java.util.ArrayList;

public interface IRequestHandler {
    // constructor - RequestHandler(IElevator e, IDoor d)
    ArrayList<Integer> getElevatorFloors();
    void enterRequest(int gotoFloor);
}