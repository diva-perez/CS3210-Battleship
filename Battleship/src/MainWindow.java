import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu = new MainMenu(this);
    private PlacementPanel placement = new PlacementPanel(this);
    private InstructionPanel instructions = new InstructionPanel(this);
    private SettingPanel settings = new SettingPanel(this);
    public GameBoard board = new GameBoard();
    public static Game game = new Game();

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
        boardPanel.add(board);  // board needs to be on it's own panel to appear like a square rather than encompass the whole width of the screen
        boardPanel.setOpaque(false);
        placement.add(BorderLayout.CENTER, boardPanel);
        add(placement);
        setVisible(true);
    }

    public void endTurn() {
        game.endTurn();
        // System.out.println(game.getCurrent());
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}