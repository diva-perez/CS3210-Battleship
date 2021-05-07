import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Coordinate coordinate = new Coordinate(0,0);
    Ship ship = new Ship(coordinate, Orientation.VERTICAL, 1);
    Player player = new Player("test");

    @Test
    void hasGuessed() {
    }

    @Test
    void nextUnplacedShipLength() {
    }

    @Test
    void allShipsPlaced() {
    }

    @Test
    void hasUnplacedShips() {
        Player testPlayer = new Player("one");
        Assert.assertTrue(testPlayer.hasUnplacedShips());
        testPlayer.placeNextShip(new Coordinate(1, 1), Orientation.VERTICAL);
        Assert.assertFalse(testPlayer.hasUnplacedShips());
    }

    @Test
    void sunkShips() {
    }

    @Test
    void unsunkShips() {
    }

    @Test
    void placeNextShip() {
        Player testPlayer = new Player("test");
        testPlayer.placeNextShip(new Coordinate(2,2), Orientation.VERTICAL);
        Assert.assertEquals(testPlayer.ships.size(), 1);

    }

    @Test
    void checkShipsHit() {
        assertFalse(player.checkShipsHit(coordinate));
        assertEquals(ship.getCellAt(coordinate).state, ShipCell.ShipCellState.PLACED);
        player.ships.add(ship);
        assertThrows(AssertionError.class, () -> player.checkShipsHit(coordinate));
        ship.hide();
        assertTrue(player.checkShipsHit(coordinate));
        assertEquals(ship.getCellAt(coordinate).state, ShipCell.ShipCellState.HIT);
        assertTrue(player.hitList.contains(coordinate));
    }

    @Test
    void hideShips() {
    }

    @Test
    void allShipCells() {
    }

    @Test
    void allShipCoordinates() {
        Player test = new Player("test");
        Coordinate coord = new Coordinate(0,1);
        test.placeNextShip(coord, Orientation.VERTICAL);
        assert test.allShipCoordinates().size() == 1;
        Assert.assertEquals(test.allShipCoordinates().get(0), coord);
    }

    @Test
    void hitShipCoordinates() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testHasGuessed() {
    }

    @Test
    void testNextUnplacedShipLength() {
    }

    @Test
    void testAllShipsPlaced() {
    }

    @Test
    void testHasUnplacedShips() {
    }

    @Test
    void testSunkShips() {
    }

    @Test
    void testUnsunkShips() {
    }

    @Test
    void testPlaceNextShip() {
    }

    @Test
    void testCheckShipsHit() {
    }

    @Test
    void testHideShips() {
    }

    @Test
    void testAllShipCells() {
    }

    @Test
    void testAllShipCoordinates() {
    }

    @Test
    void testHitShipCoordinates() {
    }
}