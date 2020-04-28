package app.modules.requesthandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import app.modules.button.Button;

public class RequestHandler implements IRequestHandler {

    private Queue<Integer> requestQueue = new LinkedList<>();
    private HashMap<Integer, Button> ButtonMap = new HashMap<Integer, Button>();

    public void enterRequest(int gotoFloor) {

    }

    public void processRequest() {

    }
}