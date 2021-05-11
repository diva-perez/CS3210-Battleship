import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    /*
     * Default settings
     */
    public static int BOARD_WIDTH = 10;
    public static int BOARD_HEIGHT = 10;
    public static int MAX_X = BOARD_WIDTH;
    public static int MAX_Y = BOARD_HEIGHT;
    public static ArrayList<Integer> SHIP_LENGTHS = new ArrayList<Integer>(
            Arrays.asList(2, 1));

    public Settings() {

    }

    // change SHIP_LENGTHS ArrayList amount of ships
    public void amountOfShips(int numShip) {
        SHIP_LENGTHS = new ArrayList<Integer>(numShip);
    }

    // change SHIP_LENGTHS length
    public void shipLengths(int length) {
        for (int ship : SHIP_LENGTHS) {
            SHIP_LENGTHS.set(ship, length);
        }
    }

    // set bomb size
    public void bombSize(int size) {

    }

    public static int getBombSize() {
        return 1;
    }

    public static ArrayList<Integer> getShipList(){
        return SHIP_LENGTHS;
    }

}
