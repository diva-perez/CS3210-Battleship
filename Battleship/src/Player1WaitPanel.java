import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Player1WaitPanel extends JPanel {
    private MainWindow frame;
    private JPanel wait;

    public Player1WaitPanel(MainWindow frame) {
        this.frame = frame;

        wait = new JPanel();
        wait.setLayout(new BorderLayout());
        JLabel title = new JLabel("PLAYER 1", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(200, 0, 10, 0));
        JLabel card = new JLabel("Click anywhere to begin", SwingConstants.CENTER);
        card.setFont(new Font("Lucida Bright", Font.BOLD, 70));
        card.setBorder(BorderFactory.createEmptyBorder());
        wait.add(BorderLayout.NORTH, title);
        wait.add(BorderLayout.CENTER, card);
        add(wait);

        addMouseListener(new StartMouseListener());

    }

    private class StartMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.player1Place();
        }
    }
}

