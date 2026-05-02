package snake_game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Snake {
    private Deque<Cell> body;
    private final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private Direction currentDirection;
    private int rows;
    private int cols;

    // maintain set of body cells for efficient checking of snake bite itself
    private Set<Cell> snakeSet;

    public Snake(int rows, int cols) {
        body = new ArrayDeque<>();
        Cell cell = new Cell(0, 0);
        body.add(cell);
        currentDirection = Direction.RIGHT;
        this.rows = rows;
        this.cols = cols;
        this.snakeSet = new HashSet<>();
        this.snakeSet.add(cell);
    }

    /**
     * Return false if snake bite itself, it hits the wall
     * otherwise returns true
     *
     * @param direction
     * @return
     */
    public boolean move(Direction direction, Food food) {
        // generate new head
        Cell head = body.getFirst();
        int x = head.getX();
        int y = head.getY();

        switch (direction) {
            case UP:
                x = x + dir[0][0];
                y = y + dir[0][1];
                break;
            case DOWN:
                x = x + dir[1][0];
                y = y + dir[1][1];
                break;
            case RIGHT:
                x = x + dir[2][0];
                y = y + dir[2][1];
                break;
            case LEFT:
                x = x + dir[3][1];
                y = y + dir[3][0];
                break;
        }

        Cell newHead = new Cell(x, y);

        // check collision with wall
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return false;
        }

        body.addFirst(newHead);

        // new head not equal to food
        if (!newHead.equals(food.getFoodLocation())) {
            Cell tail = body.removeLast();
            snakeSet.remove(tail);
        }
        else{
            food.generateFoodAtRandomLocation();
        }

        // snake bite itself
        if (snakeSet.contains(newHead)) {
            return false;
        }

        snakeSet.add(newHead);
        return true;
    }

    public int size() {
        return body.size();
    }

    @Override
    public String toString() {
        return body.toString();
    }
}
