import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameBoard extends JPanel implements KeyListener {
    private Coordinate coordinateFocus;
    private Coordinate RUQ;
    private Coordinate LLQ;
    private Coordinate RLQ;
    private Orientation orientation = Orientation.VERTICAL;
    public Game game;
    private final Cell[] cells;
    public MainWindow frame;

    public GameBoard(Game game, MainWindow frame) {
        this.frame = frame;
        this.game = game;
        CardLayout card = new CardLayout();
        setLayout(card);
        setOpaque(false);
        setFocusable(true);
        addKeyListener(this);
        JPanel waitCard = new JPanel();
        waitCard.setLayout(new BorderLayout());
        waitCard.setOpaque(false);
        JPanel gameCard = new JPanel();
        gameCard.setLayout(new BorderLayout());
        gameCard.setOpaque(false);
        add(gameCard, "link 1");
        add(waitCard, "link 2");

        // title
        JLabel title = new JLabel(game.getCurrent().toString(), SwingConstants.CENTER);
        title.setOpaque(false);
        title.setFont(new Font("Serif", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        gameCard.add(title, BorderLayout.NORTH);

        // gameboard panel
        JPanel gamePanel = new JPanel();
        this.game = game;
        gamePanel.setLayout(new GridLayout(10, 10));
        gamePanel.setOpaque(false);
        this.cells = new Cell[100];

        for (int y = 0; y < Settings.MAX_Y; y++) {
            for (int x = 0; x < Settings.MAX_X; x++) {
                Cell cell = (new Cell(new Coordinate(x, y)));
                this.cells[y * 10 + x] = cell;
                cell.addActionListener(e -> {
                    coordinateFocus = cell.getCoord();
                    // Action listener for PLACING
                    if (game.getPhase() == Game.GamePhase.PLACING) {
                        game.placeShip(coordinateFocus, orientation);
                        // skip Computer's placing turn since their ships are already placed
                        if (game.getCurrent().toString().equals("Computer")) {
                            game.endTurn();
                            game.phase = Game.GamePhase.BATTLING;
                        }
                        title.setText(game.getCurrent().toString());

                    // Action listener for BATTLING
                    } else if (game.getPhase() == Game.GamePhase.BATTLING){
                        if (game.inactive.toString().equals("Computer")) {
                            card.show(this, "link 2");
                            // displays wait panel and wait for mouse click from player 1 to generate guess coordinate
                        }
                        game.fire(coordinateFocus);
                        // fire consecutively for bigger bomb
                        if (MainWindow.settings.getBombSize()) {
                            // additional bomb cells
                            game.fire(RUQ);
                            game.fire(LLQ);
                            game.fire(RLQ);
                        }
                        this.game.endTurn();
                        title.setText(game.getCurrent().toString());
                        if (game.getPhase() == Game.GamePhase.END) {
                            frame.endGame();
                        }
                    }
                    updateGUI();
                });
                cell.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        coordinateFocus = cell.getCoord();
                        requestFocusInWindow();
                        updateGUI();
                    }
                    public void mouseExited(MouseEvent e) {
                        coordinateFocus = cell.getCoord();
                        updateGUI();
                    }
                });
                gamePanel.add(cell);
            }
        }
        gameCard.add(gamePanel);
    }

    public void updateGUI() {
        /*
         * updates the cell colors of the entire board
         */
        Color invalidHighlight = Color.ORANGE;
        Color validHighlight = Color.GREEN;
        Color chosenColor = Color.BLUE;
        Color ship = Color.GRAY;
        Color ocean = Color.BLUE;
        Color hit = Color.RED;
        Color miss = Color.WHITE;
        Color fog = Color.BLUE;

        //Game.GamePhase currentPhase = game.getPhase();
        ArrayList<Coordinate> highlights = this.getHighlightedCoords();
        for (Cell cell : this.cells) {
            Coordinate currentCoord = cell.getCoord();

            // boolean conditions for cell coloring
            boolean hasMyShip = game.current.hasShipAtCoord(currentCoord);
            boolean hasEnemyShip = game.inactive.hasShipAtCoord(currentCoord);
            boolean placing = game.getPhase() == Game.GamePhase.PLACING;
            boolean isHighlighted = highlights.contains(cell.getCoord());
            boolean battling = game.getPhase() == Game.GamePhase.BATTLING;
            boolean isVisible = game.current.guesses.contains(currentCoord);
            boolean validBattlingHighlight = !isVisible;
            // need "placing &&" to prevent index out of bound error
            // will run nextUnplacedShipLength() only during placing phase
            boolean shipFitsOnBoard = placing && highlights.size() == game.current.nextUnplacedShipLength();
            boolean allHighlightedEmpty = true;
            for (Coordinate coordinates : highlights) {
                // if there is a ship at that coordinate, valid = false
                allHighlightedEmpty = allHighlightedEmpty && !(game.current.allShipCoordinates().contains(coordinates));
            }
            boolean validPlacingHighlight = shipFitsOnBoard && allHighlightedEmpty;

            // check conditions for each cell
            if (placing && !isHighlighted && !hasMyShip) {
                chosenColor = ocean;
            }
            if (placing && isHighlighted && validPlacingHighlight) {
                chosenColor = validHighlight;
            }
            if (placing && isHighlighted && !validPlacingHighlight) {
                chosenColor = invalidHighlight;
            }
            if (placing && hasMyShip) {
                chosenColor = ship;
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
            if (battling && isHighlighted && validBattlingHighlight) {
                chosenColor = validHighlight;
            }
            cell.setBackground(chosenColor);
        }
    }

    private ArrayList<Coordinate> getHighlightedCoords() {
        /*
         * adds coordinates to be highlighted to a "highlights" list
         * for bombs and ship placement
         */
        ArrayList<Coordinate> highlights = new ArrayList<>();
        if (game.getPhase() == Game.GamePhase.PLACING) {
            for (int i = 1; i <= game.current.nextUnplacedShipLength(); i++) {
                Coordinate next = coordinateFocus.getEndFrom(i, orientation);
                if (!next.onBoard()) {
                    break;
                }
                highlights.add(next);
            }
        } else if (game.getPhase() == Game.GamePhase.BATTLING) {
            // highlight entire bomb size
            highlights.add(coordinateFocus);
            if (MainWindow.settings.getBombSize()) {
                this.RUQ = new Coordinate(coordinateFocus.x + 1, coordinateFocus.y);
                this.LLQ = new Coordinate(coordinateFocus.x, coordinateFocus.y + 1);
                this.RLQ = new Coordinate(coordinateFocus.x + 1, coordinateFocus.y + 1);
                highlights.add(RUQ);
                highlights.add(LLQ);
                highlights.add(RLQ);
            }
        }
        return highlights;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        int rotateKey = KeyEvent.VK_R;
        if (key == rotateKey) {
            if (orientation == Orientation.VERTICAL) {
                orientation = Orientation.HORIZONTAL;
            } else {
                orientation = Orientation.VERTICAL;
            }
        }
        updateGUI();
    }
}
