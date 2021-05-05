import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu = new MainMenu(this);
    private InstructionPanel instructions = new InstructionPanel(this);
    private SettingPanel settings = new SettingPanel(this);
    public static Game game = new Game();
    public GameBoard board = new GameBoard(game);

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

    public void startPlacement() {
        JPanel boardPanel = new JPanel();
        boardPanel.add(board);
        boardPanel.setOpaque(false);
        add(boardPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}