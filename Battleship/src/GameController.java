import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameController {
    private Game game;
    private Object phase = Game.getPhase();

    public GameController() {
        this.game = new Game();
    }

    public void start() {
        while (GamePhase.END != this.phase) {
            getBattleDisplay();
            if (GamePhase.PLACING == this.phase) {
                Object[] shipPlacement = this.getShipPlacement();
                this.game.placeShip((Coordinate) shipPlacement[0], (Orientation) shipPlacement[1]);
            } else {
                //GUI battle display
                Coordinate coords = this.getFiringCoordinates();
                boolean scored = this.game.fire(coords);
                if (scored) {
                    System.out.println("HIT");
                } else {
                    System.out.println("MISS");
                }
            }
        }
    }

    public Coordinate parseCoords(String coordString) {
        String[] arrOfStr = coordString.split(",", 2);
        return new Coordinate(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]));
    }

    public Coordinate getFiringCoordinates() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter firing coordinates: ");
        String coord = scanner.nextLine();
        return parseCoords(coord);
    }

    public Object[] getShipPlacement() {
        int length = this.game.current.nextUnplacedShipLength();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Choose top/left cell to place ship (length = %s)\n", length);
        String coordStr = scanner.nextLine();
        Coordinate coords = this.parseCoords(coordStr);

        System.out.println("Choose (h)orizontal or (v)vertical orientation");
        String orientationStr = scanner.nextLine();
        assert (orientationStr.equals("h") || orientationStr.equals("v"));
        Orientation orientation;
        if (orientationStr == "h") {
            orientation = Orientation.HORIZONTAL;
        } else {
            orientation = Orientation.VERTICAL;
        }
        return new Object[]{coords, orientation};
    }

    public void getBattleDisplay() {
        Set<Coordinate> guesses = new HashSet(Arrays.asList(this.game.current.guesses));
        Set<Coordinate> hits = new HashSet<>();
        hits.add(this.game.inactive.hitShipCoordinates());
        // misses = guesses - hits
        Set<Coordinate> misses = new HashSet<>(guesses);
        misses.removeAll(hits);

    }

}
