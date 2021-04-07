import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainMenu extends JPanel {
    private MainWindow frame;

    public MainMenu(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title panel
        JLabel title = new JLabel("BATTLESHIP", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright"))
    }
}
