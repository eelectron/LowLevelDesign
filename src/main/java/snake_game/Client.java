package snake_game;

public class Client {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        Game game = new Game(rows, columns);
        game.start();
        System.out.println(game.getSnake());
        System.out.println(game.getFood());
    }
}
