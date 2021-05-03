import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    public MainWindow.GamePhase phase;

    public GameBoard() {
        this.phase = MainWindow.getPhase();
        setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            Cell cell = (new Cell());
            add(cell);
            cell.addActionListener(e -> {

                switch (phase) {
                    case PLAYER1_PLACE_SHIP:
                    case PLAYER2_PLACE_SHIP:
                        cell.placeShip();
                        cell.grabFocus();
                        //setPhase()
                        break;
                    case PLAYER1_BATTLE:
                    case PLAYER2_BATTLE:
                        cell.hideShip();
                        cell.dropBomb();
                        //setPhase()
                        break;
                    case GAME_OVER:
                        //end game scenario
                        //setPhase()
                        break;
                }
            });

        }
    }
}

