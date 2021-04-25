import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu;
    private InstructionPanel instruction;
    private GamePanel gamePanel;
    private WaitPanel wait;
    private PlayerPanel place1;
    private PlayerPanel place2;
    private String player;

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
        caller.setVisible(false);
        add(wait);
        wait.setVisible(true);
        repaint();
    }

    public void place(String player) {
        if (player == "PLAYER 1") {
            place1 = new PlayerPanel(player, this);
            wait.setVisible(false);
            add(place1);
            place1.setVisible(true);
        } else {
            place2 = new PlayerPanel(player, this);
            wait.setVisible(false);
            add(place2);
            place2.setVisible(true);
        }
        repaint();
    }

    public void startBattle() {
        gamePanel = new GamePanel(player, this);
        place2.setVisible(false);
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