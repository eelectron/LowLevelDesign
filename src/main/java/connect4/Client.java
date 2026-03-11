package connect4;

import java.util.Scanner;

/**
 * Run this class to play the Game
 */
public class Client {
    static void main() {
        Player player1 = new Player(1, DiscColor.BLUE, "ChunMun");
        Player player2 = new Player(2, DiscColor.YELLOW, "Prashant");
        Board board = new Board(7, 6);

        Game game = new Game(board, player1, player2);
        Scanner input = new Scanner(System.in);
        while (game.getStatus() == Status.IN_PROGRESS) {
            // print board
            board.printBoard();

            // take input for player
            int column = input.nextInt();

            game.makeMove(game.getCurrentPlayer(), column);
        }

        if (game.getStatus() == Status.COMPLETED) {
            System.out.println("Congratulations! You win! " + game.getWinner());
        } else {
            System.out.println("DRAW");
        }
    }
}
