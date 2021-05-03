import javax.swing.*;
import java.awt.*;

public class ShipCell extends JButton {
    public ShipCellState state;
    public Coordinate coordinates;

    public ShipCell(Coordinate coordinate) {
        this.coordinates = coordinate;
        this.state = ShipCellState.PLACED;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
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
