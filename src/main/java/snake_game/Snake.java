package snake_game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Snake {
    private Deque<Cell> body;
    private Direction currentDirection;

    // maintain set of body cells for efficient checking of snake bite itself
    private Set<Cell> snakeSet;

    public Snake(Cell cell) {
        body = new ArrayDeque<>();
        body.add(cell);
        currentDirection = Direction.RIGHT;
        this.snakeSet = new HashSet<>();
        this.snakeSet.add(cell);
    }

    /**
     * Return false if snake bite itself, it hits the wall
     * otherwise returns true
     *
     * @param next
     * @return
     */
    public boolean move(Cell next, boolean hadFood) {
       body.addFirst(next);
       snakeSet.add(next);

       if(!hadFood) {
           Cell tail = body.removeLast();
           snakeSet.remove(tail);
       }
        return true;
    }

    public int size() {
        return body.size();
    }

    public Cell getHead(){
        return body.getFirst();
    }

    public void addTail(Cell cell){
        body.addLast(cell);
        snakeSet.add(cell);
    }

    public Set<Cell> getSnakeSet() {
        return snakeSet;
    }

    public Cell removeTail(){
        Cell tail = body.removeLast();
        snakeSet.remove(tail);
        return tail;
    }

    @Override
    public String toString() {
        return body.toString();
    }
}
