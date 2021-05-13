import java.util.ArrayList;

public class Player {
    public ArrayList<Integer> unplacedShipLengths;
    public ArrayList<Ship> ships;
    public String name;
    public ArrayList<Coordinate> guesses;
    public ArrayList<Coordinate> hitList;
    public ArrayList<Coordinate> missList;
    // 0 to start from the head
    // helps with removing elements from the same end that we read from
    public int NEXT_UNPLACED_INDEX = 0;

    public Player(String name) {
        this.name = name;
        this.unplacedShipLengths = new ArrayList<>(MainWindow.settings.SHIP_LENGTHS);
        this.ships = new ArrayList<>();
        this.guesses = new ArrayList<>();   // where you tried to fire at enemy ships
        this.hitList = new ArrayList<>();   // red pegs on your ships
        this.missList = new ArrayList<>();  // white pegs around your ships
    }

    public String toString() {
        return this.name;
    }

    public int nextUnplacedShipLength() {
        /*
         * gets the length of the next ship to place for current highlight length
         */
        assert this.hasUnplacedShips() : "No ships left to place";
        return this.unplacedShipLengths.get(this.NEXT_UNPLACED_INDEX);
    }

    public boolean allShipsPlaced() {
        return this.unplacedShipLengths.size() == 0;
    }

    public boolean hasUnplacedShips() {
        return !(this.allShipsPlaced());
    }

    public ArrayList<Ship> unsunkShips() {
        /*
         * array list used to track player ships status for checking win condition
         */
        ArrayList<Ship> unsunkShips = new ArrayList<>();
        for (Ship s: this.ships) {
            if (!(s.sunk())) {
                unsunkShips.add(s);
            }
        }
        return unsunkShips;
    }

    public void placeNextShip(Coordinate start, Orientation orientation) throws InvalidShipPlacingException {
        int length = this.nextUnplacedShipLength();
        assert length >= 1 : "Ships cannot be smaller than size 1";
        Coordinate end = start.getEndFrom(length, orientation);
        if (!end.onBoard()) {
            System.err.println("Ships cannot extend beyond the board!");
            throw new InvalidShipPlacingException("ship placement is not valid");
        }

        // check new ship doesn't collide with another ship
        Ship newShip = new Ship(start, orientation, length);
        for (Ship otherShip : this.ships) {
            if (otherShip.collidesWith(newShip)) {
                System.err.println("Ships cannot be stacked!");
                throw new InvalidShipPlacingException("ship placement is not valid");
            }

        }
        this.unplacedShipLengths.remove(this.NEXT_UNPLACED_INDEX);
        this.ships.add(new Ship(start, orientation, length));
    }

    public boolean checkShipsHit(Coordinate coords) {
        for (Ship ship : this.ships) {
            if (ship.checkHit(coords)) {
                hitList.add(coords);
                return true;
            }
            missList.add(coords);
        }
        return false;
    }

    public void hideShips() {
        /*
         * hides ship for battling phase
         */
        for (Ship ship : this.ships) {
            ship.hide();
        }
    }

    public ArrayList<ShipCell> allShipCells() {
        /*
         * array list for checking ship cells against coordinate cells for hit/miss
         */
        ArrayList<ShipCell> cells = new ArrayList<>();
        for (Ship ship : this.ships) {
            cells.addAll(ship.cells);
        }
        return cells;
    }

    public ArrayList<Coordinate> allShipCoordinates() {
        ArrayList<Coordinate> arr = new ArrayList<>();
        for (ShipCell c : this.allShipCells()) {
            arr.add(c.coordinates);
        }
        return arr;
    }

    public ShipCell getShipCellAtCoord(Coordinate coord) {
        for (Ship ship : this.ships) {
            ShipCell found = ship.getCellAt(coord);
            if (found != null && found.coordinates.equals(coord)) {
                return found;
            }
        }
        return null;
    }

    public boolean hasShipAtCoord(Coordinate coord) {
        for (Coordinate coordinate : this.allShipCoordinates()) {
            if (coord.equals(coordinate)) {
                return true;
            }
        }
        return false;
    }
}