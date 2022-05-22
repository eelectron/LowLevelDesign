package chessGameScaler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Game {
    // game stores moves of the players
    private List<MoveInfo> moves;
    
    // represents game status win, lose or tie
    private GameStatus status;
    
    // game has a chess board
    private Board board;
    
    private Player player1;
    private Player player2;
    private String id;      // unique id for the game
    
    private Player currentPlayer; // always holds current player
    
    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public Game() {
        initializeGame();
    }
    
    public boolean initializeGame() {
        // init moves list
        moves = new ArrayList<>();
        
        // game id for each new game
        this.id = UUID.randomUUID().toString();
        
        // initialize the chess board
        this.board = new Board(id);
        
        // initialize players
        player1 = new Player(UUID.randomUUID().toString(), "player1", Color.BLACK, id);
        player2 = new Player(UUID.randomUUID().toString(), "player2", Color.WHITE, id);
        
        // Black has first turn
        currentPlayer = player1;
        
        // game is ready
        this.status = GameStatus.READY;
        
        
        return true;
    }
    
    
    public boolean makeMove(Player currentPlayer) {
        return true;
    }
    
    /*
     * Make a move on the chess board
     * */
    public boolean makeMove(Cell source, Cell destination) {
        return true;
    }
    
    /*
     * Returns true if move is valid
     * */
    private boolean isMoveValid(Piece piece, Cell source, Cell destination) {
        return true;
    }
    
    /*
     * Start the game
     * */
    public boolean start() {
        // read input from console
        Scanner input = new Scanner(System.in);
        
        System.out.println("================Game starts==================");
        
        while(status != GameStatus.END) {
            board.printBoard();
            
            System.out.println("It is now " + currentPlayer + " turns");
            System.out.println("Type end to end the game, otherwise press n");
            String wantToContinue = input.next();
            if(wantToContinue.equalsIgnoreCase("end")) {
                status = GameStatus.END;
                break;
            }
            
            // take input from user
            System.out.println("Enter source cell and destination cell location such as A 4 or G 7");
            char sourceR;
            int sourceC;
            
            char destinationR;
            int destinationC;
            
            sourceR = input.next().charAt(0);
            sourceC = input.nextInt();
            
            destinationR = input.next().charAt(0);
            destinationC = input.nextInt();
            
            // save the move
            Cell sc = board.getCell(sourceR, sourceC);
            Cell dc = board.getCell(destinationR, destinationC);
            Piece sp = sc.getPiece();
            Piece dp = dc.getPiece();
            
            MoveInfo move = new MoveInfo(sc, dc, currentPlayer, dc.getPiece(), sc.getPiece());
            moves.add(move);
            
            // make the move
            makeMove(sourceR, sourceC, destinationR, destinationC);
            
            // is won
            if(isWon(sc, dc)) {
                System.out.println("YAYYYYYYYY " + currentPlayer + " WON !!!");
                status = GameStatus.END;
            }
           
            // switch player
            currentPlayer = nextPlayer();
        }
        
        return true;
    }
    
    private boolean isWon(Cell sc, Cell dc) {
        // TODO Auto-generated method stub
        if(sc == null || dc == null) {
            return false;
        }
        
        Piece sp = sc.getPiece();
        Piece dp = dc.getPiece();
        if(sp == null || dp ==null) {
            return false;
        }
        
        if(dp.getName() == PieceType.KING) {
            return true;
        }
        return false;
    }

    private Player nextPlayer() {
        if(currentPlayer == player1) {
            return player2;
        }
        return player1;
    }

    private void makeMove(char sourceR, int sourceC, char destinationR, int destinationC) {
        // TODO Auto-generated method stub
        this.board.makeMove(sourceR, sourceC, destinationR, destinationC);
    }

    /*
     * End the game
     * */
    public boolean end() {
       System.out.println("Game ends");
       return true; 
    }
    
    // unit test cases 
    
    // make sure no code duplication
    
    // make member as private and use getter and setter
    
    // make sure extendible code
}