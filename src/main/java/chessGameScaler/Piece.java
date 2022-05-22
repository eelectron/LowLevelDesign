package chessGameScaler;

public class Piece {
    private String id;
    private PieceType name;
    private Color color;
    
    
    public Piece(String id, PieceType name, Color color) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public PieceType getName() {
        return name;
    }
    public void setName(PieceType name) {
        this.name = name;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name + "," + color;
    }
}
