package kurs2.oop.task1;

import kurs2.oop.task1.model.*;
import kurs2.oop.task1.service.combine.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerGame {
    Deck deck;
    PlayerList players;
    int playersCount;

    public PokerGame(Deck deck, int playersCount) {
        this.deck = deck;
        this.playersCount = playersCount;
    }

    private Map<Combination, CombinationChecker> serviceMap = initMap();
    // playerMap<Player, PlayerState> ??

    public void play() {

    }

    public Combination getCombination(Hand hand, List<Card> tableCard) {
        for (Map.Entry<Combination, CombinationChecker> entry : serviceMap.entrySet()) {
            Combination comb = entry.getKey();
            CombinationChecker checker = entry.getValue();
            if (checker.isCombination(hand, tableCard)) {
                return comb;
            }
        }
        return null;
    }

    private Map<Combination,CombinationChecker> initMap() {
        Map<Combination,CombinationChecker> map = new HashMap<>();
        map.put(Combination.ROYAL_FLUSH, new RoyalFlushService());
        map.put(Combination.STRAIGHT_FLUSH, new StraightFlushService());
        map.put(Combination.FOUR_OF_A_KIND, new FourOfAKindService());
        map.put(Combination.FULL_HOUSE, new FullHouseService());
        map.put(Combination.FLUSH, new FlushService());
        map.put(Combination.STRAIGHT, new StraightService());
        map.put(Combination.SET, new SetService());
        map.put(Combination.TWO_PAIR, new TwoPairService());
        map.put(Combination.PAIR, new PairService());
        map.put(Combination.HIGH_CARD, new HighCardService());
        return map;
    }
}
