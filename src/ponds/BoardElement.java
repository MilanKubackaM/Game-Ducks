package ponds;
import cards.pondCards.PondCard;
import cards.actionCards.ActionCard;

public class BoardElement {
    PondCard pondCard = new PondCard();
    ActionCard actionCard = new ActionCard();

    public BoardElement(){}

    public BoardElement(PondCard card){
        this.pondCard = card;
    }
    public BoardElement(ActionCard card){
        this.actionCard = card;
    }

    public void setCard(PondCard pondCard) {

        this.pondCard = pondCard;
    }

    public void setActionCard(ActionCard actionCard) {

        this.actionCard = actionCard;
    }

    public ActionCard getActionCard() {
        return actionCard;
    }

    public PondCard getPondCard() {
        return pondCard;
    }
}
