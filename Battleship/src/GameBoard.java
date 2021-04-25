import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel{
    public GameBoard() {
        setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
           add(new Cell("b" + (i + 1)));
        }
    }
}
