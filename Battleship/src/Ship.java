import java.util.ArrayList;

public class Ship {
    public int length = 0;
    private static ArrayList<ShipCell> cells;

    public Ship(Coordinate start, Orientation orientation, int length) {
        this.length = length;
        this.setCells(new ArrayList());
        for (int i = 1; i < length + 1; i++) {
            Coordinate newCoordinate = start.getEndFrom(i, orientation);
            ShipCell newCell = new ShipCell(newCoordinate);
            this.getCells().add(newCell);
        }
    }

    public static ArrayList<ShipCell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<ShipCell> cells) {
        this.cells = cells;
    }

    public boolean sunk() {
        /**
         * if all ShipCells have been hit
         */
        for (ShipCell c : this.getCells()) {
            if (c.isHit()) {
                return true;
            }
        }
        return false;
    }

    public ShipCell getCellAt(Coordinate coords) {
        /**
         * return the ShipCell at coords if there is one
         * else None
         */
        for (ShipCell cell : this.getCells()) {
            if (cell.coordinates == coords) {
                return cell;
            }
        }
        return null;
    }

    public boolean checkHit(Coordinate coord) {
        /**
         * raises Assertion Error if the shot his a cell that's already been hit
         */
        ShipCell cell = this.getCellAt(coord);
        if (cell != null) {
            assert cell.isHidden() : cell;
            cell.takeHit();
            return true;
        }
        return false;
    }

    public boolean collidesWith(Ship otherShip) {
        /**
         * checks if this ship overlap otherShip
         */
        for (ShipCell c : this.getCells()) {
            if (otherShip.getCellAt(c.coordinates) != null) {
                return true;
            }
        }
        return false;
    }

    public void hide() {
        /**
         * set ShipCellState.hidden for all ShipCells belonging to this ship
         */
        for (ShipCell c : this.getCells()) {
            c.hide();
        }
    }
}