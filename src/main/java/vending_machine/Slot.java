package vending_machine;

public class Slot {
    private Product product;
    private int quantity;
    public Slot(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public synchronized boolean dispense() {
        if(quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }
}
