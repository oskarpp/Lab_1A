import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * A flatbed Car that is able to load cars that does not have a flatbed.
 */
public class carTransporter extends Flatbed{

    public carTransporter(){
        nrDoors = 2;
        color = Color.yellow;
        enginePower = 125;
        modelName = "Mercedes";
        stopEngine();
        flatbedAngle = 45;
        maxAngle = 45;
        minAngle = -45;
        safeAngle = 45;
    }

    /**
     * Specifies the max amount of cars that can be loaded
     */
    int maxCapacity = 4;

    private double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Overrides the method that lifts/lowers the flatbed with a specific degree
     * this is because carTransporter should only be able to switch between min and max mode.
     * @param degree
     */
    @Override
    public void flatbedIncrement(int degree){
        flatbedAngle = maxAngle;
        checkIfSafe();
    }
    @Override
    public void flatbedDecrement(int degree){
        flatbedAngle = minAngle;
        checkIfSafe();
    }

    /**
     * Loads a car onto the carTransporter if it meets the requirements. Error handling added.
     * @param car a Car that is not a flatbed truck.
     */
    public void loadCar(Car car){
        if(car instanceof Flatbed){
            throw new IllegalArgumentException("Too big. Cannot load flatbed trucks.");
        }
        else if(this.getX() != car.getX() || this.getY() != car.getY()){
            throw new IllegalArgumentException("Too far away, cannot load.");
        } else if (getDeque().size() == maxCapacity) {
            throw new IllegalArgumentException("Transport is full.");
        } else if(car.isLoaded){
            throw new IllegalArgumentException("This car is already loaded.");
        }
        else if(this.getFlatbedAngle() != minAngle){
            throw new IllegalArgumentException("Ramp is up, cannot load.");
        } else {
            getDeque().push(car);
            car.isLoaded = true;
        }
    }

    /**
     * Unloads the last car if the ramp is down
     */
    public void unloadCar(){
        if(this.getFlatbedAngle() == minAngle){
            Car x = (Car) getDeque().pop();
            x.isLoaded = false;
        } else {
            throw new IllegalArgumentException("Ramp is up, cannot unload.");
        }
    }

}
