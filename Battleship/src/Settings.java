import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    // static settings (board height and width)
    public static int BOARD_WIDTH = 10;
    public static int BOARD_HEIGHT = 10;
    public static int MAX_X = BOARD_WIDTH;
    public static int MAX_Y = BOARD_HEIGHT;

    // variable settings
    // this needs to not be static or wait to initialize until we hit start game / confirm in settings
    public ArrayList<Integer> SHIP_LENGTHS = new ArrayList<Integer>(
            Arrays.asList(2, 1));
    //private int numShips;
    //private int length;
    //private boolean bigBomb = false;
    //private boolean vsComputer = false;


    public Settings() {}

    public Settings(int inputNumShips, int inputLength) {
        amountOfShips(inputNumShips);
        shipLengths(inputLength);
    }

    public Settings(int inputNumShips, int inputLength, boolean bombSize, boolean vsComputer) {
        amountOfShips(inputNumShips);
        shipLengths(inputLength);
    }

    // change SHIP_LENGTHS ArrayList amount of ships
    public void amountOfShips(int numShips) {
        SHIP_LENGTHS = new ArrayList<Integer>();
        for (int i = 0; i < numShips; i++) {
            SHIP_LENGTHS.add(i);
        }
    }

    // change SHIP_LENGTHS length
    public void shipLengths(int length) {
        for (int ship : SHIP_LENGTHS) {
            SHIP_LENGTHS.set(ship, length);
        }
    }

    // use big bomb size
    public void bombSize(boolean bigBomb) {

    }

    public ArrayList<Integer> getShipList(){
        return SHIP_LENGTHS;
    }

}
