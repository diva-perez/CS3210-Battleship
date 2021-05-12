import java.util.Objects;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean onBoard() {
        /*
         * true if coordinates are on the board
         */
        if (0 <= this.x && this.x < Settings.MAX_X) {
            return 0 <= this.y && this.y < Settings.MAX_Y;
        }
        return false;
    }

    public Coordinate getEndFrom(int length, Orientation orientation) {
        /*
         * used to get the end of a ship from the focus coordinate
         * used when placing a ship on the board
         */
        Coordinate end = new Coordinate (this.x, this.y);
        if (orientation == Orientation.VERTICAL) {
            end.y += length - 1;
        }
        else {
            end.x += length - 1;
        }
        return end;
    }
}