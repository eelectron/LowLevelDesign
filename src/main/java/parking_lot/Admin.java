package parking_lot;

public class Admin extends Account{
    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor){
        return false;
    }

    public boolean addParkingSpace(ParkingFloor parkingFloor, ParkingSpace parkingSpace){
        return false;
    }

    public boolean addParkingDisplayBoard(ParkingFloor parkingFloor, ParkingDisplayBoard parkingDisplayBoards){
        return false;
    }
}
