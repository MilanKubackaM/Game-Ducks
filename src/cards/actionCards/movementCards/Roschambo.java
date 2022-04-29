package cards.actionCards.movementCards;

import cards.actionCards.ActionCard;
import cards.pondCards.PondCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Roschambo extends ActionCard {
    public Roschambo(){}

    public void StartRoschambo(ArrayList<PondCard> pondCards){
        Collections.shuffle((pondCards));
    }

}
