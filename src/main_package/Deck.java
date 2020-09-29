package main_package;

import java.util.*;

public class Deck {
    private Stack<Card> deckCards;  //поменять на arraylist ?

    public Deck() {
        this.deckCards = createDeck();
    }

    private Stack<Card> createDeck() {
        Stack<Card> deckCards = new Stack<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deckCards.push(Card.getCard(rank, suit));
            }
        }
        Collections.shuffle(deckCards);
        return deckCards;
    }

    public Card drawFromDeck() {
        return deckCards.remove(0);
    }
}
