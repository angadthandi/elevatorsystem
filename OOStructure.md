# OO Design Structure

##### Reference
http://www.web-feats.com/classes/dj/lessons/uml/elevator.htm

---

## IDoor Interface
 #### Methods:
 - open()
 - close()

## Door Class (SINGLETON)
 #### Attributes:
 - isOpen bool
 #### Methods:
 - open()
 - close()

---

## IElevator Interface
 #### Methods:
 - int getTotalFloors()
 - int getCurrentFloor()
 - moveUp(gotoFloor int)
 - moveDown(gotoFloor int)
 - stop()

## Elevator Class implements IElevator (SINGLETON)
 #### Attributes:
 - currentFloor int
 #### Methods:
 - int getTotalFloors()
 - int getCurrentFloor()
 - moveUp(gotoFloor int)
 - moveDown(gotoFloor int)
 - stop()
 - Elevator(totalFloors int) // contructor - takes in total number of floors

---

## IRequestHandler Interface
 #### Methods:
 - enterRequest(gotoFloor int)
 - processRequest()

## RequestHandler Class implements IRequestHandler
 #### Attributes:
 - requestQueue []int
 - ButtonMap HashMap<Integer, Button>
 #### Methods:
 - enterRequest(gotoFloor int)
 - processRequest()
 - RequestHandler(e IElevator, d IDoor) // contructor - takes in IElevator, IDoor interface
                            //                  instance and initializes ButtonMap equal to
                            //                  number of floors passed to IElevator

---

## IButton Interface
 #### Methods:
 - press(gotoFloor int)
 - illuminate()
 - illuminateCancel()

## Button Class implements IButton
 #### Methods:
 - press(gotoFloor int)
 - illuminate()
 - illuminateCancel()

---