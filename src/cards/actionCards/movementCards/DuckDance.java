package cards.actionCards.movementCards;

import cards.actionCards.ActionCard;
import cards.pondCards.PondCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;

public class DuckDance extends ActionCard {
    public DuckDance(){}

    public void StartDuckDance(ArrayList<PondCard> pondCards, PondCard[] pondCardFromDeck){
        ListIterator<PondCard> pondCardsIterator = pondCards.listIterator();

        for (int i = 0; i < pondCards.size(); i++){
            pondCardFromDeck[pondCardFromDeck.length] = pondCardsIterator.next();
        }
        Collections.shuffle(Arrays.asList(pondCardFromDeck));

        ListIterator<PondCard> pondCardsIterator2 = pondCards.listIterator();

        for (int i = 0; i < pondCards.size(); i++){
            pondCardsIterator2.set(pondCardFromDeck[i]);
            pondCardsIterator2.next();
            for (int j = i + 1; j < pondCardFromDeck.length; j++){
                pondCardFromDeck[j - 1] = pondCardFromDeck[j];
            }
        }

    }


}
