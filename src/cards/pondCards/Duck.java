package cards.pondCards;


public class Duck extends PondCard {
    private int playerId;

    public Duck(int id) {
        this.playerId = id;
    }

    public int getPlayerId() {
        return playerId;
    }
}
