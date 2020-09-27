package main_package;

public enum Suit {
    DIAMONDS("Diamonds"),  //бубны
    CLUBS("Clubs"),        //крестье
    HEARTS("Hearts"),      //червы
    SPADES("Spades");      //пики

    private String val;

    private Suit(String value) {
        this.val = value;
    }

    public String getVal() {
        return val;
    }
}

