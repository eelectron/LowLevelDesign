package parking_lot;

import java.util.List;

public class ParkingFloor {
    private int floorId;
    private String floorName;
    private List<ParkingSpace> parkingSpaces;
    private ParkingDisplayBoard parkingDisplayBoard;
    public ParkingFloor(int floorId, String floorName) {
        this.floorId = floorId;
        this.floorName = floorName;
    }


}
