package cards.actionCards.movementCards;
import cards.pondCards.PondCard;
import ponds.Board;
import ponds.Board.*;

import cards.actionCards.ActionCard;

import java.util.ArrayList;
import java.util.ListIterator;

public class DuckMovement extends ActionCard {


    public DuckMovement() {}

    public ArrayList<PondCard> StartDuckMovement(ListIterator<PondCard>cardListIterator){
        //ListIterator<PondCard>cardListIterator = pondcardArray.listIterator();
        ArrayList<PondCard> newPondcardArray = new ArrayList<>();
        PondCard pondcard = cardListIterator.next();

        while(cardListIterator.hasNext()){
            newPondcardArray.add(cardListIterator.next());
        }
        newPondcardArray.add(pondcard);
        return newPondcardArray;
    }


}
