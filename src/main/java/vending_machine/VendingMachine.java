package vending_machine;

public class VendingMachine {
    private Inventory inventory;
    private State state;
    private int amount;

    public VendingMachine() {
        inventory = new Inventory();
        state = new IdleState();
        amount = 0;
    }


    public void addAmount(int value) {
        amount += value;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Slot getSlot(String productCode) {
        Slot slot = inventory.getSlot(productCode);
        return slot;
    }

    public int getAmount() {
        return amount;
    }

    public void insertCoin(Coin coin) {
        state.insertCoin(this, coin);
    }

    public void selectProduct(String productCode) {
        state.selectProduct(this, productCode);
    }

    public void dispense(String productCode) {
        state.dispenseProduct(this, productCode);
    }

    public void resetAmount() {
        amount = 0;
    }

    public void deductAmount(int price) {
        amount -= price;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
