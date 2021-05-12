import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.InputMismatchException;

public class SettingPanel extends JPanel {
    public MainWindow frame;
    public JButton confirm;
    public JToggleButton bombToggle;
    public JToggleButton vsToggle;

    public SettingPanel(MainWindow frame) {
        this.frame = frame;
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

        // Custom Ship Number
        JPanel option1 = new JPanel();
        JLabel numLabel = new JLabel("Enter the number of ships: ");
        numLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option1.add(numLabel);
        JTextField numField = new JTextField(5);
        option1.add(numField);
        center.add(option1);

        // Custom Ship Length
        JPanel option2 = new JPanel();
        JLabel lengthLabel = new JLabel("Enter the length of the ships: ");
        lengthLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option2.add(lengthLabel);
        JTextField lengthField = new JTextField(5);
        option2.add(lengthField);
        center.add(option2);

        // Custom Bomb Size
        JPanel option3 = new JPanel();
        JLabel bombLabel = new JLabel("Use bigger bombs: ");
        bombLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option3.add(bombLabel);
        bombToggle = new JToggleButton("OFF");
        bombToggle.addItemListener(e -> {
            if (bombToggle.isSelected())
                bombToggle.setText("ON");
            else
                bombToggle.setText("OFF");
        });
        option3.add(bombToggle);
        center.add(option3);

        // Vs Computer
        JPanel option4 = new JPanel();
        JLabel vsLabel = new JLabel("Play against the computer: ");
        vsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option4.add(vsLabel);
        vsToggle = new JToggleButton("OFF");
        vsToggle.addItemListener(e -> {
            if (vsToggle.isSelected()) {
                vsToggle.setText("ON");
            } else {
                vsToggle.setText("OFF");
            }
        });
        option4.add(vsToggle);
        center.add(option4);

        // Confirm Button
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Arial", Font.PLAIN, 40));
        // store input from user when confirm button is pressed
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final String inputNumShips = numField.getText();
                final String inputLength = lengthField.getText();
                final boolean bombSize = bombToggle.isSelected();
                final boolean vsComputer = vsToggle.isSelected();
                try {
                    int intNumShips = Integer.parseInt(inputNumShips);  // cannot be larger than 5
                    int intLength = Integer.parseInt(inputLength);      // cannot be larger than 10
                    System.out.println(intNumShips + ", " + intLength + ", Bigger bomb size: " + bombSize + ", Play against computer: " + vsComputer);
                    MainWindow.settings = new Settings(intNumShips, intLength, bombSize, vsComputer);
                    System.out.println(MainWindow.settings.getShipList());
                } catch (NumberFormatException exception) {
                    System.out.println("No integer found in string");
                    MainWindow.settings = new Settings (bombSize, vsComputer);
                }
                frame.mainMenu();
                setVisible(false);
            }
        });
        JPanel south = new JPanel();
        south.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        south.add(confirm);

        add(BorderLayout.SOUTH, south);
        add(BorderLayout.CENTER, center);
    }
}

/*    private class ConfirmMouseListener extends MouseAdapter {
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
}*/