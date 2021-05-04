import javax.swing.*;
import java.awt.*;


public class Cell extends JButton {
    private Cell cell;
    private Coordinate coordinate;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        cell = this;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
    }

    public Cell getCellAt(Coordinate coordinate) {
        return this.cell;
    }

    public Coordinate getCoord() {
        return this.coordinate;
    }

    public void setCellShip(Coordinate coordinate) {
        getCellAt(coordinate).setBackground(Color.GRAY);
    }
}