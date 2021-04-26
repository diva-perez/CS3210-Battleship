import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerPanel extends JPanel {
    private MainWindow frame;
    private JButton submit;
    private JButton battle;
    private String player;
    private JPanel player1Panel;
    private JPanel player2Panel;
    public GamePanel.GamePhase currentPhase = GamePanel.GamePhase.PLAYER1_PLACE_SHIP;
    //public GameBoard player1Board;
    //public GameBoard player2Board;



    public PlayerPanel(String player, MainWindow frame) {
        this.frame = frame;
        this.player = player;
        setFocusable(true);
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(player, SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel subtitle = new JLabel("Place your Ship", SwingConstants.CENTER);
        subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        subtitle.setFont(new Font("Lucida Bright", Font.BOLD, 35));
        subtitle.setAlignmentX(CENTER_ALIGNMENT);
        titlePanel.add(title);
        titlePanel.add(subtitle);
        add(titlePanel, BorderLayout.NORTH);

        // board
        JPanel boardPanel = new JPanel();
        GameBoard board = new GameBoard(currentPhase);
        boardPanel.add(board);
        boardPanel.setOpaque(false);
        add(boardPanel, BorderLayout.CENTER);

        // submit button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        if (player == "PLAYER 1") {
            player1Panel = this;
            // submit button
            submit = new JButton("Submit");
            submit.setFont(new Font("Arial", Font.PLAIN, 40));
            submit.addMouseListener(new ConfirmMouseListener());
            buttonPanel.add(submit);
            add(buttonPanel, BorderLayout.SOUTH);
            currentPhase = GamePanel.GamePhase.PLAYER2_PLACE_SHIP;
        } else {
            player2Panel = this;
            // battle button
            battle = new JButton("Submit");
            battle.setFont(new Font("Arial", Font.PLAIN, 40));
            battle.addMouseListener(new ConfirmMouseListener());
            buttonPanel.add(battle);
            add(buttonPanel, BorderLayout.SOUTH);
            currentPhase = GamePanel.GamePhase.PLAYER1_BATTLE;
        }
    }


    private class ConfirmMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel caller = null;
            if (e.getSource() == submit) {
                caller = player1Panel;
                player = "PLAYER 2";
                frame.wait(caller, player);
            }
            if (e.getSource() == battle) {
                caller = player2Panel;
                player = "PLAYER 1";
                frame.startBattle();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == submit) {
                submit.setOpaque(true);
            }
            if (e.getSource() == battle) {
                battle.setOpaque(true);
            }
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == submit) {
                submit.setOpaque(false);
            }
            if (e.getSource() == battle) {
                battle.setOpaque(false);
            }
            repaint();
        }
    }
}
