import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    // To keep track of a singel cars position

    //ArrayList<Movable> listOfMovable;
    ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

    private Assets assets = new Assets();

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
        for (Movable m : listOfVehicles) {
            if (listOfVehicles.size() == 0){
                super.paintComponent(g);
                g.drawImage(null, 0,0,null);
            } else {
                super.paintComponent(g);
                g.drawImage(assets.get(m), (int) m.getX(), (int) m.getY(), null);

            }
            }
    }
}
