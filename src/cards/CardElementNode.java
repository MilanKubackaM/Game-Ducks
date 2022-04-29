package cards;
//import cards.actionCards.ActionCard;
//import cards.boardCards.BoardCard;
//import ponds.BoardElementNode;




public class CardElementNode {

    public Card card;
    public CardElementNode next;

    public CardElementNode(Card card, CardElementNode next) {
        this.card = card;
        this.next = next;
    }

    public String toString(){
        return card + "";
    }






};

