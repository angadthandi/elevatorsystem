package app.modules.requesthandler;

public interface IRequestHandler {
    // constructor - RequestHandler(IElevator e, IDoor d)
    void enterRequest(int gotoFloor);
    void processRequest();
}