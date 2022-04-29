import java.util.Scanner;
import cards.actionCards.ActionCard;
import cards.actionCards.movementCards.DuckDance;
import cards.actionCards.movementCards.DuckMovement;
import cards.actionCards.movementCards.Roschambo;
import cards.actionCards.movementCards.Turbo;
import cards.actionCards.playerActions.*;
import cards.pondCards.*;
import players.Player;
import players.PlayerHandler;
import ponds.Board;
import ponds.BoardElement;

import java.util.concurrent.TimeUnit;

import java.util.*;

public class Game {
    public Game(){}
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number of players: ");
        int playersAmount = Integer.parseInt(scanner.nextLine());

        PondCard[] pondCard = new PondCard[5 + playersAmount * 5];
        ActionCard[] actionCard = new ActionCard[34];
        Player[] player = new Player[playersAmount];


        PlayerHandler playerHandler = new PlayerHandler();


        for (int i = 0; i < playersAmount; i++) {
            playerHandler.createNewPlayer();
        }



        for (int i = 0; i < 5; i++) {
            pondCard[i] = new Water();
        }

        for (int i = 0; i < playersAmount; i++){
            for (int z = 0; z < 5; z++) {
                pondCard[5 + i * 5 + z] = new Duck(i);
            }
        }

        // Print BOARDCARD testing
/*
        for (int i = 0; i < pondCard.length; i++){
            if (pondCard[i] instanceof Duck){
                System.out.println(pondCard[i].getPlayerId());
            }
            else{
                System.out.println(pondCard[i].getClass());
            }
        }

 */

        for (int i = 0; i < actionCard.length; i++){
            if(i < 10) {
                actionCard[i] = new Target();
                continue;
            }
            if(i < 22){
                actionCard[i] = new Shoot();           //defaultne nastavime vsetko na nezamierene
                continue;
            }
            if(i < 24){
                actionCard[i] = new Bill();
                continue;
            }
            if(i < 30){
                actionCard[i] = new Target();
                continue;
            }
            if(i < 31){
                actionCard[i] = new Turbo();
                continue;
            }
            if(i < 33){
                actionCard[i] = new Roschambo();
                continue;
            }
            actionCard[i] = new DuckDance();

        }

        // Print PONDCARD testing
/*
        for (int i = 0; i < actionCard.length; i++){
            System.out.println(actionCard[i].getClass()+ ": " + i);
        }

 */

        List<ActionCard> actionCardsShuffled = Arrays.asList(actionCard);

        Collections.shuffle(actionCardsShuffled);
        //System.out.println(Arrays.toString(actionCardsShuffled.toArray()));

        List<PondCard> pondCardsShuffled = Arrays.asList(pondCard);
        Collections.shuffle((pondCardsShuffled));
        //System.out.println(Arrays.toString((pondCardsShuffled.toArray())));

        List<ActionCard> mutableActionCardsShuffled = new ArrayList<>(actionCardsShuffled);
        ListIterator<ActionCard> mutablemutableActionCardsShuffledIterator = mutableActionCardsShuffled.listIterator();


        // Naplnenie HAND hracov akcnymi kartami
        ListIterator<ActionCard> mutableActionCardsShuffledIterator = actionCardsShuffled.listIterator();
        for (int i = 0; i < playersAmount; i++){
            player[i] = new Player(i);
            for(int z = 0; z < 3; z++){
                player[i].getHand().addCard(mutableActionCardsShuffledIterator.next());
            }
        }


        ListIterator<PondCard> pondCardsShuffledIterator = pondCardsShuffled.listIterator();
        Board board = new Board();
        board.createCardsOnBoard();     //Vytvori sloty na karty 6X2

        //Na BOARD vylozi prvych 6 kariet a nastavi vsetky miesta default na nezamierene
        Target[] target = new Target[6];
        for (int i = 0; i < 6; i++){
            board.addPondCardToBoardSlot(pondCardsShuffledIterator.next(), i);
        }





        //Scanner scanner = new Scanner(System.in);
        int roundCounter = 0;

        try {
            //System.out.println("Please input number of players: ");
            //int playerAmount = Integer.parseInt(scanner.nextLine());
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("Number of players: " + playersAmount + "\n");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("--- GAME STARTS ---\n");
            TimeUnit.SECONDS.sleep(2);
            while (true) {
                mutablemutableActionCardsShuffledIterator = mutableActionCardsShuffled.listIterator();
                System.out.println("-----------------------------    Round: " + ++roundCounter + "    ----------------------------- \n");

                for(int i = 0; i < playersAmount; i++){
                    board.printCards();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nPlayer number '" + (i+1) + "' on move, HP: " + player[i].getHp() + "\nYour Action cards: \n------------------------------");

                    player[i].getHand().printCards();
                    System.out.println("------------------------------");

                    int action = Integer.parseInt(scanner.nextLine());
                    ActionCard playActionCard = player[i].getHand().useCard(action - 1, mutableActionCardsShuffledIterator.next());
                    TimeUnit.SECONDS.sleep(1);

                    if(playActionCard instanceof Bill){
                        System.out.println("You picked 'Bill', now pick card to kill!\n");
                        int pickCardToKill = Integer.parseInt(scanner.nextLine()) - 1;
                        //Bill bill = new Bill();
                        ((Bill) playActionCard).Fire(pickCardToKill, board.getCardsOnBoard(), pondCardsShuffledIterator, player);
                    }

                    else if(playActionCard instanceof Shoot){
                        System.out.println("You picked 'Shoot', pick targeted position!\n");
                        TimeUnit.SECONDS.sleep(1);
                        int pickCardToKill = Integer.parseInt(scanner.nextLine()) - 1;

                        //ListIterator<BoardElement> cardsOnBoardIterator = board.getCardsOnBoard().listIterator();
                        //for (int x = 0; x < 6; x++) {
                            //cardsOnBoardIterator.next();
                        if (board.getBoardElement(pickCardToKill).getActionCard() instanceof Target) {
                            //System.out.println("It seem that you do. Let's kill the position '" + x + ";\n");
                            ((Shoot) playActionCard).Fire(pickCardToKill, board.getCardsOnBoard(), pondCardsShuffledIterator, player, mutablemutableActionCardsShuffledIterator);
                        }

                    }
                    else if(playActionCard instanceof Target){
                        System.out.println("You picked 'Target', give me position to Target!\n");
                        int positionToTarget = Integer.parseInt(scanner.nextLine());
                        TimeUnit.SECONDS.sleep(1);
                        if(!(board.getBoardElement(positionToTarget).getActionCard() instanceof Target))
                            board.addActionCardToBoardSlot(playActionCard, positionToTarget-1);
                        else if (board.getBoardElement(positionToTarget).getActionCard() instanceof Target)
                            System.out.println("Target is already used, use another card or target to another position!\n");
                        else
                            System.out.println("Uno problemo senorito\n");
                    }

                    else if(playActionCard instanceof DuckMovement){
                        System.out.println("You picked 'Duck Movement'\n");
                        ((DuckMovement) playActionCard).StartDuckMovement(pondCardsShuffledIterator);
                    }

                    else if(playActionCard instanceof Turbo){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Pick duck to change position!\n");
                        int positionToTarget = Integer.parseInt(scanner.nextLine());
                        ((Turbo) playActionCard).StartTurbo(positionToTarget,board.getPondCards());
                    }

                    else if(playActionCard instanceof Roschambo){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You picked Roschambo!\n");
                        ((Roschambo) playActionCard).StartRoschambo(board.getPondCards());
                    }

                    else if(playActionCard instanceof DuckDance){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You picked Duck Dance!\n");
                        ((DuckDance) playActionCard).StartDuckDance(board.getPondCards(), pondCard);
                    }






                    TimeUnit.SECONDS.sleep(2);

                    int dalsiHrac = i+2;
                    if(dalsiHrac > playersAmount)
                        dalsiHrac = 1;
                    System.out.println("---PLAYER '" + dalsiHrac + "' get ready!---\n");


                    TimeUnit.SECONDS.sleep(2);

                }



            }
        } catch(IllegalStateException | NoSuchElementException e) {
            // System.in has been closed
            System.out.println("System.in was closed; exiting with exception: " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




/*

        System.out.println("\n\n\n");

        //Zamierime na tretie policko
        board.addActionCardToBoardSlot(new Target(), 2);
        board.printCards();

        System.out.println("\n\n\n");

        // Strielame
        Shoot shoot = new Shoot();
        if(shoot.Fire(2, board.getCardsOnBoard(), pondCardsShuffledIterator, player, mutableActionCardsShuffledIterator)) //Vkladame mutableActionCardsShuffledIterator (a nie jednoduchy array)
            System.out.println("Kacka je mrtva\n");
        else
            System.out.println("Nemame na co strielat\n");

        board.printCards();


*/

































        


















    }
}
