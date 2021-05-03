import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CoordinateTest {

    @Test
    void testToString() {
        Coordinate coord = new Coordinate(0,0);
        Assert.assertEquals(coord.toString(), "(0, 0)");
    }

    @Test
    void sort() {
    }

    @Test
    void testEquals() {
        Coordinate coord = new Coordinate(0,0);
        Coordinate coord2 = new Coordinate(0,0);

        // Assert.assertEquals(true, coord == coord2);
        Assert.assertEquals(true, coord.equals(coord2));
        Assert.assertEquals(coord, coord2);
    }

    @Test
    void onBoard() {
    }

    @Test
    void getEndFrom() {
    }
}