import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EndPanel extends JPanel {
    private MainWindow frame;
    private JButton menu;
    private Player winner;
    private Game game;

    public EndPanel(Game game, MainWindow frame) {
        this.frame = frame;
        this.game = game;
        setOpaque(false);
        setLayout(new BorderLayout());
        winner = game.winner;

        // announcement
        JPanel tPanel = new JPanel();
        tPanel.setOpaque(false);
        tPanel.setLayout(new BoxLayout(tPanel, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("CONGRATULATIONS", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        tPanel.add(title);

        JLabel subtitle = new JLabel(winner + "wins!", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.PLAIN, 75));
        tPanel.add(subtitle);

        add(BorderLayout.CENTER, tPanel);

        // menu button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        buttonPanel.setOpaque(false);
        menu = new JButton("Back");
        menu.setFont(new Font("Arial", Font.PLAIN, 40));
        menu.addMouseListener(new MenuMouseListener());
        buttonPanel.add(menu);
        add(BorderLayout.SOUTH, buttonPanel);
    }
    private class MenuMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.mainMenu();
            setVisible(false);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            menu.setOpaque(true);
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            menu.setOpaque(false);
            repaint();
        }
    }
}
