import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GameTest {

    @Test
    void getCurrent() {
    }

    @Test
    void getPhase() {
    }

    @Test
    void allPlayersShipsPlaced() {
    }

    @Test
    void endTurn() {
    }

    @Test
    void placeShip() {
        Game game = new Game();
        ArrayList<Ship> ships = game.current.ships;
        game.placeShip(new Coordinate(2,2), Orientation.VERTICAL);
        Assert.assertEquals(ships.size(), 1);

    }

    @Test
    void fire() {
    }
}