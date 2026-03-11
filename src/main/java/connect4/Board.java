package connect4;

public class Board {
    private int rows;
    private int cols;
    private DiscColor[][] grid;
    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        grid = new DiscColor[rows][cols];
    }

    public boolean isFull() {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(String.format("%-15s", grid[i][j]) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Place the disc in first empty row from bottom of column .
     * @param player
     * @param column
     * @return row where disc is placed
     */
    public int placeDisc(Player player, int column) {
        for(int i = rows - 1; i >= 0; i--){
            if(grid[i][column] == null){
                grid[i][column] = player.getDiscColor();
                return i;
            }
        }
        return -1;
    }

    /**
     * Check in all 8 directions
     * @param player
     * @param row
     * @param column
     * @return
     */
    public boolean checkWinner(Player player, int row, int column) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for(int i = 0; i < directions.length; i++){
            int dr  = directions[i][0];
            int dc = directions[i][1];

            int count = countDisc(player.getDiscColor(), row, column, dr, dc);
            if(count >= 4){
                return true;
            }
        }
        return false;
    }

    private int countDisc(DiscColor discColor, int row, int column, int dr, int dc) {
        int count = 0;
        while(row >= 0 && row < getRows() && column >= 0 && column < getCols()){
            if(grid[row][column] != discColor){
                break;
            }

            count += 1;
            row += dr;
            column += dc;
        }
        return count;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }
}
