import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu;

    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Background("Background.jpg"));
        pack();

        menu = new MainMenu(this);
        add(menu);
        setVisible(true);
    }

    public void startGame() {
        remove(menu);
        menu.setFocusable(false);
        JPanel gamePanel = new GamePanel();
        add(gamePanel);
        repaint();
        gamePanel.requestFocus();

    }

    public void startInstructions() {
        remove(menu);
        menu.setFocusable(false);
        JPanel instructionPanel = new InstructionPanel();
        add(instructionPanel);
        repaint();
        instructionPanel.requestFocus();
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}