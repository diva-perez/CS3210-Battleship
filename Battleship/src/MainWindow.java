import javax.swing.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }

    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Background("Background.jpg"));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();

        MainMenu menu = new MainMenu(this);
        add(menu);
        setVisible(true);
    }

}