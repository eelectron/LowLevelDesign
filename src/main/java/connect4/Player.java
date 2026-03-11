package connect4;

public class Player {
    private int id;
    private DiscColor discColor;
    private String playerName;

    public Player(int id, DiscColor discColor, String playerName) {
        this.id = id;
        this.discColor = discColor;
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public DiscColor getDiscColor() {
        return discColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String toString() {
        return playerName;
    }
}
