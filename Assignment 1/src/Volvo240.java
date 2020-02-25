/**
 * Is a sub class to abstract class Car.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * Standard values for a Volvo240 being created
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        }

    /**
     * Checks the state of a number of things and returns a value used to calculate speed increase/decrease
     * @return
     */
    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
