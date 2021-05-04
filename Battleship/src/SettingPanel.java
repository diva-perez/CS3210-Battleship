import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingPanel extends JPanel {
    public MainWindow frame;
    public JButton confirm;
    public JToggleButton toggle;

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
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(100, 0, 100, 0));
        center.setBackground(new Color(255, 255, 255, 100));

        // Custom Ship Number
        JPanel option1 = new JPanel();
        option1.setOpaque(false);
        JLabel numLabel = new JLabel("Enter the number of ships: ");
        numLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option1.add(numLabel);
        JTextField numField = new JTextField(5);
        option1.add(numField);
        center.add(option1);

        // Custom Ship Length
        JPanel option2 = new JPanel();
        option2.setOpaque(false);
        JLabel lengthLabel = new JLabel("Enter the length of the ships: ");
        lengthLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option2.add(lengthLabel);
        JTextField lengthField = new JTextField(5);
        option2.add(lengthField);
        center.add(option2);

        // Custom Bomb Size
        JPanel option3 = new JPanel();
        option3.setOpaque(false);
        JLabel bombLabel = new JLabel("Use bigger bombs: ");
        bombLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option3.add(bombLabel);
        toggle = new JToggleButton("OFF");
        toggle.addItemListener(e -> {
            if (toggle.isSelected())
                toggle.setText("ON");
            else
                toggle.setText("OFF");
        });
        option3.add(toggle);
        center.add(option3);

        // Confirm Button
        confirm = new JButton("Back");
        confirm.setFont(new Font("Arial", Font.PLAIN, 40));
        confirm.addMouseListener(new SettingPanel.ConfirmMouseListener());
        confirm.addMouseListener(new ConfirmMouseListener());
        JPanel south = new JPanel();
        south.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        south.setOpaque(false);
        south.add(confirm);

        add(BorderLayout.SOUTH, south);
        add(BorderLayout.CENTER, center);
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