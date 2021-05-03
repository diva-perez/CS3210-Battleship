import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WaitPanel extends JPanel {
    private MainWindow frame;
    private JPanel wait;
    public MainWindow.GamePhase currentPhase;

    /**
     *  waiting screen that will display the current players turn and wait for a mouse click to continue
     * @param frame
     */
    public WaitPanel(MainWindow frame) {
        this.frame = frame;
        wait = new JPanel();
        wait.setLayout(new BorderLayout());
        JLabel title = new JLabel("PLAYER X", SwingConstants.CENTER);
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
            if (MainWindow.getPhase() == MainWindow.GamePhase.PLAYER1_BATTLE) {
                System.out.println("Start battling");
                //battle
                //display enemy board

            } else {
                System.out.println("Place ships");
                frame.place();
            }

        }
    }
}

