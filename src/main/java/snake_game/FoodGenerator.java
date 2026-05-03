package snake_game;

import java.util.Random;
import java.util.Set;

public class FoodGenerator {
    private Random random = new Random();

    public Cell generateFood(Board board, Set<Cell> bodySet){
        while(true){
            int x = random.nextInt(board.getRows());
            int y = random.nextInt(board.getCols());

            Cell cell = new Cell(x, y);
            if(bodySet.contains(cell) == false){
                return cell;
            }
        }
    }
}
