package kurs2.oop.task1.service.combine;

import kurs2.oop.task1.model.Card;
import kurs2.oop.task1.model.Hand;
import kurs2.oop.task1.model.Rank;
import kurs2.oop.task1.service.CombinationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairService implements CombinationChecker {
    @Override
    public boolean isCombination(Hand hand, List<Card> table) {
        HashMap<Rank, Integer> ranks = CombinationService.countRanks(hand, table);
        int i = 0;   //количество пар
        for (HashMap.Entry<Rank, Integer> entry : ranks.entrySet()) {
            //Rank key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 2) {
                i++;
            }
            if (i == 2)
                return true;
        }
        return false;
    }
}
