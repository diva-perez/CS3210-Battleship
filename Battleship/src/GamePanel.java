import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {
    public int row;
    public int column;

    public GamePanel() {
        // default board size
        row = 10;
        column = 10;

        setFocusable(true);
        setOpaque(true);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // 10 x 10 board
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(row, column));
        for (int i = 0; i < 100; i++) {
            board.add(new Cell("b" + (i + 1)));
        }
        add(board, BorderLayout.CENTER);


    }
}
