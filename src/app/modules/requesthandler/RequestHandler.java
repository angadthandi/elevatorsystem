package app.modules.requesthandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import app.modules.button.Button;
import app.modules.door.IDoor;
import app.modules.elevator.IElevator;

public class RequestHandler implements IRequestHandler {

    private Queue<Integer> requestQueue = new LinkedList<>();
    private HashMap<Integer, Button> ButtonMap = new HashMap<Integer, Button>();
    private IElevator elevator;
    private IDoor door;

    public RequestHandler(IElevator e, IDoor d) {
        elevator = e;
        door = d;

        ButtonMap = Button.createButtons(e.getTotalFloors());
    }

    public void enterRequest(int gotoFloor) {
        Button b = ButtonMap.get(gotoFloor);
        b.press(gotoFloor);
        b.illuminate();

        requestQueue.offer(gotoFloor);

        processRequest();
    }

    public void processRequest() {
        while (!requestQueue.isEmpty()) {
            int floor = requestQueue.poll();

            if (floor < elevator.getCurrentFloor()) {
                elevator.moveDown(floor);
            }
            else if (floor > elevator.getCurrentFloor()) {
                elevator.moveUp(floor);
            }

            elevator.stop();

            Button b = ButtonMap.get(floor);
            b.illuminateCancel();

            door.open();
            door.close();
        }
    }
}