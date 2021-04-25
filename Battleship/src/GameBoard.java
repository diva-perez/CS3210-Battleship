import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    public int row;
    public int column;

    public void Board() {
        row = 10;
        column = 10;
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(row, column));
        for (int i = 0; i < 100; i++) {
            board.add(new Cell("b" + (i + 1)));
        }
    }
}
