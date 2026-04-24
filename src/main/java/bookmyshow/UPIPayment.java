package bookmyshow;

public class UPIPayment implements PaymentStrategy{

    @Override
    public boolean pay(double amount) {
        return true;
    }
}
