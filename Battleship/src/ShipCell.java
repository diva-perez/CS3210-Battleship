public class ShipCell{
    public ShipCellState state;
    public Coordinate coordinates;
    public Orientation orientation;

    public ShipCell(Coordinate coordinate, Orientation orientation) {
        this.coordinates = coordinate;
        this.orientation = orientation;
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