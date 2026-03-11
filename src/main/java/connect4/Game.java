package connect4;

import scaler.design.chessGame.Move;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Status status;
    private Player winner;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.currentPlayer = player1;
        this.player1 = player1;
        this.player2 = player2;
        this.status = Status.IN_PROGRESS;
        this.winner = null;
    }

    public Board getBoard() {
        return board;
    }

    /**
     * Core logic :
     * 1 . place the disc in a column
     * 2 . check if the player wins
     * 3 . check if match is draw
     * 4 . switch the player
     * <p>
     * Edge cases :
     * 1 . column out of boundary
     * 2 . column is already full
     * 3 . Not player's turn
     *
     * @param player
     * @param column
     */
    public boolean makeMove(Player player, int column) {
        if (column < 0 || column >= board.getCols()) {
            return false;
        }

        if (player != currentPlayer) {
            return false;
        }

        int row = board.placeDisc(player, column);
        if (row == -1) {
            return false;
        }

        boolean won = board.checkWinner(player, row, column);
        if (won == true) {
            status = Status.COMPLETED;
            winner = player;
        } else if (board.isFull()) {
            status = Status.DRAW;
        } else {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
        return true;
    }

    public Status getStatus() {
        return status;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
