import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EndPanel extends JPanel {
    private final MainWindow frame;
    private final JButton menu;

    public EndPanel(Game game, MainWindow frame) {
        this.frame = frame;
        Player winner = game.winner;
        setOpaque(false);
        setLayout(new BorderLayout());

        // winner announcement
        JLabel title = new JLabel("CONGRATULATIONS", SwingConstants.CENTER);
        title.setFont(VisualFormatting.headings1);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(BorderLayout.NORTH, title);
        JLabel subtitle = new JLabel(winner + " wins!", SwingConstants.CENTER);
        subtitle.setFont(new Font("Serif", Font.PLAIN, 75));
        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 400, 0));
        add(BorderLayout.CENTER, subtitle);

        // menu button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        buttonPanel.setOpaque(false);
        menu = new JButton("Back");
        menu.setFont(VisualFormatting.buttons);
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
