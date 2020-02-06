import java.awt.*;

public class Scania extends Car {

    public Scania(){
        nrDoors = 2;
        color = Color.black;
        enginePower = 125;
        modelName = "Scania";
        stopEngine();
    }
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
    


}
