package app.modules.button;

import app.modules.requesthandler.IRequestHandler;

public interface IButton {
    void press(IRequestHandler r, int gotoFloor);
    void illuminate();
    void illuminateCancel();
}