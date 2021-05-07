import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameBoard extends JPanel {
    public Coordinate coordinateFocus;
    public Orientation orientation = Orientation.VERTICAL;
    public Game game;
    public Cell[] cells;
    public int length;

    public GameBoard(Game game) {
        setLayout(new BorderLayout());
        setOpaque(false);

        // title
        JLabel title = new JLabel(MainWindow.game.getCurrent().toString(), SwingConstants.CENTER);
        title.setOpaque(false);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);

        // gameboard panel
        JPanel gamePanel = new JPanel();
        this.game = game;
        gamePanel.setLayout(new GridLayout(10, 10));
        gamePanel.setOpaque(false);
        this.cells = new Cell[100];

        System.out.println("1" + game.getPhase());
        for (int y = 0; y < Settings.MAX_Y; y++) {
            for (int x = 0; x < Settings.MAX_X; x++) {
                Cell cell = (new Cell(new Coordinate(x, y)));
                this.cells[y * 10 + x] = cell;
                cell.addActionListener(e -> {
                    coordinateFocus = cell.getCoord();
                    System.out.println(coordinateFocus);
                    // Action listener for PLACING
                    if (game.getPhase() == Game.GamePhase.PLACING) {
                        game.placeShip(coordinateFocus, orientation);
                        title.setText(game.getCurrent().toString());
                        // System.out.println("2" + game.getPhase());
                    // Action listener for BATTLING
                    } else {
                        game.fire(coordinateFocus);
                        title.setText(game.getCurrent().toString());
                    }
                    updateGUI();
                });
                cell.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        updateUI();
                    }
                    public void mouseExited(MouseEvent e) {
                        updateUI();
                    }
                });
                gamePanel.add(cell);
            }
        }
        add(gamePanel);
    }

    /*
    highlight method that will be active during

     */
    public void updateGUI() {
        //Color invalidHighlight = Color.ORANGE;
        //Color validHighlight = Color.GREEN;

        Color ship = Color.GRAY;
        Color ocean = Color.BLUE;
        Color hit = Color.RED;
        Color miss = Color.WHITE;
        Color fog = Color.BLUE;

        Game.GamePhase currentPhase = game.getPhase();
        ArrayList<Coordinate> highlights;//this.getHighlightedCoords();
        for (Cell cell : this.cells) {
            Coordinate currentCoord = cell.getCoord();

            // boolean conditions for cell coloring
            boolean hasMyShip = game.current.hasShipAtCoord(currentCoord);
            boolean hasEnemyShip = game.inactive.hasShipAtCoord(currentCoord);
            boolean placing = game.getPhase() == Game.GamePhase.PLACING;
            boolean isHighlighted = coordinateFocus == currentCoord; //highlights.contains(currentCoord);
            boolean battling = game.getPhase() == Game.GamePhase.BATTLING;
            boolean isVisible = game.current.guesses.contains(currentCoord);
            boolean validBattlingHighlight = !isVisible;
            //boolean shipFitsOnBoard = highlights.size() == game.current.nextUnplacedShipLength();
            boolean allHighlightedEmpty = true;
            /*for (Coordinate coordinates : highlights) {
                // if there is a ship at that coordinate, valid = false
                allHighlightedEmpty = allHighlightedEmpty && !(game.current.allShipCoordinates().contains(coordinates));
            }
            boolean validPlacingHighlight = shipFitsOnBoard && allHighlightedEmpty;*/

            // check conditions
            Color chosenColor = Color.BLUE;
            /*if (placing && isHighlighted && validPlacingHighlight) {
                chosenColor = validHighlight;
            }
            if (placing && isHighlighted && !validPlacingHighlight) {
                chosenColor = invalidHighlight;
            }*/
            if (placing && isHighlighted && hasMyShip) {
                chosenColor = ship;
            }
            if (placing && isHighlighted && !hasMyShip) {
                chosenColor = ocean;
            }
            if (battling && isVisible && hasEnemyShip) {
                chosenColor = hit;
            }
            if (battling && isVisible && !hasEnemyShip) {
                chosenColor = miss;
            }
            if (battling && validBattlingHighlight) {
                chosenColor = fog;
            }
            cell.setBackground(chosenColor);
        }
    }

    /*private ArrayList<Coordinate> getHighlightedCoords() {
        ArrayList<Coordinate> highlights = new ArrayList<>();
        if (game.getPhase() == Game.GamePhase.PLACING) {
            int highlightLength = game.current.nextUnplacedShipLength();
            while (highlightLength > 0) {
                Coordinate next = coordinateFocus.getEndFrom(highlightLength, orientation);
                highlights.add(next);
                highlightLength--;
                if (!next.onBoard()) {
                    break;
                }
            }
        }
        else {
        }
        return highlights;
    }*/
}

    /*public GameBoard(Game game) {
        setLayout(new BorderLayout());
        setOpaque(false);
        // title
        JLabel title = new JLabel(MainWindow.game.getCurrent().toString(), SwingConstants.CENTER);
        title.setOpaque(false);
        title.setFont(new Font("Lucida Bright", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(title, BorderLayout.NORTH);

        JPanel gamePanel = new JPanel();
        this.game = game;
        gamePanel.setLayout(new GridLayout(10, 10));
        gamePanel.setOpaque(false);

        for (int y = 1; y <= Settings.MAX_Y; y++) {     // + 1 to get all the tiles to paint
            for (int x = 0; x < Settings.MAX_X; x++) {
                this.cell = (new Cell(new Coordinate(x, y)));
                this.cell.addActionListener(e -> {
                    coordinate = cell.getCoord();
                    System.out.println(coordinate);
                    game.placeShip(coordinate, orientation);
                    title.setText(game.getCurrent().toString());
                    updateGUI();
                });
                this.cell.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        coordinate = cell.getCoord();
                        System.out.println(coordinate);
                        updateGUI();
                    }

                    public void mouseExited(MouseEvent e) {
                        updateGUI();
                    }
                });
                gamePanel.add(cell);
            }
            add(BorderLayout.CENTER, gamePanel);
        }
    }*/