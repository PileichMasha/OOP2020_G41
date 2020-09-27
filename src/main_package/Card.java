package main_package;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {
    private Rank rank;
    private Suit suit;   //масть

    private final static Map<String, Card> CARD_CACHE = initCache();

    private  static Map<String, Card> initCache() {
        Map<String, Card> cache = new HashMap<>();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()) {
                cache.put(cardKey(rank,suit), new Card(rank, suit));
            }
        }
        return Collections.unmodifiableMap(cache)/*cache*/;
    }

    private static String cardKey(Rank rank, Suit suit) {
        return rank + " of " + suit;
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
