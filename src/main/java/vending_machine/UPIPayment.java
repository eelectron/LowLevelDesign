package vending_machine;

public class UPIPayment implements  PaymentStrategy {

    @Override
    public boolean pay(int amount) {
        System.out.println("Pay using UPI : " + amount);
        return true;
    }
}
