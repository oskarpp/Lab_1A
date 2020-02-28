import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    //ArrayList<Vehicle> cars;
    ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public CarController (ArrayList<Vehicle> listOfCar){
        this.listOfVehicles = listOfCar;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : listOfVehicles) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : listOfVehicles){
            car.brake(brake);
        }
    } // Added for brake
    void setTurboOn() {
        for (Vehicle car : listOfVehicles){
            if (car instanceof HasTurbo){
                ((HasTurbo) car).setTurboOn();
            }
        }
    }
    void setTurboOff() {
        for (Vehicle car : listOfVehicles){
            if (car instanceof HasTurbo){
                ((HasTurbo) car).setTurboOff();
            }
        }
    }
    void liftFlatbed(){
        for (Vehicle car : listOfVehicles){
            if (car instanceof HasFlatbed){
                ((HasFlatbed) car).liftFlatbed();
            }
        }
    }
    void lowerFlatbed(){
        for (Vehicle car : listOfVehicles){
            if (car instanceof HasFlatbed){
                ((HasFlatbed) car).lowerFlatbed();
            }
        }
    }
    void startCars(){
        for (Vehicle car : listOfVehicles) {
            car.startEngine();
        }
    }
    void stopCars(){
        for (Vehicle car : listOfVehicles){
            car.stopEngine();
        }
    }

    Vehicle addCar(){
        Vehicle v = new Volvo240();
        listOfVehicles.add(v);
        return v;
    }
    void removeCar() {
       listOfVehicles.remove(listOfVehicles.size()-1);
        }
}
