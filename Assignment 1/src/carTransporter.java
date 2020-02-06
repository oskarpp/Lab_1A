import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    }

    Deque<? super Car> stack = new ArrayDeque(4);

    private double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        if(flatbedAngle == 0){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Added condition that flatbed must be lowered to increment speed.
     * @param degree
     */
    @Override
    public void flatbedIncrement(int degree){
        flatbedAngle = maxAngle;
    }
    @Override
    public void flatbedDecrement(int degree){
        if(getCurrentSpeed() == 0){
            flatbedAngle = minAngle;
        }
    }

    public void loadCar(Car car){
        if(car instanceof Flatbed){
            throw new IllegalArgumentException("Too big. Cannot load flatbed trucks.");
        }
        else if(this.getX() != car.getX() || this.getY() != car.getY()){
            throw new IllegalArgumentException("Too far away, cannot load.");
        }
        else { stack.push(car); }

    }

    public void unloadCar(){
        
        stack.pop();
    }

}
