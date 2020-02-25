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

    ArrayList<Car> cars = new ArrayList<>();
    CarController carC = new CarController(cars);
    DrawPanel dP = new DrawPanel(dPsizeX, dPsizeY);
    CarView frame = new CarView("CarSim 1.0", carC, dP, framesizeX, framesizeY);

    /**
     * Konstruktor
     */

    public World () throws IOException {
        Saab95 s = new Saab95();
        s.setY(100);
        Scania sc = new Scania();
        sc.setY(200);
        cars.add(new Volvo240());
        cars.add(s);
        cars.add(sc);
        this.timer.start();
    }

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                //Saves the position of the car before moving it. Is used in actionCollision, if we collide.
                double beforeX = car.getX();
                double beforeY = car.getY();
                car.move();
                if(intersects(car)){
                    actionCollision(car, beforeX, beforeY);
                }
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                dP.moveit(cars);
                // repaint() calls the paintComponent method of the panel
                dP.repaint();
            }
        }
    }
    public boolean intersects(Car car) {
        int availableHeight = framesizeY-300; // Hard coded value is for the the height of the panel + the height of the car image. To be fixed
        int availableWidth = framesizeX-100; // Hard coded value is for the width of the car image. To be fixed

        boolean below = car.getY() > availableHeight;
        boolean above = car.getY() < 0;
        boolean left = car.getX() < 0;
        boolean right = car.getX() > availableWidth;
        return (above || below || left || right);
    }
    public void actionCollision(Car car, double x, double y){
        car.setX(x);
        car.setY(y);

        car.stopEngine();
        car.turnRight();
        car.turnRight();
        car.startEngine();
    }


}
