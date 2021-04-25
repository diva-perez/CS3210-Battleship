import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainMenu menu;
    private InstructionPanel instruction;
    private GamePanel gamePanel;
    private WaitPanel wait;
    private PlayerPanel place;

    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Background("Background.jpg"));
        setLayout(new BorderLayout());
        pack();

        menu = new MainMenu(this);
        add(menu);
        setVisible(true);
    }


    public void wait(JPanel caller, String player) {
        wait = new WaitPanel(this, player);
        menu.setVisible(false);
        caller.setVisible(false);
        add(wait);
        wait.setVisible(true);
        repaint();
    }

    public void place(String player) {
        place = new PlayerPanel(player);
        wait.setVisible(false);
        add(place);
        place.setVisible(true);
        repaint();
    }

    public void startBattle() {
        gamePanel = new GamePanel();
        menu.setVisible(false);
        add(gamePanel);
        gamePanel.setVisible(true);
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