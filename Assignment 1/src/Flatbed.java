import java.util.Deque;

/**
 * Subclass to Car. Adds methods for lowering and lifting flatbeds.
 * Adds variables related to the flatbeds.
 */
public abstract class Flatbed extends Car{

    /**
     * flatbedAngle holds the value of the current angle of the flatbed
     * maxAngle/minAngle - Maximum and Minimum angle for the flatbed.
     */
    public int flatbedAngle;
    int maxAngle;
    int minAngle;

    /**
     * Getter
     * @return
     */
    public int getFlatbedAngle() {
        return flatbedAngle;
    }

    /**
     * Calculates the maximum value allowed to lift a flatbed by
     * @return
     */
    public int allowedDegree(){
        return Math.abs(maxAngle - minAngle);
    }

    /**
     * Two different ways to lower and lift flatbed.
     * Call with a degree as argument to lower or lift with specific degree.
     * Call without the argument to flip between max and min mode.
     * Checks that the trucks is not moving
     * @param degree this degree (value limited by allowedDegree)
     */
    public void liftFlatbed(int degree){
        if (getCurrentSpeed() == 0 && degree >= 0 && degree <= allowedDegree()) {
            int i = maxAngle;
            flatbedIncrement(degree);
            int j = flatbedAngle;
            if (i < j) {
                flatbedAngle = i;
            } else if (j <= i) {
                flatbedAngle = j;
            }
        } else {
            throw new IllegalArgumentException(INV_ARG);
        }
    }
    public void lowerFlatbed(int degree){
        if (currentSpeed == 0 && degree >= 0 && degree <= allowedDegree()) {
            flatbedDecrement(degree);
        } else {
            throw new IllegalArgumentException(INV_ARG);
        }
    }
    public void liftFlatbed(){
        if(currentSpeed == 0){
            flatbedIncrement();
        }
    }
    public void lowerFlatbed(){
        if(currentSpeed == 0){
            flatbedDecrement();
        }
    }


    public void flatbedIncrement(int degree){
        flatbedAngle = flatbedAngle + degree;
    }
    public void flatbedDecrement(int degree){
        int i = minAngle;
        flatbedAngle = flatbedAngle - degree;
        int j = flatbedAngle;
        if (i > j) {
            flatbedAngle = i;
        } else if (j >= i) {
            flatbedAngle = j;
        }
    }

    public void flatbedIncrement(){
        flatbedAngle = maxAngle;
    }
    public void flatbedDecrement(){
        if(getCurrentSpeed() == 0){
            flatbedAngle = minAngle;
        }
    }



}
