package players;
import hands.Hand;

public class Player {
    int id;
    int hp;
    Hand hand = new Hand();

    //Player player = new Player(id);

    public Player(int id){
        this.id = id;
        this.hp = 5;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHp(int change) {
        this.hp = hp+change;
    }

    public int getHp() {
        return hp;
    }
}
