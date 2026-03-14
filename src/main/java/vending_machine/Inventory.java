package vending_machine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Slot> slots;
    public Inventory() {
        slots = new HashMap<>();
    }

    public void addSlot(String slotName, Slot slot) {
        slots.put(slotName, slot);
    }

    public Slot getSlot(String slotName) {
        return slots.get(slotName);
    }

    public void displayProducts() {
        for (Map.Entry<String, Slot> entry : slots.entrySet()) {
            Slot slot = entry.getValue();
            String code = entry.getKey();

            System.out.println(code + "->" + slot.getProduct());
        }
    }
}
