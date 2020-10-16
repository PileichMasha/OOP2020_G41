package main_package;

public class Player implements Comparable<Player> {
    private Hand hand;
    private int money;
    private String name;
    private boolean dealer;
    private boolean isInGame;



    public Player(Hand hand, int money, String name) {
        this.hand = hand;
        this.money = money;
        this.name = name;
        this.dealer = false;
        this.isInGame = true;
    }

    public int evaluate() {
        return hand.totalCheck().getValue();
    }

    public void bet(int sum) {
        if (sum <= this.money && this.evaluate() != 0)
            this.money -= sum;
    }

    public void fold() {
        this.isInGame = false;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Player o) {
        if (this.getHand().totalCheck().getValue() > o.getHand().totalCheck().getValue())
            return 1;
        else if (this.getHand().totalCheck().getValue() < o.getHand().totalCheck().getValue())
            return -1;
        else return 0;
    }
}
