package com.niklas.dev;

public class TestClass {
    public static void main(String[] args) {
        /*Player p1 = new Player("Nik");
        CardDeck player1Deck = new CardDeck();
        player1Deck.mixCards();
        player1Deck.fillCardStack();
        p1.setDeck(player1Deck);
        System.out.println(p1.toString());
        p1.drawCard();
        System.out.println(p1.toString());*/

        int rankValue = Rank.FIVE.ordinal();
        Card card = new Card(Rank.ACE,Suit.SPADE);
        System.out.println(card.getRank().ordinal());
        if(rankValue<card.getRank().ordinal()){
            System.out.println("rank is smaller");
        }
    }
}
