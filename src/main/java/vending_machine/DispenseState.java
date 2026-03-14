package vending_machine;

public class DispenseState implements State {
    @Override
    public boolean insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Can not insert coin");
        return false;
    }

    @Override
    public boolean selectProduct(VendingMachine vendingMachine, String productCode) {
        System.out.println("Can not select product");
        return false;
    }

    @Override
    public boolean dispenseProduct(VendingMachine vendingMachine, String productCode) {
        Slot slot = vendingMachine.getSlot(productCode);
        Product product = slot.getProduct();
        vendingMachine.deductAmount(product.getPrice());

        System.out.println("Dispense product " + product.getProductName());
        int change = vendingMachine.getAmount();
        if(change > 0) {
            System.out.println("Return change " + change);
        }

        vendingMachine.resetAmount();
        vendingMachine.setState(new IdleState());
        return true;
    }

    @Override
    public int refund(VendingMachine vendingMachine) {
        System.out.println("Can not refund during dispense state");
        return 0;
    }
}
