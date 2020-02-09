import java.util.Deque;

/**
 * Subclass to Car. Adds methods for lowering and lifting flatbeds.
 * Adds variables related to the flatbeds.
 */
public abstract class Flatbed extends Car{

    /**
     * flatbedAngle holds the value of the current angle of the flatbed
     */
    public int flatbedAngle;
    /**
     * maxAngle/minAngle - Maximum and Minimum angle for the flatbed.
     */
    int maxAngle;
    int minAngle;
    /**
     * The allowed angle for a truck to be able to drive
     */
    int safeAngle;
    /**
     * Added to the end of each lift/lower ramp to update the isSafe flag
     */
    public void checkIfSafe(){
        if (flatbedAngle != safeAngle){
            isUnsafe = true;
        }
        else {
            isUnsafe = false;
        }
    }

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
        if(getCurrentSpeed() == 0){
            flatbedDecrement();
        }
    }

    /**
     * These two are called by lift/lowerFlatbed
     * @param degree
     */
    public void flatbedIncrement(int degree){
        flatbedAngle = flatbedAngle + degree;
        checkIfSafe();
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
        checkIfSafe();
    }

    public void flatbedIncrement(){
        flatbedAngle = maxAngle;
        checkIfSafe();
    }
    public void flatbedDecrement(){
        if(getCurrentSpeed() == 0){
            flatbedAngle = minAngle;
        }
        checkIfSafe();
    }



}
