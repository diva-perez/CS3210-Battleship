import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenu menu;
    private InstructionPanel instruction;
    private GamePanel gamePanel;
    private WaitPanel wait;
    private PlayerPanel place1; // pull Gameboard from these panels (place1.board)
    private PlayerPanel place2; // place2.board will give GameBoard
    private static GamePhase gamePhase;
    private static GameBoard player1Board;
    private static GameBoard player2Board;

    //static universal game phase variable with get method to replace in waitpanel, playerpanel, gameboard
    //call method with actionlistener
    //make sure to update the phase

    //setPhase()
    //getPhase()


    public MainWindow() {
        super("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Background("Background.jpg"));
        setLayout(new BorderLayout());
        pack();

        menu = new MainMenu(this);
        add(menu);
        setVisible(true);
        gamePhase = GamePhase.PLAYER1_PLACE_SHIP;
    }

    public void wait(JPanel caller) {
        wait = new WaitPanel(this);
        caller.setVisible(false);
        add(wait);
        wait.setVisible(true);
        repaint();
    }

    public void place() {
        if (gamePhase == GamePhase.PLAYER1_PLACE_SHIP) {
            place1 = new PlayerPanel(this);
            wait.setVisible(false);
            add(place1);
            place1.setVisible(true);
        } else {
            place2 = new PlayerPanel(this);
            wait.setVisible(false);
            add(place2);
            place2.setVisible(true);
        }
        repaint();
    }

    public void startBattle() {
        //GamePanel should take in a board variable argument - display board based on player
        gamePanel = new GamePanel(this);
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

    /*
     * 5 game phases
     */
    public enum GamePhase {
        PLAYER1_PLACE_SHIP, PLAYER2_PLACE_SHIP, PLAYER1_BATTLE, PLAYER2_BATTLE, GAME_OVER
    }

    public static GamePhase getPhase() {
        return gamePhase;
    }

    public static void setPhase(MainWindow.GamePhase phase){
        MainWindow.gamePhase = phase;
    }

    public static GameBoard getPlayer1Board() {
        return player1Board;
    }

    public static GameBoard getPlayer2Board() {
        return player2Board;
    }

    public static void setPlayer1Board(GameBoard board) {
        player1Board = board;
    }

    public static void setPlayer2Board(GameBoard board) {
        player2Board = board;
    }

}