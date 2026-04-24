package bookmyshow;

import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private BookingState state;
    private double price;

    public void confirm() {
        state.confirm(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void setState(BookingState state) {
        this.state = state;
    }
}
