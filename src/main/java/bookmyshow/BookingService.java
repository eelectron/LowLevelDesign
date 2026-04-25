package bookmyshow;

import java.util.List;

public class BookingService {
    private BookingRepository bookingRepository;

    public Booking createBooing(User user, Show show, List<ShowSeat> showSeatList) {
        return null;
    }

    public void confirmBooking(String  bookingId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        booking .confirm();

        // mark seat as booked

        // payment success is assumed

        bookingRepository.save(booking);
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        booking.cancel();

        // release all seats

        bookingRepository.save(booking);
    }
}
