import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        setFocusable(true);
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("BATTLE", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);

    }

    /**
     * 5 game phases
     */
    private enum GamePhase {
        PLAYER1_PLACE_SHIP, PLAYER2_PLACE_SHIP, PLAYER1_BATTLE, PLAYER2_BATTLE, GAME_OVER
    }
}
