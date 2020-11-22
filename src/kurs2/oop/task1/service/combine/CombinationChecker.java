package kurs2.oop.task1.service.combine;

import kurs2.oop.task1.model.Card;
import kurs2.oop.task1.model.Hand;

import java.util.List;

public interface CombinationChecker {
    public boolean isCombination(Hand hand, List<Card> table);
}
