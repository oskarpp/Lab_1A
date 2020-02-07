import java.util.Deque;

public abstract class Flatbed extends Car{

    public int flatbedAngle;
    int maxAngle;
    int minAngle;


    public int getFlatbedAngle() {
        return flatbedAngle;
    }

    public int allowedDegree(){
        return Math.abs(maxAngle - minAngle);
    }

    /**
     * Two different ways to lower and lift flatbed, call with a degree to as argument to lower or lift with specific degree.
     * Call wit our the argument to switch between max and min mode.
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
