package ticTacToe;

public class Game {
    private final Board board;
    private final Player[] players;
    private int currentIndex;

    public Game(Player player1, Player player2, int boardSize) {
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Players cannot be null");
        }
        if (boardSize <= 0) {
            throw new IllegalArgumentException("Board size must be positive");
        }
        board = new Board(boardSize, boardSize);
        players = new Player[]{player1, player2};
        currentIndex = 0;
    }

    public Game() {
        // convenience constructor with default names/symbols
        this(new Player("Player1", Symbol.X), new Player("Player2", Symbol.O), 3);
    }

    /**
     * Attempt to make a move for the current player. If the cell is valid and
     * empty the move is placed and turn passes. The winner (1 or 2) or 0 if no
     * winner yet is returned.
     *
     * @param cell destination of the move
     * @return 0 for no winner yet, 1 or 2 if the corresponding player just won,
     *         or -1 if the move was invalid (out of bounds or occupied)
     */
    public int makeMove(Cell cell) {
        Player player = getCurrentPlayer();
        boolean ok = board.placeMove(cell, player);
        if (!ok) {
            return -1;
        }
        int winner = evaluateWinner(cell.getRow(), cell.getCol(), player.getSymbol());
        if (winner == 0) {
            togglePlayer();
        }
        return winner;
    }

    private void togglePlayer() {
        currentIndex = 1 - currentIndex;
    }

    public Player getCurrentPlayer() {
        return players[currentIndex];
    }

    /**
     * Simple winner check after the last move.
     */
    private int evaluateWinner(int row, int col, Symbol sym) {
        int n = board.numRows();
        // row
        boolean rowWin = true;
        for (int c = 0; c < n; c++) {
            if (board.getSymbolAt(row, c) != sym) {
                rowWin = false;
                break;
            }
        }
        if (rowWin) return currentIndex + 1;
        // column
        boolean colWin = true;
        for (int r = 0; r < n; r++) {
            if (board.getSymbolAt(r, col) != sym) {
                colWin = false;
                break;
            }
        }
        if (colWin) return currentIndex + 1;
        // diagonals
        if (row == col) {
            boolean diag = true;
            for (int i = 0; i < n; i++) {
                if (board.getSymbolAt(i, i) != sym) {
                    diag = false;
                    break;
                }
            }
            if (diag) return currentIndex + 1;
        }
        if (row + col == n - 1) {
            boolean anti = true;
            for (int i = 0; i < n; i++) {
                if (board.getSymbolAt(i, n - 1 - i) != sym) {
                    anti = false;
                    break;
                }
            }
            if (anti) return currentIndex + 1;
        }
        return 0;
    }

    public Board getBoard() {
        return board;
    }
}

