package app.modules.button;

public interface IButton {
    void press(int gotoFloor);
    void illuminate();
    void illuminateCancel();
}