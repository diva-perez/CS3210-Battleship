import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Game {
    public ArrayList<Player> players;
    public Player current = new Player("Player One");
    public Player inactive;
    public GamePhase phase;
    public Optional<Player> winner;

    public Game() {
        this.inactive = new Player("Player Two");
        this.players = new ArrayList<>(
                Arrays.asList(current, this.inactive));
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
        for (Player p : this.players) {
            if(p.allShipsPlaced()) {
                return true;
            }
        }
        return false;
    }

    public void endTurn() {
        // check if win condition is met
        if (this.phase == GamePhase.BATTLING && (this.inactive.unsunkShips()).size() == 0) {
            this.phase = GamePhase.END;
            this.winner = Optional.ofNullable(this.current);
        }
        // should enter battle phase (from PLACING)
        else if (this.phase == GamePhase.PLACING && this.allPlayersShipsPlaced()) {
            this.phase = GamePhase.BATTLING;
            for (Player p : this.players) {
                p.hideShips();
            }
        }
        // switch turns
        Player temp = current;
        current = this.inactive;
        this.inactive = temp;
    }

    public void placeShip(Coordinate coordinates, Orientation orientation) {
        assert this.phase == GamePhase.PLACING;
        this.current.placeNextShip(coordinates, orientation);
        if (this.current.allShipsPlaced()) {
            this.endTurn();
        }
    }

    public boolean fire(Coordinate coordinates) {
        assert !(this.current.guesses.contains(coordinates));
        this.current.guesses.add(coordinates);
        boolean didHit = this.inactive.checkShipsHit(coordinates);
        this.endTurn();
        return didHit;
    }


    public enum GamePhase {
        PLACING,
        BATTLING,
        END
    }

}