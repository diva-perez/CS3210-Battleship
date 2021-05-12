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
            Arrays.asList(1));
    //private int numShips;
    //private int length;
    private boolean bigBomb;
    private boolean vsComputer;


    public Settings() {}

    public Settings(int inputNumShips, int inputLength, boolean bombSize, boolean vsComputer) {
        amountOfShips(inputNumShips);
        shipLengths(inputLength);
        setBombSize(bombSize);
        this.vsComputer = vsComputer;
    }

    // change SHIP_LENGTHS ArrayList amount of ships
    public void amountOfShips(int numShips) {
        SHIP_LENGTHS = new ArrayList<Integer>();
        // need this loop to create the correct number of indexes in the new SHIP_LENGTH list
        // didn't work just calling "SHIP_LENGTHS = new ArrayList<Integer>(numShips)"
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
    public void setBombSize(boolean bigBomb) {
        this.bigBomb = bigBomb;
    }

    public boolean getBombSize() {
        return bigBomb;
    }

    public ArrayList<Integer> getShipList(){
        return SHIP_LENGTHS;
    }

}
