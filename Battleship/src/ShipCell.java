import java.awt.*;

public class ShipCell extends Cell{
    public ShipCellState state;
    public Coordinate coordinates;

    public ShipCell(Coordinate coordinate) {
        super(coordinate);
        this.state = ShipCellState.PLACED;
        setBackground(Color.GRAY);

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