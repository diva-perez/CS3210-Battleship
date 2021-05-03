import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerPanel extends JPanel {
    private MainWindow frame;
    private JButton submit;
    private JButton battle;
    private JPanel player1Panel;
    private JPanel player2Panel;
    private GameBoard board;


    public PlayerPanel(MainWindow frame) {
        this.frame = frame;
        setFocusable(true);
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("PLAYER X", SwingConstants.CENTER);
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
        this.board = new GameBoard();
        boardPanel.add(this.board);
        boardPanel.setOpaque(false);
        add(boardPanel, BorderLayout.CENTER);

        // submit button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        /*
        * two buttons to control rotation to the next phase
        * player 1 is always followed by player 2
        * player 2 is always followed by player 1
         */
        if (MainWindow.getPhase() == MainWindow.GamePhase.PLAYER1_PLACE_SHIP) {
            player1Panel = this;
            // submit button
            submit = new JButton("Submit");
            submit.setFont(new Font("Arial", Font.PLAIN, 40));
            submit.addMouseListener(new ConfirmMouseListener());
            buttonPanel.add(submit);
            add(buttonPanel, BorderLayout.SOUTH);
        } else {
            player2Panel = this;
            // battle button
            battle = new JButton("Continue to Battle");
            battle.setFont(new Font("Arial", Font.PLAIN, 40));
            battle.addMouseListener(new ConfirmMouseListener());
            buttonPanel.add(battle);
            add(buttonPanel, BorderLayout.SOUTH);
            MainWindow.setPhase(MainWindow.GamePhase.PLAYER1_BATTLE);
            System.out.println("Player 2 has placed ships");
        }

    }


    private class ConfirmMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel caller = null;
            if (e.getSource() == submit) {
                caller = player1Panel;
                MainWindow.setPhase(MainWindow.GamePhase.PLAYER2_PLACE_SHIP);
                MainWindow.setPlayer1Board(board);
                System.out.println("Player 1 has placed ships");
                frame.wait(caller);
            }else if (e.getSource() == battle) {
                caller = player2Panel;
                MainWindow.setPhase(MainWindow.GamePhase.PLAYER1_BATTLE);
                MainWindow.setPlayer2Board(board);
                System.out.println("Player 2 has placed ships; Battle");
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
