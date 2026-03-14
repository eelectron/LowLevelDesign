package vending_machine;

public class IdleState implements State {

    @Override
    public boolean insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addAmount(coin.getValue());
        System.out.println("Coin inserted " + coin.getValue());
        vendingMachine.setState(new HashMoneyState());
        return true;
    }

    @Override
    public boolean selectProduct(VendingMachine vendingMachine, String productCode) {
        System.out.println("First insert the coin");
        return false;
    }

    @Override
    public boolean dispenseProduct(VendingMachine vendingMachine, String productCode) {
        System.out.println("First select the product");
        return false;
    }

    @Override
    public int refund(VendingMachine vendingMachine) {
        System.out.println("No money is inserted");
        return 0;
    }
}
