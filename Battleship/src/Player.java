import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    public int NEXT_UNPLACED_INDEX = -1;
    /* 0 to start from the head
     * -1 to start from the tail
     * helps with removing elements from the same end that we read from
     */
    public ArrayList<Integer> unplacedShipLengths;
    public ArrayList<Ship> ships;
    public String name;
    public ArrayList<Coordinate> guesses;
    public ArrayList<Coordinate> hitList;
    public ArrayList<Coordinate> missList;

    public Player(String name) {
        this.name = name;
        this.unplacedShipLengths = Settings.SHIP_LENGTHS;
        this.ships = new ArrayList<>();
        this.guesses = new ArrayList<>();
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
        assert length >= 2 : "Ships cannot be smaller than size 2";
        Coordinate end = start.getEndFrom(length, orientation);
        assert start.onBoard() : "Start coordinate not valid";
        assert end.onBoard() : "End coordinate not valid";

        // check new ship doesn't coolide with another ship
        Ship newShip = new Ship(start, orientation, length);
        for (Ship otherShip : this.ships) {
            assert !(otherShip.collidesWith(newShip));

        }
        this.unplacedShipLengths.remove(this.NEXT_UNPLACED_INDEX);
    }

    public boolean checkShipsHit(Coordinate coords) {
        for (Ship ship : this.ships) {
            if (ship.checkHit(coords)) {
                hitList.add(coords);
                return true;
            }
        }
        missList.add(coords);
        return false;
    }

    public void hideShips() {
        for (Ship ship : this.ships) {
            ship.hide();
        }
    }

    public ArrayList<ShipCell> allShipCells() {
        ArrayList<ShipCell> cells = new ArrayList<>();
        ArrayList<ShipCell> playerShips = Ship.getCells();
        for (Ship ship : this.ships) {
            cells.addAll(playerShips);
        }
        return cells;
    }

    public Coordinate allShipCoordinates() {
        for (ShipCell c : this.allShipCells()) {
            return c.coordinates;
        }
        return null;
    }

    public Coordinate hitShipCoordinates() {
        for (ShipCell c : this.allShipCells()) {
            if (c.isHit()) {
                return c.coordinates;
            }
        }
        return null;
    }
}