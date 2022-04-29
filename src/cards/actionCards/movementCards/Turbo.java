package cards.actionCards.movementCards;

import cards.actionCards.ActionCard;
import cards.pondCards.PondCard;

import java.util.ArrayList;
import java.util.Collections;

public class Turbo extends ActionCard {
    public Turbo(){}

    public void StartTurbo(int index, ArrayList<PondCard> pondCards){
        Collections.swap(pondCards, index, 0);
    }
}
