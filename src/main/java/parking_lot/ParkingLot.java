package parking_lot;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private List<Entrance> entrances;
    private List<Exit> exits;

    private Address address;
    private String parkingLotName;

    public ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isParkingSpaceAvailable(Vehicle vehicle) {
        return true;
    }

    public boolean updateParkingAttendant(ParkingAttendant attendant, int gateId) {
        return true;
    }
}
