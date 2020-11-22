package kurs2.oop.task1.service.combine;

import kurs2.oop.task1.model.Card;
import kurs2.oop.task1.model.Hand;
import kurs2.oop.task1.model.Suit;
import kurs2.oop.task1.service.CombinationService;

import java.util.HashMap;
import java.util.List;

public class FlushService implements CombinationChecker{

    @Override
    public boolean isCombination(Hand hand, List<Card> table) {
        HashMap<Suit, Integer> suits = CombinationService.countSuits(hand, table);
        if (suits.containsValue(5))
            return true;
        else
            return false;
    }
}
