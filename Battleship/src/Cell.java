import javax.swing.*;
import java.awt.*;


public class Cell extends JButton {
    private Coordinate coordinate;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
    }

    public Coordinate getCoord() {
        return this.coordinate;
    }
}