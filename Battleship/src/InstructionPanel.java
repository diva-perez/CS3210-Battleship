import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InstructionPanel extends JPanel {
    private MainWindow frame;
    private JButton back;

    public InstructionPanel(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("INSTRUCTIONS", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);

        // instructions
        JPanel info = new JPanel();
        info.setOpaque(false);
        add(info, BorderLayout.CENTER);


        // back button
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 40));
        back.addMouseListener(new BackMouseListener());
        add(back, BorderLayout.SOUTH);
    }

    private class BackMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.mainMenu();
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
