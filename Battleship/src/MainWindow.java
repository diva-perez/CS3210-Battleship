import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public static Settings settings = new Settings();
    private final MainMenu menu;
    private JPanel boardPanel;
    public Game game;
    public GameBoard board;

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

    public void startSettings() {
        SettingsPanel settingsPanel = new SettingsPanel(this);
        add(settingsPanel);
        settingsPanel.setVisible(true);
    }

    public void mainMenu() {
        menu.setVisible(true);
    }

    public void startInstructions() {
        InstructionPanel instructions = new InstructionPanel(this);
        add(instructions);
        setVisible(true);
    }

    public void startGame() {
        game = new Game();
        board = new GameBoard(game, this);
        boardPanel = new JPanel();
        boardPanel.add(board);
        boardPanel.setOpaque(false);
        add(boardPanel);
        boardPanel.setFocusable(true);
        setVisible(true);
    }

    public void endGame() {
        System.out.println(game.winner);
        boardPanel.setVisible(false);
        EndPanel end = new EndPanel(game, this);
        add(end);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}