package vending_machine;

public class CoinPayment implements PaymentStrategy {

    @Override
    public boolean pay(int amount) {
        System.out.println("Pay using coins : " + amount);
        return true;
    }
}
