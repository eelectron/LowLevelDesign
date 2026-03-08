package ticTacToe;

public class Board {
    private final Cell[][] cells;

    public Board(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Board dimensions must be positive");
        }
        cells = new Cell[rows][columns];
        // initialize with empty cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                cells[r][c] = Cell.empty(r, c);
            }
        }
    }

    public int numRows() {
        return cells.length;
    }

    public int numCols() {
        return cells[0].length;
    }

    /**
     * Attempts to apply a player's move to the board. The provided cell's row/col
     * indicate the position; the symbol from the player will be written.
     *
     * @param cell   destination coordinates (symbol is ignored)
     * @param player player making the move
     * @return true if the move was placed; false if out of bounds or the cell is
     * already occupied by X/O.
     */
    public boolean placeMove(Cell cell, Player player) {
        if (cell == null || player == null) {
            throw new IllegalArgumentException("Cell and player cannot be null");
        }
        int row = cell.getRow();
        int col = cell.getCol();
        if (row < 0 || row >= numRows() || col < 0 || col >= numCols()) {
            return false; // invalid position
        }
        Cell existing = cells[row][col];
        if (!existing.isEmpty()) {
            return false; // already occupied
        }
        // place symbol
        cells[row][col] = new Cell(row, col, player.getSymbol());
        return true;
    }

    public Symbol getSymbolAt(int row, int col) {
        if (row < 0 || row >= numRows() || col < 0 || col >= numCols()) {
            throw new IndexOutOfBoundsException("Coordinates out of board range");
        }
        return cells[row][col].getSymbol();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : cells) {
            for (Cell c : row) {
                sb.append(c.getSymbol()).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
