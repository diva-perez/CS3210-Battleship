import javax.swing.*;
import java.awt.*;


public class Cell extends JButton {
    private Cell cell;

    public Cell(Coordinate coordinate) {
        cell = this;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
    }
}