import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu = new MainMenu(this);
    private PlacementPanel placement = new PlacementPanel(this);
    private InstructionPanel instructions = new InstructionPanel(this);

    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Background("Background.jpg"));
        setLayout(new BorderLayout());
        pack();

        add(menu);
        setVisible(true);
    }

    public void mainMenu() {
        menu.setVisible(true);
    }

    public void startPlacement() {
        //GameController controller = new GameController();
        //controller.start();
        JPanel gridPanel = new GameBoard();
        add(placement);
        placement.add(BorderLayout. CENTER, gridPanel);
        setVisible(true);
    }

    public void startInstructions() {
        add(instructions);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}