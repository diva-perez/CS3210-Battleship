import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerPanel extends JPanel {
    private MainWindow frame;
    private JButton submit;
    private String player;
    //public CellState player1Ship;
    //public CellState player2Ship;



    public PlayerPanel(String player) {
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
        GameBoard board = new GameBoard();
        boardPanel.add(board);
        boardPanel.setOpaque(false);
        add(boardPanel, BorderLayout.CENTER);

        // submit button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 40));
        submit.addMouseListener(new ConfirmMouseListener());
        buttonPanel.add(submit);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    private class ConfirmMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel caller = null;
            if (e.getSource() instanceof JPanel) caller = (JPanel) e.getSource();
            frame.wait(caller, player);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            submit.setOpaque(true);
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            submit.setOpaque(false);
            repaint();
        }
    }
}
