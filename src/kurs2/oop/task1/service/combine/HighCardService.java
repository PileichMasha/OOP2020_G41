package kurs2.oop.task1.service.combine;

import kurs2.oop.task1.model.Card;
import kurs2.oop.task1.model.Hand;
import kurs2.oop.task1.model.Rank;
import kurs2.oop.task1.service.CombinationService;

import java.util.HashMap;
import java.util.List;

public class HighCardService implements CombinationChecker {
    @Override
    public boolean isCombination(Hand hand, List<Card> table) {
        HashMap<Rank, Integer> ranks = CombinationService.countRanks(hand, table);
        if (ranks.containsValue(1))
            return true;
        else
            return false;
    }
}
