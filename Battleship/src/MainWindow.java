import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Background("Background.jpg"));
        pack();

        MainMenu menu = new MainMenu(this);
        add(menu);
        setVisible(true);
    }

}