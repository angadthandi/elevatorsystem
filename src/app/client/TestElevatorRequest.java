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

        if (TestRequestAllFloors()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        if (Test_StartAtFloor5_AndRequestToFloor2()) {
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

    public static boolean TestRequestAllFloors() {
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
                "TestRequestAllFloors(): " +
                "gotoFloor: %d; currFloor: %d\n", gotoFloor, currFloor
            );

            if (gotoFloor != currFloor) {
                System.out.printf(
                    "TestRequestAllFloors(): " +
                    "FAIL: gotoFloor: %d; currFloor: %d\n", gotoFloor, currFloor
                );
                return pass;
            }
        }

        pass = true;

        return pass;
    }

    public static boolean Test_StartAtFloor5_AndRequestToFloor2() {
        boolean pass = false;

        // SETUP ------------------------------------
        int totalFloors = 10;

        Elevator elevator = Elevator.getInstance(totalFloors);
        Door door = Door.getInstance();
        RequestHandler requestHandler = new RequestHandler(elevator, door);
        ArrayList<Integer> floors = requestHandler.getElevatorFloors();
        // /SETUP ------------------------------------

        // 1. Go to Floor 5
        int gotoFloor5 = floors.get(4);

        Button button5 = new Button();
        button5.press(requestHandler, gotoFloor5);

        int currFloor5 = elevator.getCurrentFloor();
        System.out.printf(
            "Test_StartAtFloor5_AndRequestToFloor2(): " +
            "gotoFloor5: %d; currFloor5: %d\n", gotoFloor5, currFloor5
        );

        if (gotoFloor5 != currFloor5) {
            System.out.printf(
                "Test_StartAtFloor5_AndRequestToFloor2(): " +
                "FAIL: gotoFloor5: %d; currFloor5: %d\n", gotoFloor5, currFloor5
            );
            return pass;
        }

        // 1. Go to Floor 2 from Floor 5
        int gotoFloor2 = floors.get(1);

        Button button2 = new Button();
        button2.press(requestHandler, gotoFloor2);

        int currFloor2 = elevator.getCurrentFloor();
        System.out.printf(
            "Test_StartAtFloor5_AndRequestToFloor2(): " +
            "gotoFloor2: %d; currFloor2: %d\n", gotoFloor2, currFloor2
        );

        if (gotoFloor2 != currFloor2) {
            System.out.printf(
                "Test_StartAtFloor5_AndRequestToFloor2(): " +
                "FAIL: gotoFloor2: %d; currFloor2: %d\n", gotoFloor2, currFloor2
            );
            return pass;
        }

        pass = true;

        return pass;
    }

}