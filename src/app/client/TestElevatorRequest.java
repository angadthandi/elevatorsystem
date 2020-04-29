package app.client;

import java.util.ArrayList;

import app.modules.button.Button;
import app.modules.door.Door;
import app.modules.elevator.Elevator;
import app.modules.requesthandler.RequestHandler;

public class TestElevatorRequest {

    public static TestMetric Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        if (TestRequest()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        TestMetric t = new TestMetric();
        t.Total = totalTests;
        t.Pass = totalPassed;
        t.Fail = totalFailed;

        return t;
    }

    public static boolean TestRequest() {
        boolean pass = false;

        // SETUP ------------------------------------
        int totalFloors = 10;

        Elevator elevator = Elevator.getInstance(totalFloors);
        Door door = Door.getInstance();
        RequestHandler requestHandler = new RequestHandler(elevator, door);
        ArrayList<Integer> floors = requestHandler.getElevatorFloors();
        // /SETUP ------------------------------------

        for (int i=0; i<floors.size(); i++) {
            int gotoFloor = floors.get(i);

            Button button = new Button();
            button.press(requestHandler, gotoFloor);

            int currFloor = elevator.getCurrentFloor();
            System.out.printf(
                "gotoFloor: %d; currFloor: %d\n", gotoFloor, currFloor
            );

            if (gotoFloor != currFloor) {
                System.out.printf(
                    "FAIL: gotoFloor: %d; currFloor: %d\n", gotoFloor, currFloor
                );
                return pass;
            }
        }

        pass = true;

        return pass;
    }

}