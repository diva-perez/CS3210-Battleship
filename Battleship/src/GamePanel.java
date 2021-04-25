import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private MainWindow frame;
    private String player;
    public GamePanel(String player, MainWindow frame) {
        this.frame = frame;
        // this.player = player;
        setFocusable(true);
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("BATTLE", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel subtitle = new JLabel(player, SwingConstants.CENTER);
        subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        subtitle.setFont(new Font("Lucida Bright", Font.BOLD, 35));
        subtitle.setAlignmentX(CENTER_ALIGNMENT);
        titlePanel.add(title);
        titlePanel.add(subtitle);
        add(titlePanel, BorderLayout.NORTH);

    }


    /**
     * 5 game phases
     */
    private enum GamePhase {
        PLAYER1_PLACE_SHIP, PLAYER2_PLACE_SHIP, PLAYER1_BATTLE, PLAYER2_BATTLE, GAME_OVER
    }
}
