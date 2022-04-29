package players;

import java.util.ArrayList;

public class PlayerHandler {
    int playerAmount;
    private ArrayList<Player> players = new ArrayList<Player>();
    public PlayerHandler(){
        this.playerAmount = 0;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void createNewPlayer() {
        players.add(new Player(this.playerAmount));
        this.playerAmount = this.playerAmount + 1;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
