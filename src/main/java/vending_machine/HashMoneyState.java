package vending_machine;

public class HashMoneyState implements State {

    @Override
    public boolean insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addAmount(coin.getValue());
        System.out.println("Coin added :" + coin.getValue());
        return true;
    }

    @Override
    public boolean selectProduct(VendingMachine vendingMachine, String productCode) {
        Slot slot = vendingMachine.getSlot(productCode);

        if (slot == null) {
            System.out.println("Invalid product code :" + productCode);
            return false;
        }

        if (slot.isAvailable() == false) {
            System.out.println("Product not available");
            return false;
        }

        int price = slot.getProduct().getPrice();
        if(vendingMachine.getAmount() < price){
            System.out.println("Insufficient amount for product :" + productCode);
            return false;
        }

        vendingMachine.setState(new DispenseState());
        vendingMachine.dispense(productCode);
        return false;
    }

    @Override
    public boolean dispenseProduct(VendingMachine vendingMachine, String productCode) {
        System.out.println("Select product first");
        return false;
    }

    @Override
    public int refund(VendingMachine vendingMachine) {
        System.out.println("Return refund :" + vendingMachine.getAmount());
        vendingMachine.resetAmount();
        vendingMachine.setState(new IdleState());
        return 0;
    }
}
