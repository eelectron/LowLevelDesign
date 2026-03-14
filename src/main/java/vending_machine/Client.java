package vending_machine;

public class Client {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Inventory inventory = vendingMachine.getInventory();

        inventory.addSlot("A1", new Slot(new Product("Coke", 10), 5));
        inventory.addSlot("A2", new Slot(new Product("Chips", 15), 5));
        inventory.addSlot("A3", new Slot(new Product("Water", 5), 5));

        inventory.displayProducts();

        // get Chips
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.FIVE);

        vendingMachine.selectProduct("A2");

    }
}
