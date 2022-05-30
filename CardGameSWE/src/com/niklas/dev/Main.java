package com.niklas.dev;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Card c_1 = new Card(Rank.ACE,Suit.CLUBS);
        CardDeck cD_1 = new CardDeck();
        cD_1.mixCards();
        cD_1.fillCardStack();
        System.out.println(cD_1.getDeckCount());
        cD_1.pop();
        System.out.println(cD_1.getDeckCount());
        cD_1.pop();
        cD_1.pop();
        //cD_1.push(new Card(Rank.ACE,Suit.SPADE));
        //cD_1.push(c_1);

        CardDeck cD_2 = new CardDeck();



       //Prints all cards(Array)
        for(int i=0;i<cD_1.getAllCards().length;i++){
            System.out.println("#" + i + " " + cD_1.getCardDeck()[i].toString());
        }

        //Prints card-stack
        Iterator<Card> cStackIterator = cD_1.getCardStack().iterator();
        int i = 0;
        if(!cD_1.empty()) {
            while (cStackIterator.hasNext()) {
                i++;
                System.out.println("#" + i + " cD_1 " + cStackIterator.next());
            }
        }

        Iterator<Card> cStackIterator_2 = cD_2.getCardStack().iterator();
        int j = 0;
        if(!cD_2.empty()) {
            while (cStackIterator.hasNext()) {
                j++;
                System.out.println("#" + j + " cD_2 " + cStackIterator_2.next());
            }
        }
        else{
            System.out.println("Ist leer");
        }

    }

}
