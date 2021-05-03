import javax.swing.*;
import java.awt.*;

public class PlacementPanel extends JPanel {
    private MainWindow frame;
    public PlacementPanel(MainWindow frame) {
        this.frame = frame;
        setOpaque(false);
        setLayout(new BorderLayout());


    }
}
