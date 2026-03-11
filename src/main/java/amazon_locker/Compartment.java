package amazon_locker;

public class Compartment {
    private int id;
    private Size size;
    private CompartmentStatus status;

    public boolean isAvailable() {
        return status == CompartmentStatus.AVAILABLE;
    }

    public void makeAvailable() {
        status = CompartmentStatus.AVAILABLE;
    }

    public void makeUnavailable() {
        status = CompartmentStatus.UNAVAILABLE;
    }

    public Size getSize() {
        return size;
    }

    public void open() {
    }

    public void markOutOfService() {
        this.status = CompartmentStatus.OUT_OF_SERVICE;
    }
}
