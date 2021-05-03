import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JPanel {
    private static MainWindow frame;
    private JButton start;
    private JButton setting;
    private JButton instruction;

    public MainMenu(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("BATTLESHIP", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(BorderLayout.NORTH, title);

        // start default battleship
        start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.PLAIN, 40));
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.addMouseListener(new StartMouseListener());

        // settings button
        setting = new JButton("Settings");
        setting.setFont(new Font("Arial", Font.PLAIN, 40));
        setting.setAlignmentX(Component.CENTER_ALIGNMENT);
        setting.addMouseListener(new SettingsMouseListener());

        //instruction button
        instruction = new JButton("Instructions");
        instruction.setFont(new Font("Arial", Font.PLAIN, 40));
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        instruction.addMouseListener(new InstructionMouseListener());

        // menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        menuPanel.add(start);
        menuPanel.add(Box.createRigidArea(new Dimension(10, 10))); // spacer between buttons
        menuPanel.add(setting);
        menuPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        menuPanel.add(instruction);
        add(BorderLayout.CENTER, menuPanel);
    }

    private class StartMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            setVisible(false);
            frame.startPlacement();
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            start.setOpaque(true);
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            start.setOpaque(false);
            repaint();
        }
    }
    private class SettingsMouseListener extends StartMouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.startSettings();
            setVisible(false);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            setting.setOpaque(true);
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            setting.setOpaque(false);
            repaint();
        }
    }

    private class InstructionMouseListener extends StartMouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.startInstructions();
            setVisible(false);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            instruction.setOpaque(true);
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            instruction.setOpaque(false);
            repaint();
        }
    }
}