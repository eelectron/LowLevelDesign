package snake_game;

import java.util.Scanner;

public class Game {
    private Snake snake;
    private Food food;
    private int rows;
    private int columns;
    private int score = 0;

    public Game(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        snake = new Snake(rows, columns);
        food = new Food(rows, columns);
        score = 0;
    }

    public boolean start() {
        // take direction from user
        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.println(snake);
            System.out.println(food);

            int choice = input.nextInt();
            Direction direction = Direction.UP;

            switch (choice) {
                case 1:
                    direction = Direction.UP;
                    break;
                case 2:
                    direction = Direction.DOWN;
                    break;
                case 3:
                    direction = Direction.RIGHT;
                    break;
                case 4:
                    direction = Direction.LEFT;
                    break;
            }

            boolean moved = snake.move(direction, food);
            if (moved == false) {
                break;
            }
            score = snake.size();

        }
        return true;
    }

    public int getScore() {
        return score;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }
}
