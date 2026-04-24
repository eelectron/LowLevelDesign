package bookmyshow;

public class CancelledState implements BookingState {
    @Override
    public void confirm(Booking booking) {
        throw new IllegalStateException("Booking already cancelled");
    }

    @Override
    public void cancel(Booking booking) {
        throw new IllegalStateException("Booking already cancelled");
    }

    @Override
    public String name() {
        return "CANCELLED";
    }
}
