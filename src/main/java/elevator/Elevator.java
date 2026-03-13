package elevator;

import java.util.HashSet;
import java.util.Set;

public class Elevator {
    private int currentFloor;
    private Direction direction;
    private Set<Request> requests;

    public Elevator() {
        direction = Direction.IDLE;
        requests = new HashSet<>();
    }

    public boolean addRequest(int floor, RequestType requestType) {
        if (floor < 0 || floor > 9) {
            return false;
        }
        if (floor == currentFloor) {
            return false;
        }
        Request request = new Request(floor, requestType);
        if (requests.contains(request)) {
            return false;
        }
        return requests.add(request);
    }

    public void step() {
        // there is no request for this elevator
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        // decide the elevator direction based on nearest request
        // if the lift is idle
        if (direction == Direction.IDLE) {
            Request nearestRequest = getNearestRequest();
            if(currentFloor <= nearestRequest.getFloor()) {
                direction = Direction.UP;
            }
            else{
                direction = Direction.DOWN;
            }
        }

        // serve request at the current floor
        Request pickupUpRequest = new Request(currentFloor, RequestType.PICKUP_UP);
        Request pickupDownRequest = new Request(currentFloor, RequestType.PICKUP_DOWN);
        Request pickDestinationRequest = new Request(currentFloor, RequestType.DESTINATION);

        requests.remove(pickupUpRequest);
        requests.remove(pickupDownRequest);
        requests.remove(pickDestinationRequest);

        // become idle if no more request to serve
        if(requests.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        // reverse direction if there is no more request ahead
        if(!hasRequestAhead()){
            direction = (direction == Direction.UP) ? Direction.DOWN : Direction.UP;
        }

        // proceed to next floor
        if(direction == Direction.UP){
            currentFloor++;
        }
        else{
            currentFloor--;
        }
    }

    /**
     * Check if elevator has more request in same direction
     * @return
     */
    private boolean hasRequestAhead() {
        for (Request request : requests) {
            if(direction == Direction.UP && request.getFloor() > currentFloor){
                return true;
            }

            if (direction == Direction.DOWN && request.getFloor() < currentFloor) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get nearest request to for this elevator
     * @return
     */
    private Request getNearestRequest() {
        Request nearestRequest = null;
        int minDistance = Integer.MAX_VALUE;
        for (Request request : requests) {
            int distance = Math.abs(currentFloor - request.getFloor());
            if(distance < minDistance) {
                minDistance = distance;
                nearestRequest = request;
            }
        }
        return nearestRequest;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getFloor() {
        return currentFloor;
    }
}
