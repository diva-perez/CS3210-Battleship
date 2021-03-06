import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InstructionPanel extends JPanel {
    private final MainWindow frame;
    private final JButton back;

    public InstructionPanel(MainWindow frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("INSTRUCTIONS", SwingConstants.CENTER);
        title.setFont(VisualFormatting.headings1);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
        add(BorderLayout.NORTH, title);

        // instructions
        JPanel info = new JPanel();
        JLabel instructions = new JLabel("<html><div style='text-align: justify; text-size: 12pt'>" +
                "PLACING:" +
                "<br>" +
                "When placing a ship, a green highlight will show you the cells your ship will be located in." +
                "<br>" +
                "You can press the 'R' key to rotate your ship's orientation." +
                "<br>" +
                "If your highlight has red 'X's, that is not a valid location to place your ship." +
                "<br>" +
                "Click on a cell to place your ship. Once you place your ship, you cannot move it." +
                "<br>" +
                "Your ships cannot hang off the board or be stacked on one another." +
                "<br>" +
                "Gray cells show your ships placement on the board." +
                "<br><br>" +
                "BATTLING:" +
                "<br>" +
                "When you enter the battling phase, players will alternate turns guessing where their opponents ships are." +
                "<br>" +
                "If your guess is a miss, the cell you guessed will turn white." +
                "<br>" +
                "If your guess is a hit, the cell will turn red." +
                "<br>" +
                "To sink a ship, you must hit all the cells a ship is in." +
                "<br>" +
                "When playing against the computer, you can see if the computer's guess hit or miss right after the waiting screen." +
                "<br><br>" +
                "The game ends when all of your opponents ships have sunk." +
                "</div></html>");
        instructions.setFont(new Font("Arial", Font.PLAIN, 25));
        info.add(instructions);
        add(BorderLayout.CENTER, info);


        // back button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        back = new JButton("Back");
        back.setFont(VisualFormatting.buttons);
        back.addMouseListener(new BackMouseListener());
        buttonPanel.add(back);
        add(BorderLayout.SOUTH, buttonPanel);
    }

    private class BackMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.mainMenu();
            setVisible(false);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            back.setOpaque(true);
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            back.setOpaque(false);
            repaint();
        }
    }
}
