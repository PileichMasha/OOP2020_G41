package kurs2.oop.task1.service.combine;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import kurs2.oop.task1.model.Card;
import kurs2.oop.task1.model.Hand;
import kurs2.oop.task1.model.Rank;
import kurs2.oop.task1.model.Suit;
import kurs2.oop.task1.service.CombinationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RoyalFlushService implements CombinationChecker {
    @Override
    public boolean isCombination(Hand hand, List<Card> table) {   //TODO проверка на старшие ранги
        if (isFlush(hand, table) && isStraight(hand, table))
            return true;
        else
            return false;
    }

    private boolean isStraight(Hand hand, List<Card> table) {
        HashMap<Rank, Integer> ranks = CombinationService.countRanks(hand, table);  //7 поз - 3 поз, 6 - 2, 5 - 1
        List<Rank> ranksList = new ArrayList<>(ranks.keySet());
        Collections.sort(ranksList);
        int pos1 = ranksList.size() - 3;
        for (int i = 0; i <= 2; i++) {
            if (ranksList.get(pos1).getValue() - ranksList.get(i).getValue() == 4)
                return true;
            else
                pos1++;
        }
        return false;
    }

    private boolean isFlush(Hand hand, List<Card> table) {
        HashMap<Suit, Integer> suits = CombinationService.countSuits(hand, table);
        if (suits.containsValue(5))
            return true;
        else
            return false;
    }
}
