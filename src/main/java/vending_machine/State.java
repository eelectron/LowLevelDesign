package vending_machine;

public interface State {
    boolean insertCoin(VendingMachine vendingMachine, Coin coin);
    boolean selectProduct(VendingMachine vendingMachine, String productCode);
    boolean dispenseProduct(VendingMachine vendingMachine, String productCode);
    int refund(VendingMachine vendingMachine);
}
