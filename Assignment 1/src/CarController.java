import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Saab95 s = new Saab95();
        s.setY(100);
        Scania sc = new Scania();
        sc.setY(200);
        cc.cars.add(new Volvo240());
        cc.cars.add(s);
        cc.cars.add(sc);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
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
                frame.drawPanel.moveit(cars);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    } // Added for brake
    void setTurboOn() {
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void setTurboOff() {
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void liftFlatbed(){
        for (Car car : cars){
            if (car instanceof Flatbed){
                ((Flatbed) car).liftFlatbed();
            }
        }
    }
    void lowerFlatbed(){
        for (Car car : cars){
            if (car instanceof Flatbed){
                ((Flatbed) car).lowerFlatbed();
            }
        }
    }
    void startCars(){
        for (Car car : cars) {
            car.startEngine();
        }
    }
    void stopCars(){
        for (Car car : cars){
            car.stopEngine();
        }
    }

    public boolean intersects(Car car) {
        int a = frame.getCarViewHeigth()-300; // Hard coded value is for the the height of the panel + the height of the car image. To be fixed
        int b = frame.getCarViewWidth() -100; // Hard coded value is for the width of the car image. To be fixed

        boolean below = car.getY() > a;
        boolean above = car.getY() < 0;
        boolean left = car.getX() < 0;
        boolean right = car.getX() > b;
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
