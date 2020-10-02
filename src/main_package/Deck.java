package main_package;

import java.util.*;

public class Deck {
    private ArrayList<Card> deckCards;  //поменять на arraylist ?

    public Deck() {
        this.deckCards = createDeck();
    }

    public ArrayList<Card> createDeck() {
        ArrayList<Card> deckCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deckCards.add(new Card(rank, suit));
            }
        }
        //Collections.shuffle(deckCards);
        //Collections.sort(deckCards);
        return deckCards;
    }

    /*public Card getCard() {
        return deckCards.get(0);
    }*/

    public int size() {
        return this.deckCards.size();
    }

    public Card drawFromDeck() {
        return deckCards.remove(0);
    }
}
