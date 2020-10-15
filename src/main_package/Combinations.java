package main_package;

public enum Combinations {
    ROYAL_FLUSH(9, "Royal_Flush"),
    STRAIGHT_FLUSH(8, "Straight_Flush"),
    FOUR_OF_A_KIND(7, "Four_of_a_kind"),
    FULL_HOUSE(6, "Full_House"),
    FLUSH(5, "Flush"),
    STRAIGHT(4, "Straight"),
    SET(3, "Set"),
    TWO_PAIR(2, "Two_Pair"),
    PAIR(1, "Pair");

    private int value;
    private String name;

    Combinations(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
