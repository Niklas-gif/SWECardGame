package com.niklas.dev;

import java.util.Arrays;
import java.util.Random;

public class Card {
    private Rank rank;
    private Suit suit;
    private final int maxCards = 52;

    public Card(Rank rank,Suit suit){
        this.rank=rank;
        this.suit=suit;
    }


    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }


    public int getMaxCards() {
        return maxCards;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank: " + rank +
                ", suit: " + suit +
                '}';
    }
}
