package com.niklas.dev;

public class Player {
   private String name;
   private CardDeck playerDeck;
   private CardDeck winPile = new CardDeck();
   private Card topCard;
   private int roundsWon = 0;
    public Player(String name){
        setName(name);
    }

    public void setDeck(CardDeck playerDeck){
        this.playerDeck=playerDeck;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getTopCard(){
        return topCard;
    }

    public void setTopCard(Card topCard){
        this.topCard=topCard;
    }

    public void drawCard(){
        setTopCard(playerDeck.getCardStack().pop());
        System.out.println(getName() + " has draw --> " + topCard.toString() + "cards left:" + getDeckCount() + "\n");
    }

    public Card playCard(){
        System.out.println(getName() + " has played --> " + topCard.toString() + "cards left:" + getDeckCount());
        return topCard;
    }

    public void addCardToWinPile(CardDeck cardDeck){
        while(!cardDeck.getCardStack().empty())
        winPile.getCardStack().push(cardDeck.getCardStack().pop());
    }

    public Boolean hasCards(){
        if(playerDeck.getDeckCount()==0){
            return false;
        }
        else{
            return true;
        }
    }


    public int getDeckCount(){
        return playerDeck.getCardStack().size();
    }


    public String toString(){

        return "Player: " +  getName() + " CardCount: " + playerDeck.getDeckCount() + " TOPCARD: " + getTopCard();
    }

}
