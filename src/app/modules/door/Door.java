package app.modules.door;

public class Door implements IDoor {

    private static Door instance = null;
    private boolean isOpen = false;

    private Door() {

    }

    public static Door getInstance() {
        if (instance == null) {
            instance = new Door();
        }

        return instance;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}