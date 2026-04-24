package bookmyshow;

public class ConfirmState implements BookingState {
    @Override
    public void confirm(Booking booking) {
        new IllegalStateException("Booking already confirmed");
    }

    @Override
    public void cancel(Booking booking) {
        booking.setState(new CancelledState());
        System.out.println("Booking has been cancelled after confirmation");
    }

    @Override
    public String name() {
        return "CONFIRMED";
    }
}
