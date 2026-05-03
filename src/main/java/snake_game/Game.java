package snake_game;

import java.util.Scanner;

public class Game {
    private Snake snake;
    private Food food;
    private Board board;
    private FoodGenerator foodGenerator;
    private int score = 0;

    public Game(int rows, int columns) {
        this.board = new Board(rows, columns);
        snake = new Snake(new Cell(0, 0));
        foodGenerator = new FoodGenerator();
        food = new Food(foodGenerator.generateFood(board, snake.getSnakeSet()));
        score = 0;
    }

    public void start() {
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
                    direction = Direction.LEFT;
                    break;
                case 4:
                    direction = Direction.RIGHT;
                    break;
            }

            // generate next move
            Cell head = snake.getHead();
            Cell next = getNextPosition(head, direction);

            // inside wall
            if(board.isInBounds(next) == false) {
                System.out.println("snake hits the wall");
                return ;
            }

            // check for bite itself
            if(isBiteItself(next, snake)){
                System.out.println("snake bites itself");
                return ;
            }

            // eating food
            boolean hadFood = next.equals(food.getFoodLocation());
            snake.move(next,  hadFood);
            if(hadFood) {
                score++;

                // new food
                food = new  Food(foodGenerator.generateFood(board, snake.getSnakeSet()));
            }
        }
    }

    private boolean isBiteItself(Cell next, Snake snake) {
        // remove tail
        Cell tail = snake.removeTail();

        // check if next cell is already in body part
        if(snake.getSnakeSet().contains(next)) {
            return true;
        }

        // restore tail
        snake.addTail(tail);
        return false;
    }

    private Cell getNextPosition(Cell head, Direction direction) {
        int x = head.getX();
        int y = head.getY();

        switch (direction) {
            case UP:
                x = x - 1;
                y = y;
                break;
            case DOWN:
                x = x + 1;
                y = y;
                break;
            case LEFT:
                x = x;
                y = y - 1;
                break;
            case RIGHT:
                x = x;
                y = y + 1;
                break;
        }
        return new Cell(x, y);
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
