import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
 // TEST kommentar!
public class CarController implements IList{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    //ArrayList<Vehicle> cars;
    int framesizeX;
    int framesizeY;
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public CarController (int framesizeX, int framesizeY){
        this.framesizeX = framesizeX;
        this.framesizeY = framesizeY;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : listOfCar) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : listOfCar){
            car.brake(brake);
        }
    } // Added for brake
    void setTurboOn() {
        for (Vehicle car : listOfCar){
            if (car instanceof HasTurbo){
                ((HasTurbo) car).setTurboOn();
            }
        }
    }
    void setTurboOff() {
        for (Vehicle car : listOfCar){
            if (car instanceof HasTurbo){
                ((HasTurbo) car).setTurboOff();
            }
        }
    }
    void liftFlatbed(){
        for (Vehicle car : listOfCar){
            if (car instanceof HasFlatbed){
                ((HasFlatbed) car).liftFlatbed();
            }
        }
    }
    void lowerFlatbed(){
        for (Vehicle car : listOfCar){
            if (car instanceof HasFlatbed){
                ((HasFlatbed) car).lowerFlatbed();
            }
        }
    }
    void startCars(){
        for (Vehicle car : listOfCar) {
            car.startEngine();
        }
    }
    void stopCars(){
        for (Vehicle car : listOfCar){
            car.stopEngine();
        }
    }

    void addCar(){
        if(listOfCar.size() < 10){
            Vehicle v = VolvoFactory.createVolvo240();;
            listOfCar.add(v);
        } else {/*do nothing*/}

    }
    void removeCar(){
        if(listOfCar.size() != 0){
            listOfCar.remove(0);
        } else { /*Does not do anything!*/}

    }

    void moveOnTick(){
        for (Vehicle m : listOfCar) {
            m.movement(m, framesizeY, framesizeX);
        }
    }
}
