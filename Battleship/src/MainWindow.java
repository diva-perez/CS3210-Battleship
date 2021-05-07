import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu = new MainMenu(this);
    private InstructionPanel instructions = new InstructionPanel(this);
    private SettingPanel settings = new SettingPanel(this);
    private EndPanel end = new EndPanel(game, this);
    public static Game game = new Game();
    public GameBoard board = new GameBoard(game, this);

    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Background("Background.jpg"));
        setLayout(new BorderLayout());
        pack();

        add(menu);
        setVisible(true);
    }

    public void startSettings() {
        add(settings);
        settings.setVisible(true);
    }

    public void mainMenu() {
        menu.setVisible(true);
    }

    public void startInstructions() {
        add(instructions);
        setVisible(true);
    }

    public void startGame() {
        System.out.println("Current player:" + game.current.toString() + "\nInactive Player:" + game.inactive.toString());
        JPanel boardPanel = new JPanel();
        boardPanel.add(board);
        boardPanel.setOpaque(false);
        add(boardPanel);
        setVisible(true);
        if (game.getPhase() == Game.GamePhase.END) {
            boardPanel.setVisible(false);
        }
    }
    public void endGame() {
        System.out.println(game.winner);

        add(end);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}