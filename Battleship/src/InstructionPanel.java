import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InstructionPanel extends JPanel {
    private static MainWindow frame;
    private JButton back;

    public InstructionPanel(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("INSTRUCTIONS", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(BorderLayout.NORTH, title);

        // instructions
        JPanel info = new JPanel();
        info.setOpaque(false);
        JLabel instructions = new JLabel("<html><div style='text-align: center;'>You and your opponent will alternate turns placing bombs to try and hit each other's ship<br>The first one to find the other's ship wins</div></html>");
        instructions.setFont(new Font("Arial", Font.PLAIN, 25));
        info.add(instructions);
        add(BorderLayout.CENTER, info);


        // back button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        buttonPanel.setOpaque(false);
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 40));
        back.addMouseListener(new BackMouseListener());
        buttonPanel.add(back);
        add(BorderLayout.SOUTH, buttonPanel);
    }

    private class BackMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.endTurn();
            setVisible(false);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            back.setOpaque(true);
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            back.setOpaque(false);
            repaint();
        }
    }
}
