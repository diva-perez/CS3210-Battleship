

public class ShipCell{
    public ShipCellState state;
    public Coordinate coordinates;

    public ShipCell(Coordinate coordinate) {
        this.coordinates = coordinate;
        this.state = ShipCellState.PLACED;
    }

    public String toString() {
        return this.state + " " + this.coordinates;
    }

    public boolean isHit() {
        return this.state == ShipCellState.HIT;
    }

    public void takeHit() {
        this.state = ShipCellState.HIT;
    }

    public boolean isHidden() {
        return this.state == ShipCellState.HIDDEN;
    }

    public void hide() {
        this.state = ShipCellState.HIDDEN;
    }

    public enum ShipCellState {
        PLACED,
        HIDDEN,
        HIT
    }

}