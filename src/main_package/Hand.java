package main_package;

import java.util.Arrays;

public class Hand {
    private Card[] cards;
    private int[] ranksInHand;
    private int[] suitsInHand;

    public Hand(Deck deck) {
        this.cards = new Card[5];
        this.ranksInHand = new int[15];  //[0], [1] пустые
        this.suitsInHand = new int[4];

        for (int i = 0; i < 5; i++) {
            cards[i] = deck.drawFromDeck();  //раздача карт
        }
        countRanks();
    }

    private void countRanks() {
        for (int i = 0; i <= 14 ; i++) {
            ranksInHand[i] = 0;
        }
        for (int i = 0; i <= 4; i++) {
            ranksInHand[cards[i].getRank()]++;
        }
    }
    
    public boolean isFlush() {   //проверка на флеш
        boolean flush = true;
        for (int i = 0; i < 4; i++) {
            if (cards[i].getSuit() != cards[i + 1].getSuit()) {
                flush = false;
                break;
            }
        }
        return flush;
    }

    public boolean isStraight() {  //проверка на стрит
        Arrays.sort(cards);
        if (cards[cards.length - 1].getRank() - cards[0].getRank() == 4)
            return true;
        else return false;
    }

    public void checkRanks() {
        int maxRep = 1; int minRep = 1;  //кол-во повторений
        int maxPos = -1; int minPos;     //ранг, который повторяется
        for (int i = 2; i < 15; i++) {
            if (ranksInHand[i] != 0) {
                if (ranksInHand[i] == maxRep) {  //не учитывает два одинаковых следующих друг за другом ранга
                    maxPos = i;
                } else if (ranksInHand[i] > maxRep) {
                    minRep = maxRep; minPos = maxPos;
                    maxRep = ranksInHand[i]; maxPos = i;
                }
            }
        }

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

    /*public void findSameRanks() {
        int sameRank1 = 1;        //кол-во повторяющихся карт
        int sameRank2 = 1;
        int smallRankPos = 0; int bigRankPos = 0;     //карты какого ранга повторились
        for (int i = 14; i >= 2 ; i--) {
            if (ranksInHand[i] > sameRank1) {
                //sameRank1 = ranksInHand[i];
                if (sameRank1 != 1) {
                    sameRank2 = sameRank1;
                    smallRankPos = bigRankPos;
                    //sameRank1 = ranksInHand[i];
                }
                sameRank1 = ranksInHand[i];
                bigRankPos = i;
            } else if (ranksInHand[i] > sameRank2) {
                sameRank2 = ranksInHand[i];
                smallRankPos = i;
            }
        }
    }*/
}
