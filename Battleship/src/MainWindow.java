import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu;
    private InstructionPanel instructions;
    private SettingPanel settings;
    private JPanel boardPanel;
    private EndPanel end;
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
        settings = new SettingPanel(this);
        add(settings);
        settings.setVisible(true);
    }

    public void mainMenu() {
        menu.setVisible(true);
    }

    public void startInstructions() {
        instructions = new InstructionPanel(this);
        add(instructions);
        setVisible(true);
    }

    public void startGame() {
        game = new Game();
        board = new GameBoard(game, this);
        boardPanel = new JPanel();
        System.out.println("Current player:" + game.current.toString() + "\nInactive Player:" + game.inactive.toString());
        boardPanel.add(board);
        boardPanel.setOpaque(false);
        add(boardPanel);
        boardPanel.setFocusable(true);
        setVisible(true);
    }

    public void endGame() {
        System.out.println(game.winner);
        boardPanel.setVisible(false);
        end = new EndPanel(game, this, game.winner);
        add(end);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}