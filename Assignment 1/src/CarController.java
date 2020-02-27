import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
 // TEST kommentar!
public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    ArrayList<Car> cars;

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public CarController (ArrayList<Car> carFromWorld){
        this.cars = carFromWorld;
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
            if (car instanceof HasTurbo){
                ((HasTurbo) car).setTurboOn();
            }
        }
    }
    void setTurboOff() {
        for (Car car : cars){
            if (car instanceof HasTurbo){
                ((HasTurbo) car).setTurboOff();
            }
        }
    }
    void liftFlatbed(){
        for (Car car : cars){
            if (car instanceof HasFlatbed){
                ((HasFlatbed) car).liftFlatbed();
            }
        }
    }
    void lowerFlatbed(){
        for (Car car : cars){
            if (car instanceof HasFlatbed){
                ((HasFlatbed) car).lowerFlatbed();
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
}
