package main_package;

public class PlayerList {
    private  Node first;

    public PlayerList(Player player) {
        this.first = new Node(player, null, null);
        first.next = first;
        first.prev = first;
    }

    public void add(Player player) {
        Node newPlayer = new Node(player, first, first);
        first.prev.next = newPlayer;
        first.prev = newPlayer;
    }

    public void remove() {
        first.prev = first.prev.prev;
        first.prev.prev.next = first;
    }

    private class Node {
    Player player;
    Node next;
    Node prev;

        private Node(Player player, Node next, Node prev) {
            this.player = player;
            this.next = next;
            this.prev = prev;
        }
    }
}
