import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    public GameBoard() {
        setLayout(new GridLayout(10, 10));
        for (int y = 0; y <= Settings.MAX_Y; y++) {
            for (int x = 0; x <= Settings.MAX_X; x++){
                ShipCell cell = (new ShipCell(new Coordinate(x, y)));
                add(cell);
            }
        }
    }
}