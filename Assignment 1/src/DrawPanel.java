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

    ArrayList<Car> carList = new ArrayList<>();

    private Assets assets = new Assets();

    // TODO: Make this genereal for all cars
    void moveit(ArrayList<Car> cars){
        this.carList = cars;
    }
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) throws IOException {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Car car : carList){
            g.drawImage(assets.get(car),(int) car.getX(), (int) car.getY(), null);
        }
    }
}
