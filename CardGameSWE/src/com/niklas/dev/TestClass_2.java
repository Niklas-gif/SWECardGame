package com.niklas.dev;

public class TestClass_2 {
    public static void main(String[] args) {
        Player p1 = new Player("Nik");
        Player p2 = new Player("Computer");
        CardDeck cardDeck = new CardDeck();
        cardDeck.mixCards();
        cardDeck.fillCardStack();
        Game game = new Game(p1,p2,cardDeck);
        game.startGame();










    }
}
