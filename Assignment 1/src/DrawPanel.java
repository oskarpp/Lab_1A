import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    // To keep track of a singel cars position

    ArrayList<Movable> listOfMovable;

    private Assets assets = new Assets();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Movable> movables) throws IOException {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.listOfMovable = movables;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Movable m : listOfMovable){
            g.drawImage(assets.get(m),(int) m.getX(), (int) m.getY(), null);
        }
    }
}
