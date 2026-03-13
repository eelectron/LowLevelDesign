package elevator;

import java.util.List;

/**
 * Referenced : 
 * https://www.hellointerview.com/learn/low-level-design/problem-breakdowns/elevator
 */
public class ElevatorController {
    private List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public ElevatorController(int numberOfElevators) {
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator());
        }
    }

    public boolean requestElevator(int floor, Direction direction) {
        if(floor < 0 || floor > elevators.size()) {
            return false;
        }

        if(direction == Direction.IDLE){
            return false;
        }

        Elevator elevator = selectBestElevator(floor, direction);
        if(elevator == null) {
            return false;
        }

        RequestType requestType = (direction == Direction.UP) ? RequestType.PICKUP_UP : RequestType.PICKUP_DOWN;
        elevator.addRequest(floor, requestType);
        return true;
    }

    private Elevator selectBestElevator(int floor, Direction direction) {
        // get the elevator coming towards your floor
        Elevator selectedElevator = elevatorComingTowardsYourFloor(floor, direction);
        if(selectedElevator != null) {
            return selectedElevator;
        }

        // get nearest idle elevator
        selectedElevator = getNearestIdleElevator(floor);
        if(selectedElevator != null) {
            return selectedElevator;
        }

        // get nearest elevator
        selectedElevator = getNearestElevator(floor);
        return selectedElevator;
    }

    private Elevator getNearestElevator(int floor) {
        int minDistance  = Integer.MAX_VALUE;
        Elevator nearestElevator = null;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getFloor() - floor);
            if(distance < minDistance) {
                minDistance = distance;
                nearestElevator = elevator;
            }
        }
        return nearestElevator;
    }

    private Elevator getNearestIdleElevator(int floor) {
        int minDistance  = Integer.MAX_VALUE;
        Elevator nearestElevator = null;
        for (Elevator elevator : elevators) {
            if(elevator.getDirection() != Direction.IDLE) {
                continue;
            }

            int distance = Math.abs(elevator.getFloor() - floor);
            if(distance < minDistance) {
                minDistance = distance;
                nearestElevator = elevator;
            }
        }
        return nearestElevator;
    }

    private Elevator elevatorComingTowardsYourFloor(int floor, Direction direction) {
        for (Elevator elevator : elevators) {
            if(floor < elevator.getFloor() && elevator.getDirection() == direction) {
                return elevator;
            }

            if(floor > elevator.getFloor() && elevator.getDirection() == direction) {
                return elevator;
            }
        }
        return null;
    }

    public void step(){
        for (Elevator elevator : elevators) {
            elevator.step();
        }
    }
}
