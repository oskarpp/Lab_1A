import java.awt.*;

public class Scania extends Flatbed{

    public Scania(){
        nrDoors = 2;
        color = Color.black;
        enginePower = 125;
        modelName = "Scania";
        stopEngine();
        flatbedAngle = 0;
        maxAngle = 70;
        minAngle = 0;
    }

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

}
