package main_package;

import java.util.*;

public class Deck {
    private Stack<Card> deckCards;  //поменять на arraylist ?

    public Deck() {
        this.deckCards = createDeck();
    }

    public Stack<Card> createDeck() {
        Stack<Card> deckCards = new Stack<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deckCards.push(new Card(rank, suit));
            }
        }
        //Collections.shuffle(deckCards);
        //Collections.sort(deckCards);
        return deckCards;
    }

    public Card getCard() {
        return deckCards.pop();
    }

    public Card drawFromDeck() {
        return deckCards.remove(0);
    }
}
