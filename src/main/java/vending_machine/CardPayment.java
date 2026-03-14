package vending_machine;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(int amount) {
        System.out.println("Pay using Card : " + amount);
        return true;
    }
}
