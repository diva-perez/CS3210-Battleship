import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu;
    private InstructionPanel instruction;

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
        menu.setVisible(false);
        JPanel gamePanel = new GamePanel();
        add(gamePanel);
        repaint();
        gamePanel.requestFocus();

    }

    public void startInstructions() {
        instruction = new InstructionPanel(this);
        add(instruction);
        menu.setVisible(false);
        instruction.setVisible(true);
        repaint();

    }

    public void mainMenu() {
        instruction.setVisible(false);
        menu.setVisible(true);
        repaint();
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}