import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public ArrayList<Player> players;
    public Player current;
    public Player inactive;
    public GamePhase phase;
    public Player winner;

    public Game() {
        this.current = new Player("Player One");
        // check settings to see if 2 player game or 1 player game
        if (MainWindow.settings.getComputer()) {
            this.inactive = new Player("Computer");
            this.inactive.placeNextShip(new Coordinate(0, 0), Orientation.VERTICAL);
        } else {
            this.inactive = new Player("Player Two");
        }
        this.players = new ArrayList<>();
        players.add(this.current);
        players.add(this.inactive);
        this.phase = GamePhase.PLACING;
        this.winner = null;
    }

    // Get methods
    public Player getCurrent() {
        return this.current;
    }
    public GamePhase getPhase() {
        return this.phase;
    }

    public boolean allPlayersShipsPlaced() {
        /*
         * checks to see if all player ships have been placed
         * needed to end player turns during placement phase
         */
        boolean shipsPlaced = false;
        for (Player p : this.players) {
            shipsPlaced = p.allShipsPlaced();
        }
        return shipsPlaced;
    }

    public void endTurn() {
        /*
         * end player turns during placing and battling phase
         * also checks to see if a player has met the win conditions
         * handles changing of current and inactive players
         */
        // check if win condition is met
        if (this.phase == GamePhase.BATTLING && (this.inactive.unsunkShips()).size() == 0) {
            this.phase = GamePhase.END;
            this.winner = this.current;
        }
        // should enter battle phase (from PLACING)
        else if (this.phase == GamePhase.PLACING && this.allPlayersShipsPlaced()) {
            this.phase = GamePhase.BATTLING;
            for (Player p : this.players) {
                p.hideShips();
            }
        }
        Player temp = this.current;
        this.current = this.inactive;
        this.inactive = temp;
    }

    public void placeShip(Coordinate coordinates, Orientation orientation) {
        assert this.phase == GamePhase.PLACING;
        this.current.placeNextShip(coordinates, orientation);
        if (this.current.allShipsPlaced()) {
            assert this.current.ships.contains(coordinates) : "player ships list is not correct";
            this.endTurn();
        }
    }

    public boolean fire(Coordinate coordinates) {
        assert !(this.current.guesses.contains(coordinates));
        this.current.guesses.add(coordinates);
        boolean didHit = this.inactive.checkShipsHit(coordinates);
        return didHit;
    }


    public enum GamePhase {
        PLACING,
        BATTLING,
        END
    }

}