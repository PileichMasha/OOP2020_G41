package main_package;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{
    private Rank rank;
    private Suit suit;   //масть

    private static Map<String, Card> CARD_CACHE = initCache();

    private  static Map<String, Card> initCache() {
        Map<String, Card> cache = new HashMap<>();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()) {
                cache.put(cardKey(rank,suit), new Card(rank, suit));
            }
        }
        return cache;
    }

    private static String cardKey(Rank rank, Suit suit) {
        return rank + " of " + suit;
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card getCard(Rank rank, Suit suit) {
        return CARD_CACHE.get(cardKey(rank, suit));
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    @Override
    public int compareTo(Card o) {
        if (this.rank.getValue() > o.rank.getValue())
            return 1;
        else if (this.rank.getValue() < o.rank.getValue())
            return -1;
        else return 0;
    }
}
