package main_package;

import java.util.Set;

public class Hand {
    private Card[] cards;
    private int[] ranksInHand;
    private int[] suitsInHand;

    public Hand(Deck deck) {
        this.cards = new Card[5];
        this.ranksInHand = new int[14];  //оставить [0] пустым
        this.suitsInHand = new int[4];

        for (int i = 0; i < 5; i++) {
            cards[i] = deck.drawFromDeck();  //раздача карт
        }
        ranksInHand = this.countRanks();  //будет работать ?
    }

    private int[] countRanks() {             //или void ?
        for (int i = 0; i <= 13 ; i++) {
            ranksInHand[i] = 0;
        }
        for (int i = 0; i <= 4; i++) {
            ranksInHand[cards[i].getRank()]++;
        }
        return ranksInHand;
    }

    public void findSameRanks() {
        int sameCards = 1;        //ищем ранг, повторившийся наибольшее кол-во раз
        int rank = -1;
        for (int i = 13; i >= 1 ; i--) {
            if (ranksInHand[i] > sameCards) {
                sameCards = ranksInHand[i];
                rank = i;                     //карты какого ранга повторились
            }
        }
    }


}
