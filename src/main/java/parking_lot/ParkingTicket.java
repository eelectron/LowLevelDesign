package parking_lot;

import java.util.Date;

public class ParkingTicket {
    private int id;
    private int levelId;
    private Date vehicleEnntryDate;
    private Date vehicleExitDate;
    private ParkingSpace parkingSpace;
    private double totalCost;

    public double updateTotalCost(){
        return 0;
    }

    public Date updateVehicleExitTime(Date date){
        return null;
    }
}
