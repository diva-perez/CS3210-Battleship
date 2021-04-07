import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class MainMenu extends JPanel {
    private MainWindow frame;

    public MainMenu(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());

        // title panel
        JLabel title = new JLabel("BATTLESHIP", SwingConstants.CENTER);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);
        

        // start button
        JButton start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.PLAIN, 40));
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        // need listener

        //instruction button
        JButton instruction = new JButton("Instructions");
        instruction.setFont(new Font("Arial", Font.PLAIN, 40));
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        // need listener

        // menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        menuPanel.add(start);
        menuPanel.add(Box.createRigidArea(new Dimension(10, 10))); // spacer between buttons
        menuPanel.add(instruction);
        add(menuPanel, BorderLayout.SOUTH);
    }

}
