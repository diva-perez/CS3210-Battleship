import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    Coordinate coordinate = new Coordinate(0,0);
    Ship ship = new Ship(coordinate, Orientation.VERTICAL, 1);
    Player player = new Player("test");

    @Test
    void Ship() {
        Assert.assertEquals(ship.length, 1);
        Assert.assertEquals(ship.cells.size(), 1);
        Assert.assertEquals(ship.cells.get(0).coordinates, coordinate);

    }

    @Test
    void setCells() {
    }

    @Test
    void sunk() {
    }

    @Test
    void getCellAt() {
        assertEquals(ship.cells.get(0).coordinates, coordinate);
        assertEquals(ship.getCellAt(coordinate).coordinates, coordinate);
    }

    @Test
    void checkHit() {



    }

    @Test
    void collidesWith() {
    }
}