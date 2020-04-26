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
 - status bool
 #### Methods:
 - open()
 - close()

---

## IElevator Interface
 #### Methods:
 - moveUp(gotoFloor int)
 - moveDown(gotoFloor int)
 - stop()

## Elevator Class implements IElevator (SINGLETON)
 #### Attributes:
 - currentFloor int
 #### Methods:
 - moveUp(gotoFloor int)
 - moveDown(gotoFloor int)
 - stop()

---

## IRequestHandler Interface
 #### Methods:
 - enterRequest(gotoFloor int)
 - processRequest()

## RequestHandler Class implements IRequestHandler
 #### Attributes:
 - requestQueue []int
 #### Methods:
 - enterRequest(gotoFloor int)
 - processRequest()

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