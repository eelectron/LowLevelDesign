package parking_lot;

public class ParkingAttendant extends Account{
    Payment paymentService;

    public boolean processVehicleEntry(Vehicle vehicle){
        return true;
    }

    public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType){
        return null;
    }
}
