package ticTacToe;

import java.util.Arrays;

class TicTacToe {
    // player board
    private int[][] board;

    // count no. of moves by player1 and player for each row
    PlayerStatistic[] rows;

    // count no. of moves by player1 and player for each column
    PlayerStatistic[] columns;

    // consider diagonal
    PlayerStatistic diagonal;

    // consider anti diagonal
    PlayerStatistic antiDiagonal;

    // board size
    private final int SIZE;

    public TicTacToe(int n) {
        SIZE = n;

        board = new int[n][n];

        rows = new PlayerStatistic[n];
        for(int i = 0; i < n; i++){
            rows[i] = new PlayerStatistic();
        }

        columns = new PlayerStatistic[n];
        for(int i = 0; i < n; i++){
            columns[i] = new PlayerStatistic();
        }

        diagonal = new PlayerStatistic();

        antiDiagonal = new PlayerStatistic();
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;

        if(player == 1){
            rows[row].player1 += 1;
            columns[col].player1 += 1;

            if(row - col == 0){
                // main diagonal
                diagonal.player1 += 1;
            }

            if(row + col == SIZE - 1){
                // anti diagonal
                antiDiagonal.player1 += 1;
            }
        }
        else{
            rows[row].player2 += 1;
            columns[col].player2 += 1;

            if(row - col == 0){
                // main diagonal
                diagonal.player2 += 1;
            }

            if(row + col == SIZE - 1){
                // anti diagonal
                antiDiagonal.player2 += 1;
            }
        }

        // check for winner
        return getWinner(row, col);
    }

    private int getWinner(int row, int col){
        // check for winner
        if(rows[row].player1 == SIZE || columns[col].player1 == SIZE || diagonal.player1 == SIZE || antiDiagonal.player1 == SIZE){
            return 1;
        }

        if(rows[row].player2 == SIZE || columns[col].player2 == SIZE || diagonal.player2 == SIZE || antiDiagonal.player2 == SIZE){
            return 2;
        }
        return 0;
    }
}

class PlayerStatistic{
    int player1;
    int player2;
    PlayerStatistic(){
        player1 = 0;
        player2 = 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */