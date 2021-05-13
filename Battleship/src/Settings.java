import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    // static settings (board height and width)
    public static int BOARD_WIDTH = 10;
    public static int BOARD_HEIGHT = 10;
    public static int MAX_X = BOARD_WIDTH;
    public static int MAX_Y = BOARD_HEIGHT;
    private static boolean vsComputer;

    // variable settings
    public ArrayList<Integer> SHIP_LENGTHS = new ArrayList<>(
            Arrays.asList(2, 3, 3, 4, 5));
    private boolean bigBomb;


    public Settings() {
        /*
         * initialize game with default settings
         * 5 ships
         * lengths 2, 3, 3, 4, 5
         * small bomb
         * 2 players
         */
    }

    public Settings(boolean bombSize, boolean vsComputer) {
        /*
         * constructor for boolean conditions
         */
        setBombSize(bombSize);
        vsComputer(vsComputer);
    }

    public Settings(int inputNumShips, int inputLength, boolean bombSize, boolean vsComputer) {
        /*
         * constructor for variable numShips and length
         * if a user wants to change the number of ships
         * they also have to specify the length
         */
        amountOfShips(inputNumShips);
        shipLengths(inputLength);
        setBombSize(bombSize);
        vsComputer(vsComputer);
    }

    public void amountOfShips(int numShips) {
        /*
         * change SHIP_LENGTHS ArrayList amount of ships
         */
        SHIP_LENGTHS = new ArrayList<>();
        // need this loop to create the correct number of indexes in the new SHIP_LENGTH list
        // didn't work just calling "SHIP_LENGTHS = new ArrayList<Integer>(numShips)"
        for (int i = 0; i < numShips; i++) {
            SHIP_LENGTHS.add(i);
        }
    }

    public void shipLengths(int length) {
        /*
         * change SHIP_LENGTH lengths
         */
        for (int ship : SHIP_LENGTHS) {
            SHIP_LENGTHS.set(ship, length);
        }
    }

    public void setBombSize(boolean bigBomb) {
        /*
         * use a bigger bomb size
         */
        this.bigBomb = bigBomb;
    }

    public void vsComputer(boolean vsComputer) {
        /*
         * play against a computer
         */
        this.vsComputer = vsComputer;
    }

    public boolean getBombSize() { return bigBomb; }
    public boolean getComputer() { return vsComputer; }
}
