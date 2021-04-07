import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    public Cell(String s) {
        JButton cell = new JButton(s);
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

    }

}
