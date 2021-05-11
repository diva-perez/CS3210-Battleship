import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    // static settings (board height and width)
    public static int BOARD_WIDTH = 10;
    public static int BOARD_HEIGHT = 10;
    public static int MAX_X = BOARD_WIDTH;
    public static int MAX_Y = BOARD_HEIGHT;

    // variable settings
    // this needs to not be static
    public static ArrayList<Integer> SHIP_LENGTHS = new ArrayList<Integer>(
            Arrays.asList(2, 1));
    private int inputNumShips;
    private int inputLength;
    private boolean bigBomb = false;
    private boolean vsComputer = false;


    public Settings() {}

    public Settings(int inputNumShips, int inputLength, boolean bombSize, boolean vsComputer) {
        SHIP_LENGTHS = amountOfShips(this.inputNumShips);
        shipLengths(this.inputLength);
    }

    // change SHIP_LENGTHS ArrayList amount of ships
    public ArrayList<Integer> amountOfShips(int numShip) {
        ArrayList<Integer> list = new ArrayList<Integer>(numShip);
        return list;
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

    public ArrayList<Integer> getShipList(){
        return SHIP_LENGTHS;
    }

}
