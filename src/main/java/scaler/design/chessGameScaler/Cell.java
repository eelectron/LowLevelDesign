package scaler.design.chessGameScaler;

public class Cell {
    // rowNo of the cell
    private String rowNo;
    
    // column number of the cell
    private int colNo;
    
    // is cell occupied
    private boolean isOccupied;
    
    // cell has a piece
    private Piece piece;
    
    public Cell(String rowNo, int colNo) {
        this.rowNo = rowNo;
        this.colNo = colNo;
        this.isOccupied = false;
    }

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Cell clone() {
        Cell cell = new Cell(rowNo, colNo);
        cell.setPiece(piece);
        return cell;
    }
    
    @Override
    public String toString() {
        return "(" + rowNo + "," + colNo + "," + piece + ")";
    }
}