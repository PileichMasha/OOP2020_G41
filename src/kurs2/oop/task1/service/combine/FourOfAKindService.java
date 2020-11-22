package kurs2.oop.task1.service.combine;

import kurs2.oop.task1.model.Card;
import kurs2.oop.task1.model.Hand;
import kurs2.oop.task1.model.Rank;
import kurs2.oop.task1.service.CombinationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FourOfAKindService implements CombinationChecker {
    @Override
    public boolean isCombination(Hand hand, List<Card> table) {
        HashMap<Rank, Integer> ranks = CombinationService.countRanks(hand, table);
        List<Rank> ranksList = new ArrayList<>(ranks.keySet());
        Collections.sort(ranksList);

        if (ranks.containsValue(4))
            return true;
        else
            return false;
    }
}
