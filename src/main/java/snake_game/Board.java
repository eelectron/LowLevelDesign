package snake_game;

public class Board {
    private int rows;
    private int cols;
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public boolean isInBounds(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
