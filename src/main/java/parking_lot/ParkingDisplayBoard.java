package parking_lot;

import scaler.design.parkingLot.ParkingSpaceType;

import java.util.Map;

public class ParkingDisplayBoard {
    // for each type of vehicle , it tells how many spots are available
    private Map<String, Integer> spaceAvailableMap;

    public ParkingDisplayBoard(Map<String, Integer> spaceAvailableMap) {
        this.spaceAvailableMap = spaceAvailableMap;
    }

    public boolean updateFreeSpace(ParkingSpaceType parkingSpaceType, int freeSpace) {
        return true;
    }
}
