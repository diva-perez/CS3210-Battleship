import javax.swing.*;
import java.awt.*;

public class Player1PlacePanel extends JPanel {
    private MainWindow frame;
    private JPanel placement;
    // public CellState player1Ship;

    public Player1PlacePanel() {
        JLabel title = new JLabel("PLAYER 1", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);
        JPanel board = new GameBoard();
        add(BorderLayout.CENTER, board);
        setVisible(false);
    }
}
