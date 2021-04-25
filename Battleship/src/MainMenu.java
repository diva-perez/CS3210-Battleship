import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import static java.awt.SystemColor.menu;

public class MainMenu extends JPanel {
    private MainWindow frame;
    private JButton start;
    private JButton instruction;
    private String player = "PLAYER 1";
    public JPanel menuPanel;

    public MainMenu(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("BATTLESHIP", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);


        // start button
        start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.PLAIN, 40));
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.addMouseListener(new StartMouseListener());

        //instruction button
        instruction = new JButton("Instructions");
        instruction.setFont(new Font("Arial", Font.PLAIN, 40));
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        instruction.addMouseListener(new InstructionMouseListener());

        // menu panel
        menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        menuPanel.add(start);
        menuPanel.add(Box.createRigidArea(new Dimension(10, 10))); // spacer between buttons
        menuPanel.add(instruction);
        add(menuPanel, BorderLayout.CENTER);
    }

    private class StartMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel caller = null;
            if (e.getSource() == start){ caller = menuPanel;}
            frame.wait(caller, player);
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
    private class InstructionMouseListener extends StartMouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.startInstructions();
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

