package scaler.design.chessGameScaler;
/*
 * Track a move by player
 * */
public class MoveInfo {
    private Cell start;
    private Cell end;
    Player player;
    Piece killedPiece;
    
    // piece at start cell
    Piece piece;

    public MoveInfo(Cell start, Cell end, Player player, Piece killedPiece, Piece piece) {
        super();
        this.start = start;
        this.end = end;
        this.player = player;
        this.killedPiece = killedPiece;
        this.piece = piece;
    }

    public MoveInfo(Cell start, Cell end, Player player, Piece piece) {
        super();
        this.start = start;
        this.end = end;
        this.player = player;
        this.piece = piece;
    }
    
    public Cell getStart() {
        return start;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    
}
