import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu;
    private InstructionPanel instruction;
    private GamePanel gamePanel;
    private Player1WaitPanel player1Wait;
    private Player1PlacePanel player1Place;

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

    public void player1Wait() {
        player1Wait = new Player1WaitPanel(this);
        player1Wait.setPreferredSize(new Dimension(800, 600));;
        menu.setVisible(false);
        add(player1Wait);
        player1Wait.setVisible(true);
        repaint();
    }

    public void player1Place() {
        player1Place = new Player1PlacePanel();
        player1Wait.setVisible(false);
        add(player1Place);
        player1Place.setVisible(true);
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