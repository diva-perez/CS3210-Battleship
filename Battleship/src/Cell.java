import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;


public class Cell extends JButton {
    private Coordinate coordinate;
    private Image image;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
    }

    public Cell(Coordinate coordinate, String filePath) {
        this.coordinate = coordinate;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.BLUE);
    }

    public Coordinate getCoord() {
        return this.coordinate;
    }

    public void setIcon(String s) {
        try {
            image = ImageIO.read(new File(s));
            setIcon(new ImageIcon(image));
        } catch (Exception e) {
            System.err.println("Couldn't find image: " + s);
            setBackground(Color.GRAY);
        }
    }
}