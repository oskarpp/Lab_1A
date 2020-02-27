import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class World {
    int framesizeX = 800;
    int framesizeY = 800;
    int dPsizeX = 800;
    int dPsizeY = framesizeY - 240;

    ArrayList<Car> listOfCar = new ArrayList<>();
    ArrayList<Movable> listOfMovable = new ArrayList<>();

    CarController carC = new CarController(listOfCar);
    DrawPanel dP = new DrawPanel(dPsizeX, dPsizeY);
    CarView frame = new CarView("CarSim 1.0", carC, dP, framesizeX, framesizeY);

    /**
     * Konstruktor
     */
    Car volvo;
    Car saab;
    Car scania;

    public World () throws IOException {
        volvo = new Volvo240();

        saab = new Saab95();
        saab.setY(100);

        scania = new Scania();
        scania.setY(200);

        listOfCar.add(volvo);
        listOfCar.add(saab);
        listOfCar.add(scania);
        listOfMovable.add(volvo);
        listOfMovable.add(saab);
        listOfMovable.add(scania);

        this.timer.start();
    }

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Movable m : listOfMovable) {
                //Saves the position of the car before moving it. Is used in actionCollision, if we collide.
                double beforeX = m.getX();
                double beforeY = m.getY();
                m.move();
                if(m.intersects(framesizeY, framesizeX)){
                    m.actionCollision(beforeX, beforeY);
                }
                int x = (int) Math.round(m.getX());
                int y = (int) Math.round(m.getY());
                dP.moveit(listOfMovable);
                // repaint() calls the paintComponent method of the panel
                dP.repaint();
            }
        }
    }


}
