package cards.actionCards.playerActions;
import java.util.*;

import cards.Card;
import cards.actionCards.ActionCard;
import cards.pondCards.Duck;
import cards.pondCards.PondCard;
import players.Player;
import ponds.Board;
import ponds.BoardElement;


import java.util.ArrayList;
import java.util.ListIterator;

public class Shoot extends ActionCard {
    int id;

    public Shoot(){}




    public boolean Fire(int id, ArrayList<BoardElement> cardsOnBoard, ListIterator<PondCard> pondCardsShuffledIterator, Player[] player, ListIterator<ActionCard> actionCardsShuffledIterator){
        //              index   | deck (playerAmount*3) su uz rozdane      |   deck      |  6 vylozenych kariet

        //Parametrom je informacia ci je karta zamierena alebo nie
        //ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();
        //BoardElement element = new BoardElement();

        //ListIterator<ActionCard> actionCardListIterator = actionCard.listIterator();
        //for (int i = 1; i < actionCard.length; i++){
        //    actionCardListIterator.next();
        //}
//        if(actionCardListIterator.next() instanceof Target){
//            actionCardListIterator.add(board.removeCard(id));
//            return true;
//        }
        //int actionCardLen = actionCardIterator.size();
/*
        ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();    //6 vylozenych kariet
        for (int i = 0; i < id; i++){
            System.out.println("ID: " + id + " CLASSA: " + cardsOnBoardIterator.next().getActionCard().getClass() + "\n"); // ak je ID napr 2, vypiseme akcne karty na pozicii 0 a 1

        }

        System.out.println("Ukazujeme na akcnu kartu:   " + cardsOnBoardIterator.next().getActionCard().getClass() + "\n"); // Vypiseme akcnu kartu na pozicii 2 (pri indexovani od 0)
        cardsOnBoardIterator.previous();
*/



        if (cardsOnBoard.get(id).getActionCard() instanceof Target ){    // ak sa nasla Target karta na indexe
            //System.out.println("Akcna karta TARGET sa nasla \n");

            while(actionCardsShuffledIterator.hasNext())
                actionCardsShuffledIterator.next();
            //actionCardsShuffledIterator.previous();
            actionCardsShuffledIterator.add(cardsOnBoard.get(id).getActionCard());

            cardsOnBoard.get(id).setActionCard(new ActionCard());       // namiesto Target karty vlozime prazdnu Action kartu

            if(cardsOnBoard.get(id).getPondCard() instanceof Duck) {      // hrac 0 ma kacicky s ID 5-9, hrac 1 ma kacicky s ID 10-14 atd....
                int indexKacickyHraca = cardsOnBoard.get(id).getPondCard().getPlayerId();
                player[indexKacickyHraca].setHp(-1);                             // pomocou set odpocitame HP hracovi
                //System.out.println("Odstranili sme kacicku hraca s indexom " + indexKacickyHraca + " jeho kacicku s indexom " + indexKacickyHraca + " , ostavajuce HP: " + player[indexKacickyHraca].getHp() + "\n");
                cardsOnBoard.get(id).setCard(pondCardsShuffledIterator.next());
                //System.out.println("Vlozili sme na board kartu: " + cardsOnBoard.get(id).getPondCard().getClass());
                return true;
            }
            //else
                //System.out.println("Na mieste sa nachadza voda a nie kacicka\n");
           /* cardsOnBoard.get(id).setCard(pondCardsShuffledIterator.next()); // namiesto kacicky (alebo vody) vlozime prvu kartu z decku, kedze ju prepiseme nemusime riesit remove,
                                                                            // lebo tam uz nebude a staci nam uz len ubrat zivot hracovi

          //  while (actionCardIterator.hasNext())                        // Posunieme sa na koniec
          //      actionCardIterator.next();
          //  actionCardIterator.add(new Target());                       // na koniec decku s akcnymi kartami vlozime Target kartu ktoru sme pouzili



            //cardsOnBoard.remove(id);
            //board.removeCard(id);
           // board.addNewPondCard();
            //System.out.println(boar);

            */
        }

        return false;
    }



}
