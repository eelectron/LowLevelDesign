package ticTacToe;

public class Cell {
    private final int row;
    private final int col;
    private Symbol symbol;

    public Cell(int row, int col, Symbol symbol) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Row and column must be non-negative");
        }
        this.row = row;
        this.col = col;
        this.symbol = symbol == null ? Symbol.EMPTY : symbol;
    }

    /**
     * Creates an empty cell at the given coordinates.
     */
    public static Cell empty(int row, int col) {
        return new Cell(row, col, Symbol.EMPTY);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        if (symbol == null) {
            throw new IllegalArgumentException("Symbol cannot be null");
        }
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol == Symbol.EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell other = (Cell) o;
        return row == other.row && col == other.col && symbol == other.symbol;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(row);
        result = 31 * result + Integer.hashCode(col);
        result = 31 * result + (symbol == null ? 0 : symbol.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Cell(%d,%d)=%s", row, col, symbol);
    }
}
