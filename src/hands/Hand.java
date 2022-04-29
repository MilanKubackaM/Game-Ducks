package hands;

import java.util.ArrayList;

import cards.actionCards.ActionCard;
import cards.actionCards.movementCards.*;
import cards.actionCards.playerActions.Bill;
import cards.actionCards.playerActions.Shoot;
import cards.actionCards.playerActions.Target;

public class Hand {
    ArrayList<ActionCard> actionCards = new ArrayList<ActionCard>();

    public Hand(){}

    public void addCard(ActionCard card){
        this.actionCards.add(card);
    }

    public ActionCard useCard(int id, ActionCard actionCard){
        ActionCard cardToReturn = this.actionCards.get(id);
        this.actionCards.remove(id);
        this.actionCards.add(actionCard);
        return cardToReturn;
    }



    public void printCards(){
        int val = 0;
        String card = new String();

        while (val < this.actionCards.size()) {
            if(this.actionCards.get(val) instanceof Shoot)
                card = "Shoot";
            else if(this.actionCards.get(val) instanceof Target)
                card = "Target";
            else if(this.actionCards.get(val) instanceof Bill)
                card = "Bill";
            else if(this.actionCards.get(val) instanceof Roschambo)
                card = "Rochambo";
            else if(this.actionCards.get(val) instanceof Turbo)
                card = "Turbo";
            else if(this.actionCards.get(val) instanceof DuckMovement)
                card = "Duck Movement";
            else if(this.actionCards.get(val) instanceof DuckDance)
                card = "Duck Dance";
            else
                card = "Empty hand";

            System.out.println(val + 1 + ": " + card);
            val++;
        }
    }
}
