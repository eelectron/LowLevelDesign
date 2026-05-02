package snake_game;

import java.util.Random;

public class Food {
    private Cell cell;
    private int rows;
    private int columns;
    public Food(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cell = generateFoodAtRandomLocation();
    }

    public Cell generateFoodAtRandomLocation() {
        Random random = new Random();
        int x = random.nextInt(rows);
        int y = random.nextInt(columns);
        Cell randomCell = new Cell(x, y);
        cell = randomCell;
        return cell;
    }

    public Cell getFoodLocation() {
        return cell;
    }

    @Override
    public String toString() {
        return cell.toString();
    }
}
