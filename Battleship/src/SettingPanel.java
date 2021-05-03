import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingPanel extends JPanel {
    public MainWindow frame;
    public JButton confirm;

    public SettingPanel(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("SETTINGS", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);

        // setting options
        JPanel options = new JPanel();
        options.setLayout(new FlowLayout());
        options.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        options.setOpaque(false);

        // Default Battleship

        // Custom Ship Number

        // Custom Ship Length

        // Custom Bomb Size

        // Confirm Button
        confirm = new JButton("Back");
        confirm.setFont(new Font("Arial", Font.PLAIN, 40));
        confirm.addMouseListener(new SettingPanel.ConfirmMouseListener());
        confirm.addMouseListener(new ConfirmMouseListener());
        options.add(confirm);
        add(BorderLayout.SOUTH, options);

        add(BorderLayout.CENTER, options);
    }

    private class ConfirmMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.mainMenu();
            //Settings.settings();
            setVisible(false);
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

