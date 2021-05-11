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
    public Settings settings;

    public SettingPanel(MainWindow frame, Settings settings) {
        this.frame = frame;
        this.settings = settings;
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
        option4.setOpaque(false);
        JLabel vsLabel = new JLabel("Play against the computer: ");
        vsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        option4.add(vsLabel);
        vsToggle = new JToggleButton("OFF");
        vsToggle.addItemListener(e -> {
            if (vsToggle.isSelected())
                vsToggle.setText("ON");
            else
                vsToggle.setText("OFF");
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
                    int intNumShips = Integer.parseInt(inputNumShips);
                    int intLength = Integer.parseInt(inputLength);
                    System.out.println(intNumShips + ", " + intLength + ", Bigger bomb size: " + bombSize + ", Play against computer: " + vsComputer);
                } catch (InputMismatchException exception) {
                    System.out.println("could not find an integer in the string");
                }
                frame.mainMenu();
                setVisible(false);
            }
        });
        //confirm.addMouseListener(new SettingPanel.ConfirmMouseListener());
        //confirm.addMouseListener(new ConfirmMouseListener());
        JPanel south = new JPanel();
        south.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        south.setOpaque(false);
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