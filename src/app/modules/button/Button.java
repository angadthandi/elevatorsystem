package app.modules.button;

import java.util.HashMap;

public class Button implements IButton {

    private boolean isIlluminated = false;

    public static HashMap<Integer, Button> createButtons(int totalFloors) {
        HashMap<Integer, Button> ButtonMap = new HashMap<Integer, Button>();

        for (int i = 0; i <= totalFloors; i++) {
            Button b = new Button();

            ButtonMap.put(i, b);
        }

        return ButtonMap;
    }

    public void press(int gotoFloor) {

    }

    public void illuminate() {
        isIlluminated = true;
    }

    public void illuminateCancel() {
        isIlluminated = false;
    }
}