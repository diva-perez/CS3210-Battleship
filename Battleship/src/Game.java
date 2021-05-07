import org.junit.Assert;

import java.util.ArrayList;
import java.util.Optional;

public class Game {
    public ArrayList<Player> players;
    public Player current = new Player("Player One");
    public Player inactive;
    public GamePhase phase;
    public Optional<Player> winner;

    public Game() {
        this.inactive = new Player("Player Two");
        this.players = new ArrayList<>();
        players.add(this.current);
        players.add(this.inactive);
        this.phase = GamePhase.PLACING;
        this.winner = null;
        System.out.println(players.toString());
        System.out.println(this.current.unplacedShipLengths);
        System.out.println(this.inactive.unplacedShipLengths);


    }

    // Get methods
    public Player getCurrent() {
        return this.current;
    }
    public GamePhase getPhase() {
        return this.phase;
    }

    public boolean allPlayersShipsPlaced() {
        boolean shipsPlaced = false;
        for (Player p : this.players) {
            System.out.println(p);
            if(p.allShipsPlaced()) {
                shipsPlaced = true;
            }
            else {
                shipsPlaced = false;
            }
                System.out.println(p.allShipsPlaced());
                System.out.println(this.current.unplacedShipLengths);
                System.out.println(this.inactive.unplacedShipLengths);
                //return true;
                // breaks out of loop and doesn't check player 2
            }
        return shipsPlaced;
        }


    public void endTurn() {
        System.out.println("Current player:" + this.current.toString() + "\nInactive Player:" + this.inactive.toString());
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
        Player temp = this.current;
        this.current = this.inactive;
        this.inactive = temp;
    }

    public void placeShip(Coordinate coordinates, Orientation orientation) {
        assert this.phase == GamePhase.PLACING;
        this.current.placeNextShip(coordinates, orientation);
        if (this.current.allShipsPlaced()) {
            this.endTurn();
            assert this.current.ships.contains(coordinates) : "player ships list is not correct";
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