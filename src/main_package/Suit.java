package main_package;

public enum Suit {
    DIAMONDS("Diamonds", 1),  //бубны
    CLUBS("Clubs", 2),        //крестье
    HEARTS("Hearts", 3),      //червы
    SPADES("Spades", 4);      //пики

    private String name;
    private int value;

    private Suit(String name, int value) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return value;
    }
}

