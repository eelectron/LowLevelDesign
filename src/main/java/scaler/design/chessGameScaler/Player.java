package scaler.design.chessGameScaler;

public class Player {
    private String id;
    
    // name of player
    private String name;
    
    // Color assigned to the player
    private Color color;
    
    // There maybe multiple games going on , 
    // gameId tells to which game player associated with
    private String gameId;
    
    public boolean isPlaying() {
        return gameId != null;
    }

    public Player(String id, String name, Color color, String gameId) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "Player [" + "name=" + name + ", color=" + color + "]";
    }
}
