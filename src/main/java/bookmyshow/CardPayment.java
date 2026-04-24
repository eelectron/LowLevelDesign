package bookmyshow;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return true;
    }
}
