package com.niklas.dev;

import java.util.Random;
import java.util.Stack;

public class CardDeck {
    private Stack<Card> cardStack;
    private Card[] cardDeck = getAllCards();
    private final int maxCards =52;

    public CardDeck(){
        cardStack = new Stack<>();
    }

    public Card[] getCardDeck() {
        return cardDeck;
    }

    public Stack<Card> getCardStack(){
        return cardStack;
    }

    public Card getTopCard() {
        return cardStack.peek();
    }

    public Card[] getAllCards(){
        Card[] cardDeck = new Card[maxCards];
        int j = 0;
        for(Suit s : Suit.values()){
            for(Rank r : Rank.values()){
                cardDeck[j] = new Card(r,s);
                j++;
            }
        }
        return cardDeck;
    }

    public Stack<Card> fillCardStack(){
        cardStack = new Stack<>();
        for(int i=0;i<maxCards;i++){
           cardStack.add(cardDeck[i]);
        }
        return cardStack;
    }

    public Stack<Card> fillCardStack(Stack<Card> cardStack){
        for(int i=0;i<maxCards;i++){
            cardStack.add(cardDeck[i]);
        }
        return cardStack;
    }

  public void mixCards(){
       Random random = new Random();
       for(int i=0;i<cardDeck.length;i++){
           int indexToChange = random.nextInt(cardDeck.length);
           Card temp = cardDeck[indexToChange];
           cardDeck[indexToChange] = cardDeck[i];
           cardDeck[i] = temp;
       }

  }

    public void push(Card card){
        cardStack.push(card);

    }

    public Stack<Card> pop(){
        cardStack.pop();
        return cardStack;
    }

    public boolean empty(){
        return cardStack.empty();
    }

    public int getDeckCount(){
     return cardStack.size();
    }


}
