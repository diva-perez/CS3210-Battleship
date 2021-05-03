import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlacementPanel extends JPanel {
    private MainWindow frame;
    private JButton confirm;

    public PlacementPanel(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel(MainWindow.game.getCurrent().toString(), SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setOpaque(false);

        // confirm button
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Arial", Font.PLAIN, 40));
        confirm.addMouseListener(new PlacementPanel.ConfirmMouseListener());
        confirm.addMouseListener(new PlacementPanel.ConfirmMouseListener());
        southPanel.add(confirm);
        add(BorderLayout.SOUTH, southPanel);
    }

    private class ConfirmMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.endTurn();
            repaint();
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            confirm.setOpaque(true);
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            confirm.setOpaque(false);
            repaint();
        }
    }
}
