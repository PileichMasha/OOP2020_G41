package main_package;

import java.util.Arrays;

public class Hand implements Comparable<Hand>{
    private Card[] cards;
    private int[] ranksInHand;
    private int[] suitsInHand;

    public Hand(Deck deck, Card[] tableCards) {
        Card[] ownCards = new Card[2];
        this.ranksInHand = new int[15];  //[0], [1] пустые
        this.suitsInHand = new int[4];

        for (int i = 0; i < 5; i++) {
            ownCards[i] = deck.drawFromDeck();  //раздача карт
        }
        this.cards = concatenate(ownCards, tableCards);
        countRanks();
        countSuits();
    }

    public Hand(Card[] ownCards, Card[] tableCards) {
        this.cards = concatenate(ownCards, tableCards);
        this.ranksInHand = new int[15];
        this.suitsInHand = new int[4];

        countRanks();
        countSuits();
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    private Card[] concatenate(Card[] ownCards, Card[] tableCards) {
        Card[] cards = new Card[7];
        int i = 0;
        for (Card card : ownCards) {
            cards[i] = card;
            i++;
        }
        for (Card card : tableCards) {
            cards[i] = card;
            i++;
        }
        return cards;
    }

    private void countRanks() {
        for (int i = 0; i <= 14 ; i++) {
            ranksInHand[i] = 0;
        }
        for (int i = 0; i <= 6; i++) {
            ranksInHand[cards[i].getRank()]++;
        }
    }

    private void countSuits() {
        for (int i = 0; i <= 3; i++) {
            suitsInHand[i] = 0;
        }
        for (int i = 0; i <= 6; i++) {
            suitsInHand[cards[i].getSuit().getValue() - 1]++;
        }
    }
    
    private boolean isFlush() {   //проверка на флеш
        boolean flush = false;
        for (int i = 0; i <= 3; i++) {
            if (suitsInHand[i] == 5) {
                flush = true;
                break;
            }
        }
        return flush;
    }

    private boolean isStraight() {  //проверка на стрит
        Arrays.sort(cards);                 //7 поз - 3 поз, 6 - 2, 5 - 1
        int pos1 = cards.length - 3;
        for (int i = 0; i <= 2; i++) {
            if (cards[pos1].getRank() - cards[i].getRank() == 4)
                return true;
            else
                pos1++;
        }
        return false;
    }

    private Result checkRanks() {
        int maxRep = 0; int minRep = 0;  //кол-во повторений
        int maxPos = -1; int minPos = -1;     //ранг, который повторяется
        for (int i = 2; i < 15; i++) {
            if (ranksInHand[i] != 0) {
                if (ranksInHand[i] >= maxRep) {
                    minRep = maxRep; minPos = maxPos;
                    maxRep = ranksInHand[i]; maxPos = i;
                }
            }
        }
        Result.Position max = new Result.Position(maxRep, maxPos);
        Result.Position min = new Result.Position(minRep, minPos);
        return new Result(max, min);
    }

    public Combinations totalCheck() {
        Result res = checkRanks();
        if (isFlush() && isStraight())
            return Combinations.STRAIGHT_FLUSH;
        else if (res.getMax().getRep() == 4)
            return Combinations.FOUR_OF_A_KIND;
        else if (res.getMax().getRep() == 3 && res.getMin().getRep() == 2)
            return Combinations.FULL_HOUSE;
        else if (isFlush())
            return Combinations.FLUSH;
        else if (isStraight())
            return Combinations.STRAIGHT;
        else if (res.getMax().getRep() == 3 && res.getMin().getRep() != 2)
            return Combinations.SET;
        else if (res.getMax().getRep() == 2 && res.getMin().getRep() == 2)
            return Combinations.TWO_PAIR;
        else if (res.getMax().getRep() == 2 && res.getMin().getRep() != 0)
            return Combinations.PAIR;
        return Combinations.NOTHING;
    }

    public Card[] getCards() {
        return cards;
    }

    public int[] getSuitsInHand() {
        return suitsInHand;
    }

    public int[] getRanksInHand() {
        return ranksInHand;
    }

    @Override
    public int compareTo(Hand o) {
        if (this.totalCheck().getValue() > o.totalCheck().getValue())
            return 1;
        else if (this.totalCheck().getValue() < o.totalCheck().getValue())
            return -1;
        else return 0;
    }
}
