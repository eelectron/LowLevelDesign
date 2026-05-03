package snake_game;

import java.util.Random;

public class Food {
    private Cell cell;
    public Food(Cell cell) {
        this.cell = cell;
    }

    public Cell getFoodLocation() {
        return cell;
    }

    @Override
    public String toString() {
        return cell.toString();
    }
}
