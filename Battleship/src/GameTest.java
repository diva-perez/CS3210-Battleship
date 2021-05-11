import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class GameTest {
    /*public static Game gameFactory(boolean isSunk, Game.GamePhase phase) {
        Game game = new Game();
        game.phase = phase;
        Coordinate sunk = new Coordinate(1, 1);
        game.current.ships.add(new Ship(new Coordinate(1, 2), Orientation.VERTICAL, 1));
        game.inactive.ships.add(new Ship(sunk, Orientation.VERTICAL, 1));
        if (isSunk) {
            for (Ship ship : game.inactive.ships) {
                ship.sink();
            }
        }
        return game;
    }

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
        Game game = gameFactory(true, Game.GamePhase.BATTLING);
        assertEquals(Game.GamePhase.BATTLING, game.phase);
        game.endTurn();
        assertEquals(Game.GamePhase.END, game.phase);
        System.out.println(game.winner);
    }

    @Test
    void placeShip() {
        Game game = gameFactory(false, Game.GamePhase.PLACING);
        ArrayList<Ship> ships = game.current.ships;
        game.placeShip(new Coordinate(2,2), Orientation.VERTICAL);
        assertEquals(ships.size(), 2);

    }

    @Test
    void fire() {

    }*/
}