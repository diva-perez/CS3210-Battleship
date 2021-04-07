import javax.swing.*;
import java.awt.*;

public class InstructionPanel extends JPanel {
    public InstructionPanel() {
        setFocusable(true);
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("INSTRUCTIONS", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);
    }
}
