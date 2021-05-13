import java.util.ArrayList;

public class Ship {
    private final Coordinate start;
    private final Orientation orientation;
    public int length;
    public ArrayList<ShipCell> cells;

    public Ship(Coordinate start, Orientation orientation, int length) {
        this.start = start;
        this.orientation = orientation;
        this.length = length;
        this.cells = new ArrayList<>();
        for (int i = 1; i < length + 1; i++) {
            Coordinate newCoordinate = start.getEndFrom(i, orientation);
            ShipCell newCell = new ShipCell(newCoordinate, orientation);
            this.cells.add(newCell);
        }
    }

    public String toString() {
        return this.start + "; " + this.orientation + "; " + this.length;
    }

    public boolean sunk() {
        /*
          if all ShipCells have been hit
         */
        boolean isSunk = true;
        for (ShipCell c : this.cells) {
            if (!c.isHit()) {
                isSunk = false;
            }
        }
        return isSunk;
    }

    public void sink() {    // test method
        for (ShipCell c : this.cells) {
            c.takeHit();
        }
    }

    public ShipCell getCellAt(Coordinate coords) {
        /*
          return the ShipCell at coords if there is one
          else None
         */
        for (ShipCell cell : this.cells) {
            if (cell.coordinates.equals(coords)) {
                return cell;
            }
        }
        return null;
    }

    public boolean checkHit(Coordinate coord) {
        /*
          raises Assertion Error if the shot his a cell that's already been hit
         */
        ShipCell cell = this.getCellAt(coord);
        if (cell != null) {
            assert cell.isHidden() : "Cell is not hidden";
            cell.takeHit();
            return true;
        }
        return false;
    }

    public boolean collidesWith(Ship otherShip) {
        /*
          checks if this ship overlap otherShip
         */
        for (ShipCell c : this.cells) {
            if (otherShip.getCellAt(c.coordinates) != null) {
                return true;
            }
        }
        return false;
    }

    public void hide() {
        /*
          set ShipCellState.hidden for all ShipCells belonging to this ship
         */
        for (ShipCell c : this.cells) {
            c.hide();
        }
    }
}