import javax.swing.*;
import java.awt.*;


public class Cell extends JButton {
    private CellState cellState = CellState.OCEAN;
    private Cell cell;
    public Cell() {
        cell = this;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
    }

    /**
     * 5 cell states
     */
    private enum CellState {
        OCEAN,          // empty cell
        SHIP_VISIBLE,   // during placement phase
        SHIP_HIDDEN,    // during battle
        MISS,           // bombed empty tile during battle
        HIT             //bombed ship tile during battle
    }

    /**
     * Places a ship on a cell
     *
     * Still need to implement a check that limits the number of ships to one (or variable for later)
     *
     */
    public void placeShip() {
        this.cellState = CellState.SHIP_VISIBLE;
        draw();
    }

    /**
     * Hides ship tile if there is one
     * for game play
     */
    public void hideShip() {
        if (this.cellState == CellState.SHIP_VISIBLE) {
            this.cellState = CellState.SHIP_HIDDEN;
            draw();
        }
    }

    /**
     * If there is a ship = hit, else = miss
     */
    public void dropBomb() {
        // HIT case
        if (this.cellState == CellState.SHIP_HIDDEN) {
            this.cellState = CellState.HIT;
            draw();
        }
        // MISS case
        else {
            this.cellState = CellState.MISS;
            draw();
        }
    }

    //ERROR CHECKING
        //don't lose a turn if player tries to pick a cell that was already checked
        //

    /**
     * Repaints cell to reflect current state
     */
    private void draw() {
        switch (this.cellState) {
            case SHIP_HIDDEN:
            case OCEAN:
                setBackground(Color.BLUE);
                repaint();
                break;

            case SHIP_VISIBLE:
                setBackground(Color.GRAY);
                repaint();
                break;

            case HIT:
                setBackground(Color.RED);
                repaint();
                break;

            case MISS:
                setBackground(Color.WHITE);
                repaint();
                break;
        }
    }
}
