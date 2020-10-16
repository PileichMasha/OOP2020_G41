package main_package;

public class Result {
    private Position max;
    private Position min;

    public Result(Position max, Position min) {
        this.max = max;
        this.min = min;
    }

    public Position getMax() {
        return max;
    }

    public Position getMin() {
        return min;
    }

    public static class Position {
        private int rep;
        private int pos;

        public Position(int rep, int pos) {
            this.rep = rep;
            this.pos = pos;
        }

        public int getRep() {
            return rep;
        }

        public void setRep(int rep) {
            this.rep = rep;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }
}
