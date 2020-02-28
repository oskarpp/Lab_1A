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
public class CarController implements CheckForNewVehicle{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    //ArrayList<Vehicle> cars;
    ArrayList<Vehicle> listOfCar = new ArrayList<>();

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public CarController (ArrayList<Vehicle> listOfCar){
        this.listOfCar = listOfCar;
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

    Vehicle addCar(){
        Vehicle v = new Volvo240();
        //listOfMovable.add(v);
        listOfCar.add(v);
        return v;
    }
    void removeCar() {
        listOfCar.remove(0);
    }

    @Override
    public ArrayList<Vehicle> getList() {
        return listOfCar;
    }
}
