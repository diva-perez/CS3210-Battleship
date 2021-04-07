import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }

    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        pack();

        MainMenu menu = new MainMenu(this);
        add(menu);
        setVisible(true);
    }
}
