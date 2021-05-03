import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    public static int BOARD_WIDTH = 10;
    public static int BOARD_HEIGHT = 10;
    public static int MAX_X = BOARD_WIDTH - 1;
    public static int MAX_Y = BOARD_HEIGHT - 1;
    static ArrayList<Integer> SHIP_LENGTHS = new ArrayList<Integer>(
            Arrays.asList(2, 3, 3, 4, 5));
}
