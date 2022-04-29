package ponds;

import cards.actionCards.ActionCard;
import cards.actionCards.playerActions.Target;
import cards.pondCards.Duck;
import cards.pondCards.PondCard;

import java.util.ArrayList;
import java.util.ListIterator;

public class Board {

    //   Vytvorenie listu na pondDeck, actionDeck a kariet na stole
    ArrayList<PondCard> pondCards = new ArrayList<PondCard>();
    ArrayList<ActionCard> actionCard = new ArrayList<ActionCard>();
    ArrayList<BoardElement> cardsOnBoard = new ArrayList<BoardElement>();

    public Board(){}


    public void addCardToDeck(PondCard card) {
        this.pondCards.add(card);
    }


    public void addPondCardToBoardSlot(PondCard card, int id) {
       /* ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();
        BoardElement element = new BoardElement(card);
        for (int i = 0; i < id; i++){
            cardsOnBoardIterator.next();
        }
        cardsOnBoardIterator.add(element);
    }

        */
        this.cardsOnBoard.get(id).setCard(card);
    }

    public void addActionCardToBoardSlot(ActionCard card, int id){
        /*ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();
        BoardElement element = new BoardElement(card);
        for (int i = 0; i < id+6; i++){
            cardsOnBoardIterator.next();
        }
        cardsOnBoardIterator.remove();
        cardsOnBoardIterator.add(element);
        */
        this.cardsOnBoard.get(id).setActionCard(card);
    }

    public void createCardsOnBoard(){
        for (int i = 0; i < 7; i++){
            BoardElement slot = new BoardElement();
            cardsOnBoard.add(slot);
        }
    }


    //Nemusime nijak inak prepajat Action Card s kartou na boarde
    // kedze Action Card sa viaze na miesto na boarde a nie na kartu
    public void addActionCardToDeck(ActionCard card) {
        this.actionCard.add(card);

    }

    //public void addActionCardOnBoard(ActionCard card) {
   //     boardElement.setActionCard(card);
    //}

    public void printCards(){
        int val = 0;
        String pondCard;
        String actionCard;
        while (val < this.cardsOnBoard.size() - 1) {
            //if(val<6) {
            if(this.cardsOnBoard.get(val).getPondCard() instanceof Duck)
                pondCard = "Duck";
            else
                pondCard = "Water";
            if(this.cardsOnBoard.get(val).getActionCard() instanceof Target)
                actionCard = "Target";
            else
                actionCard = "------";


                System.out.println(val + 1 + ": " + pondCard + " " + (this.cardsOnBoard.get(val).getPondCard().getPlayerId() + 1) + "      " + actionCard);
            //}
            //System.out.println(val + 1 + ": " + this.cardsOnBoard.get(val).getActionCard().getClass());
            /*&else if (this.cardsOnBoard.get(val).getActionCard() instanceof Target){
                System.out.println(val + 1 + ": " + "TARGET");
            }
            else{
                System.out.println(val + 1 + ": " + "ACTION_CARD");
            }
            */

                val++;
        }
    }

    public ActionCard removeCard(int id) {
        ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();
        BoardElement element = new BoardElement();

        for (int i = 0; i < id; i++) {
            element = cardsOnBoardIterator.next();
        }
        BoardElement return_element = new BoardElement();

        return_element = cardsOnBoardIterator.next();
        cardsOnBoardIterator.previous();
        cardsOnBoardIterator.next().setCard(new PondCard());
        cardsOnBoardIterator.previous();
        cardsOnBoardIterator.next().setActionCard(new ActionCard());

        return return_element.getActionCard();
    }

    public void addNewPondCard(){  // tato funkcia nieje potrebne indexovat, kedze PondCard sa pridava na koniec t.j. na index 5
        ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();
        for (int i = 0; i < 6; i++) {
            cardsOnBoardIterator.next();
        }
        //cardsOnBoardIterator.next().setCard(pondCards.get(0));
        //this.pondCards.remove(0);
    }


    public Board getBoardCard(int id) {
        ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();

        for (int i = 0; i < id; i++){
            cardsOnBoardIterator.next();
        }
        Board return_card = (Board) cardsOnBoardIterator;
        return return_card;
    }

    public ArrayList<BoardElement> getCardsOnBoard() {
        return cardsOnBoard;
    }

    public BoardElement getBoardElement(int index){
        ListIterator<BoardElement> cardsOnBoardIterator = cardsOnBoard.listIterator();
        for (int i = 0; i < index; i++){
            cardsOnBoardIterator.next();
        }
        return cardsOnBoardIterator.next();
    }

    public ArrayList<PondCard> getPondCards() {
        return pondCards;
    }
}
