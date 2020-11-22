package kurs2.oop.task1.service;

import kurs2.oop.task1.model.Card;
import kurs2.oop.task1.model.Hand;
import kurs2.oop.task1.model.Rank;
import kurs2.oop.task1.model.Suit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationService {

    public static HashMap<Rank, Integer> countRanks(Hand hand, List<Card> table) {
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(hand.getOwnCards());
        allCards.addAll(table);

        HashMap<Rank, Integer> map = new HashMap<>();
        for (Card c : allCards) {
            if (!map.containsKey(c.getRank())) {
                map.put(c.getRank(), 1);
            } else {
                map.put(c.getRank(), map.get(c.getRank()) + 1);
            }
        }
        return map;
    }

    public static HashMap<Suit, Integer> countSuits(Hand hand, List<Card> table) {
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(hand.getOwnCards());
        allCards.addAll(table);

        HashMap<Suit, Integer> map = new HashMap<>();
        for (Card c : allCards) {
            if (!map.containsKey(c.getSuit())) {
                map.put(c.getSuit(), 1);
            } else {
                map.put(c.getSuit(), map.get(c.getSuit()) + 1);
            }
        }
        return map;
    }

}
