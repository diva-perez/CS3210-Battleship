import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    public ArrayList<Integer> unplacedShipLengths;
    public ArrayList<Ship> ships;
    public String name;
    public Settings settings;
    public ArrayList<Coordinate> guesses;
    public ArrayList<Coordinate> hitList;
    public ArrayList<Coordinate> missList;
    public int NEXT_UNPLACED_INDEX = 0;
    /* 0 to start from the head
     * helps with removing elements from the same end that we read from
     */

    public Player(String name) {
        this.name = name;
        this.settings = settings;
        this.unplacedShipLengths = new ArrayList<>(settings.SHIP_LENGTHS);
        this.ships = new ArrayList<>();
        this.guesses = new ArrayList<>();   // where you tried to fire at enemy ships
        this.hitList = new ArrayList<>();   // red pegs on your own ship
        this.missList = new ArrayList<>();  // white pegs around your own ships
    }

    public String toString() {
        return this.name;
    }

    public Coordinate hasGuessed(Coordinate coordinates) {
        Iterator<Coordinate> guessesIterator = guesses.iterator();
        while (guessesIterator.hasNext()) {
            return coordinates;
        }
        return null;
    }

    public int nextUnplacedShipLength() {
        assert this.hasUnplacedShips() : "No ships left to place";
        return this.unplacedShipLengths.get(this.NEXT_UNPLACED_INDEX);
    }

    public boolean allShipsPlaced() {
        return this.unplacedShipLengths.size() == 0;
    }

    public boolean hasUnplacedShips() {
        return !(this.allShipsPlaced());
    }

    public ArrayList<Ship> sunkShips() {
        ArrayList<Ship> sunkShips = new ArrayList<>();
        for (Ship s : this.ships) {
            if (s.sunk()) {
                sunkShips.add(s);
            }
        }
        return sunkShips;
    }

    public ArrayList<Ship> unsunkShips() {
        ArrayList<Ship> unsunkShips = new ArrayList<>();
        for (Ship s: this.ships) {
            if (!(s.sunk())) {
                unsunkShips.add(s);
            }
        }
        return unsunkShips;
    }

    public void placeNextShip(Coordinate start, Orientation orientation) {
        int length = this.nextUnplacedShipLength();
        assert length >= 1 : "Ships cannot be smaller than size 1";
        Coordinate end = start.getEndFrom(length, orientation);
        assert start.onBoard() : "Start coordinate not valid";
        assert end.onBoard() : "End coordinate not valid";

        // check new ship doesn't coolide with another ship
        Ship newShip = new Ship(start, orientation, length);
        for (Ship otherShip : this.ships) {
            assert !(otherShip.collidesWith(newShip));

        }
        this.unplacedShipLengths.remove(this.NEXT_UNPLACED_INDEX);
        this.ships.add(new Ship(start, orientation, length));
    }

    public boolean checkShipsHit(Coordinate coords) {
        for (Ship ship : this.ships) {
            System.out.println(this.toString() + " ship's: " + ship);
            if (ship.checkHit(coords)) {
                hitList.add(coords);
                return true;
            }
            missList.add(coords);
        }
        return false;
    }

    public void hideShips() {
        for (Ship ship : this.ships) {
            ship.hide();
        }
    }

    public ArrayList<ShipCell> allShipCells() {
        ArrayList<ShipCell> cells = new ArrayList<>();
        for (Ship ship : this.ships) {
            cells.addAll(ship.cells);
        }
        return cells;
    }

    public ArrayList<Coordinate> allShipCoordinates() {
        ArrayList<Coordinate> arr = new ArrayList<Coordinate>();
        for (ShipCell c : this.allShipCells()) {
            arr.add(c.coordinates);
        }
        return arr;
    }

    public Coordinate hitShipCoordinates() {
        for (ShipCell c : this.allShipCells()) {
            if (c.isHit()) {
                return c.coordinates;
            }
        }
        return null;
    }

    public boolean hasShipAtCoord(Coordinate coord) {
        for (Coordinate coordinate : this.allShipCoordinates()) {
            if (coord.equals(coordinate)) {
                //System.out.println(this.allShipCoordinates());
                return true;
            }
        }
        return false;
    }
}