package com.niklas.dev;

public class Game {
    private CardDeck initDeck;
    private CardDeck emptyDeck = new CardDeck();
    private Player player_1;
    private Player player_2;
    private Player currentPlayer;

    public Game(Player player_1,Player player_2,CardDeck initDeck){
        this.player_1=player_1;
        this.player_2=player_2;
        this.initDeck=initDeck;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void switchPlayer(){
        if(this.currentPlayer==player_1){
            currentPlayer = player_2;
        }
        else if(this.currentPlayer==player_2){
            currentPlayer = player_1;
        }
    }

    private boolean roundWon(Player currentPlayer){
        if(!(emptyDeck.empty())&&currentPlayer.getTopCard().getSuit()==emptyDeck.getCardStack().peek().getSuit()){
            System.out.println(currentPlayer.getName() + " has won this round!");
            return true;
        }
        else{
            return false;
        }
    }


    // Nimmt ein übergebenes Kartendeck und teilt es zwischen denn Spielern auf.
    private void splitDeck(){
        CardDeck temp = new CardDeck();
        int forTemp = initDeck.getDeckCount()/2;
        for(int i=0;i<forTemp;i++) {
            temp.getCardStack().push(initDeck.getCardStack().pop());
        }
        player_1.setDeck(initDeck);
        player_2.setDeck(temp);
    }

    public void startGame(){
        boolean gameFinished = false;
        setCurrentPlayer(player_1);
        splitDeck();
        int turnCount = 0;


        while (!gameFinished){
            boolean turnFinished = false;
            turnCount ++;
            System.out.println("(((ROUND:" + turnCount + " STARTET" + ")))\n");
            if(currentPlayer.hasCards()) {
                currentPlayer.drawCard();
                emptyDeck.push(currentPlayer.playCard());
                System.out.println("The current card on the field is: " + emptyDeck.getTopCard());
                switchPlayer();
            }else{
                gameFinished = true;
                turnFinished = true;
                switchPlayer();
                System.out.println("\n" + currentPlayer.getName() + " -----> has won the game! <------");
            }
           while(!turnFinished){
               if(currentPlayer.hasCards()){
                   currentPlayer.drawCard();
                   //Wenn ein Spieler gewonnen hat !
                   if(currentPlayer.getTopCard().getSuit()==emptyDeck.getTopCard().getSuit()){

                       currentPlayer.addCardToWinPile(emptyDeck);
                       //emptyDeck = new CardDeck();
                       System.out.println(currentPlayer.getName() + " has won the round!");
                       System.out.println("\n(((ROUND:" + turnCount + " END" + ")))\n");
                       currentPlayer.setRoundsWon(currentPlayer.getRoundsWon()+1);
                       turnFinished = true;
                   }
                   //Wenn noch keiner gewonnen hat!
                   else {
                       emptyDeck.getCardStack().push(currentPlayer.playCard());
                       System.out.println("The current card on the field is: " +emptyDeck.getTopCard());
                       switchPlayer();
                   }
               }
               else {
                   switchPlayer();
                   System.out.println("\n(((ROUND:" + turnCount + " END" + ")))\n");
                   System.out.println("\n" + currentPlayer.getName() + " -----> has won the game! <------");
                   turnFinished = true;
                   gameFinished = true;
               }
           }
        }
        //Wer hatt die meisten Runden gewonnen
        if(player_1.getRoundsWon()>player_2.getRoundsWon()){
            System.out.println("Player " + player_1.getName() + " has won the game ! Rounds:" + player_1.getRoundsWon());
        }
        else{
            System.out.println("Player " + player_2.getName() + " has won the game ! Rounds:" + player_2.getRoundsWon());
        }
    }
}
