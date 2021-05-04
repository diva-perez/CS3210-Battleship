import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoard extends JPanel {
    public Coordinate coordinate;
    public Orientation orientation = Orientation.VERTICAL;
    public Game game;
    public int length;

    public GameBoard(Game game) {
            this.game = game;
            setLayout(new GridLayout(10, 10));
            for (int y = 1; y <= Settings.MAX_Y + 1; y++) {     // + 1 to get 10 x 10
                for (int x = 1; x <= Settings.MAX_X + 1; x++) {
                    Cell cell = (new Cell(new Coordinate(x, y)));
                    cell.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            coordinate = cell.getCoord();
                            System.out.println(coordinate);
                        }

                        public void mouseEntered(MouseEvent e) {
                            coordinate = cell.getCoord();
                            System.out.println(coordinate);
                            if (coordinate.getEndFrom(length, orientation).onBoard()) {
                                Ship ship = new Ship(coordinate, orientation, length);
                            }
                            // boolean, if getShipEnd is within bounds of the board
                            game.placeShip(coordinate, orientation);
                            repaint();
                        }

                        public void mouseExited(MouseEvent e) {
                            repaint();
                        }
                    });
                    add(cell);
                }
            }
            /*ArrayList<Integer> SHIP_LENGTHS = Settings.getShipList();
                int i = 0;
                while (i < SHIP_LENGTHS.size()) {
                    this.length = SHIP_LENGTHS.get(i);
            }*/
    }
}