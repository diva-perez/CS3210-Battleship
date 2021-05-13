import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JPanel implements KeyListener {
    private Coordinate coordinateFocus;
    private Coordinate RUQ;
    private Coordinate LLQ;
    private Coordinate RLQ;
    private Orientation orientation = Orientation.VERTICAL;
    private final CardLayout card;
    private final Cell[] cells;
    public Game game;
    public JLabel title;
    public MainWindow frame;

    public GameBoard(Game game, MainWindow frame) {
        this.frame = frame;
        this.game = game;
        card = new CardLayout();
        // need this container for the card layout to work properly
        Container c = this;
        setLayout(card);
        setOpaque(false);
        setFocusable(true);
        addKeyListener(this);

        // wait card for computer
        JPanel waitCard = new JPanel();
        waitCard.setLayout(new BorderLayout());
        waitCard.setOpaque(false);
        JLabel waitText = new JLabel("The Computer is Thinking", SwingConstants.CENTER);
        waitText.setOpaque(false);
        waitText.setFont(VisualFormatting.headings1);
        JLabel waitText2 = new JLabel("Click anywhere to continue", SwingConstants.CENTER);
        waitText2.setOpaque(false);
        waitText2.setFont(VisualFormatting.headings2);
        waitText2.setForeground(Color.WHITE);
        waitCard.add(waitText, BorderLayout.NORTH);
        waitCard.add(waitText2, BorderLayout.CENTER);
        waitCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // need to add code to get the computer to do it's guesses
                Random random = new Random();
                coordinateFocus = new Coordinate(random.nextInt(10), random.nextInt(10));
                game.fire(coordinateFocus);
                if (MainWindow.settings.getBombSize()) {
                    RUQ = new Coordinate(coordinateFocus.x + 1, coordinateFocus.y);
                    LLQ = new Coordinate(coordinateFocus.x, coordinateFocus.y + 1);
                    RLQ = new Coordinate(coordinateFocus.x + 1, coordinateFocus.y + 1);
                    game.fire(RUQ);
                    game.fire(LLQ);
                    game.fire(RLQ);
                }
                game.endTurn();
                card.show(c, "link 1");
            }
        });

        // game card
        JPanel gameCard = new JPanel();
        gameCard.setLayout(new BorderLayout());
        gameCard.setOpaque(false);
        title = new JLabel(game.getCurrent().toString(), SwingConstants.CENTER);
        title.setOpaque(false);
        title.setFont(VisualFormatting.headings1);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        gameCard.add(title, BorderLayout.NORTH);

        add(gameCard, "link 1");
        add(waitCard, "link 2");

        // gameboard panel
        JPanel spacer = new JPanel();
        spacer.setOpaque(false);
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
                            game.phase = Game.GamePhase.BATTLING;
                            game.fire(coordinateFocus);
                            if (MainWindow.settings.getBombSize()) {
                                RUQ = new Coordinate(coordinateFocus.x + 1, coordinateFocus.y);
                                LLQ = new Coordinate(coordinateFocus.x, coordinateFocus.y + 1);
                                RLQ = new Coordinate(coordinateFocus.x + 1, coordinateFocus.y + 1);
                                game.fire(RUQ);
                                game.fire(LLQ);
                                game.fire(RLQ);
                            }
                            game.endTurn();
                        }
                        title.setText(game.getCurrent().toString());

                    // Action listener for BATTLING
                    } else if (game.getPhase() == Game.GamePhase.BATTLING){
                        // display computer thinking card
                        if (game.inactive.toString().equals("Computer")) {
                            card.show(this, "link 2");
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
        spacer.add(gamePanel);
        gameCard.add(spacer);
    }

    public void updateGUI() {
        //Game.GamePhase currentPhase = game.getPhase();
        ArrayList<Coordinate> highlights = this.getHighlightedCoords();
        title.setText(game.getCurrent().toString());
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
                cell.setIcon("ocean.png");
            }
            if (placing && isHighlighted && validPlacingHighlight) {
                cell.setIcon("highlight.png");
            }
            if (placing && isHighlighted && !validPlacingHighlight) {
                cell.setIcon("invalid.png");
            }
            if (placing && hasMyShip) {
                cell.setIcon("ship_1.png");
                if (orientation == Orientation.VERTICAL) {
                }
            }
            if (battling && isVisible && hasEnemyShip) {
                cell.setIcon("hit.png");
            }
            if (battling && isVisible && !hasEnemyShip) {
                cell.setIcon("miss.png");
            }
            if (battling && validBattlingHighlight) {
                cell.setIcon("ocean.png");
            }
            if (battling && isHighlighted && validBattlingHighlight) {
                cell.setIcon("bomb.png");
            }
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
                highlights.add(RUQ);
                highlights.add(LLQ);
                highlights.add(RLQ);
            }
        }
        return highlights;
    }

    // KeyListener Implementation
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
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
