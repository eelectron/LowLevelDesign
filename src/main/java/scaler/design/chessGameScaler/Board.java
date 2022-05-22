package scaler.design.chessGameScaler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * This class represents the chess board of size 8x8 .
 * */
public class Board {
    // unique id for every board
    private String id;

    //
    private List<List<Cell>> cells;

    // tells us to which Game this board belongs to
    // as there can be multiple games
    private String gameId;

    public Board(String id, List<List<Cell>> cells, String gameId) {
        this.id = id;
        this.cells = cells;
        this.gameId = gameId;
    }
    
    public Board(String gameId) {
        this.gameId = gameId;
  
        // initialize cells
        initializeAllCells();
    }

    
    // board rows = A, B C D E F G H
    // board columns = 1,2,3,4,5,6,7,8
    public boolean initializeAllCells() {
        this.cells = new ArrayList<>();
        
        // place blank cells
        for (char r = 'A'; r <= 'H'; r++) {
            List<Cell> row = new ArrayList<>();
            for (int c = 1; c <= 8; c++) {
                row.add(new Cell(r + "", c));
            }
            cells.add(row);
        }
        
        // now place Piece on black side
        placePieces('A', Color.BLACK);
        
        // place pawns
        placePawn('B', Color.BLACK);
        
        // now place Piece on white side
        placePieces('H', Color.WHITE);
        
        placePawn('G', Color.WHITE);
        return true;
    }

    // reset
    // move the board to initial state
    public boolean reset() {
        return initializeAllCells();
    }

    // print board
    public void printBoard() {
       
        for (int r = 'A'; r <= 'H'; r++) {
            for (int c = 1; c <= 8; c++) {
                System.out.printf("%16s", cells.get(r - 'A').get(c - 1));
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }
    
    /*
     * Place pawn on given row with given color
     * */
    private void placePawn(char rowNo, Color color) {
        List<Cell> row = cells.get(rowNo - 'A');
        
        for(int i = 0; i < 8; i++) {
            row.get(i).setPiece(new Piece(UUID.randomUUID().toString(),PieceType.PAWN, color));
        }
    }
    
    /*
     * Place piece on board other than pawn on given row
     * with given color
     * */
    private void placePieces(char rowNo, Color color) {
        List<Cell> firstRow = cells.get(rowNo - 'A');
        firstRow.get(0).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.ROOK, color));
        firstRow.get(7).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.ROOK, color));
        
        firstRow.get(1).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.KNIGHT, color));
        firstRow.get(6).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.KNIGHT, color));
        
        firstRow.get(2).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.BISHOP, color));
        firstRow.get(5).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.BISHOP, color));
        
        firstRow.get(3).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.KING, color));
        firstRow.get(4).setPiece(new Piece(UUID.randomUUID().toString(), PieceType.QUEEN, color));
    }
    

    public void makeMove(char sourceR, int sourceC, char destinationR, int destinationC) {
        // TODO Auto-generated method stub
        Cell sourceCell = cells.get(sourceR - 'A').get(sourceC - 1);
        
        // get source piece
        Piece piece = sourceCell.getPiece();
        
        // now remove piece from source cell
        sourceCell.setPiece(null);
        
        Cell destinationCell = cells.get(destinationR - 'A').get(destinationC - 1);
        destinationCell.setPiece(piece);
    }
    
    /*
     * Get the corresponding cell of board
     * given its row no and col no
     * */
    public Cell getCell(char rowNo, int colNo) {
        Cell cell = cells.get(rowNo - 'A').get(colNo - 1);
        return cell.clone();
    }
}