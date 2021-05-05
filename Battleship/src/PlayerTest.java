import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PlayerTest {

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