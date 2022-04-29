package cards.actionCards.playerActions;
import cards.actionCards.ActionCard;
import cards.pondCards.PondCard;
import ponds.Board;

public class Target extends ActionCard {
    /*private boolean targeted = false;
    int position;


    public boolean isTargeted() {                            //ak bude zamierene
        return this.targeted;
    }

    public void setTargeted(boolean targeted) {           // tak mozeme zamierit poziciu
        if(!this.targeted)
            this.targeted = targeted;
        else
            System.out.println("Already targeted, use another card!\n");
    }
*/
    public Target(){
    }


    /*public boolean targetCardCheck(Board boardCard){                   //Overenie ci bola karta uz pred tym zamierena
        if (targeted)
            System.out.println("Card already targeted, use another card instead!\n");
        else{
            System.out.println("Card successfully targeted!");
            targeted = true;
            return true;
        }
        targeted = false;
        return false;
    }

    public boolean isTargeted() {
        return targeted;
    }
    */


    /* public Board targetCardCheck(Board boardCard){
        if (targeted)
            System.out.println("Card already targeted, use another card instead!\n");
        else{
            System.out.println("Card successfully targeted!");
            targeted = true;
            return boardCard;
        }
        targeted = false;
        return null;
    }

    */




}
