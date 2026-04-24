package bookmyshow;

public class PendingState implements BookingState{
    @Override
    public void confirm(Booking booking) {
        booking.setState(new ConfirmState());
        System.out.println("Booking confirmed");
    }

    @Override
    public void cancel(Booking booking) {
        booking.setState(new CancelledState());
        System.out.println("Booking cancelled");
    }

    @Override
    public String name() {
        return "Pending";
    }
}
