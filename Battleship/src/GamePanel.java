import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(MainWindow frame) {
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
        JLabel subtitle = new JLabel("Player X", SwingConstants.CENTER);
        subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        subtitle.setFont(new Font("Lucida Bright", Font.BOLD, 35));
        subtitle.setAlignmentX(CENTER_ALIGNMENT);
        titlePanel.add(title);
        titlePanel.add(subtitle);
        add(titlePanel, BorderLayout.NORTH);

        // Deciding which GameBoard to display
        if(MainWindow.getPhase() == MainWindow.GamePhase.PLAYER1_BATTLE){
            System.out.println("Player 1 Battle phase");
            // display player 2 GameBoard
            JPanel boardPanel = new JPanel();
            GameBoard board = MainWindow.getPlayer2Board();
            boardPanel.add(board);
            boardPanel.setOpaque(false);
            add(boardPanel, BorderLayout.CENTER);

        } else if (MainWindow.getPhase() == MainWindow.GamePhase.PLAYER2_BATTLE){
            System.out.println("Player 2 Battle phase");
            // display player 1 GameBoard
            JPanel boardPanel = new JPanel();
            GameBoard board = MainWindow.getPlayer1Board();
            boardPanel.add(board);
            boardPanel.setOpaque(false);
            add(boardPanel, BorderLayout.CENTER);
        }
        // player board
        // if statement : display enemy board
        //setPhase() for player turns
    }
}
