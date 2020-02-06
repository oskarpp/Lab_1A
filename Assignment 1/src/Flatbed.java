public abstract class Flatbed extends Car{

    public int flatbedAngle; // flakts vinkel
    int maxAngle;
    int minAngle;
    int allowedDegree = maxAngle - minAngle;

    public int getFlatbedAngle() {
        return flatbedAngle;
    }

    /**
     * Increment flatbed angle with
     * @param degree this degree (value limited by allowedDegree)
     */
    public void liftFlatbed(int degree){
        if (getCurrentSpeed() == 0 && degree >= 0 && degree <= Math.abs(allowedDegree)) {
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
    /**
     * Decrement flatbed for a car's flatbed
     * @param degree
     */
    public void lowerFlatbed(int degree){
        if (degree >= 0 && degree <= Math.abs(allowedDegree)) {
            flatbedDecrement(degree);
        } else {
            throw new IllegalArgumentException(INV_ARG);
        }
    }

    //Override

    /**
     * Is called from the liftFlatbed/lowerFlatbed method.
     * Does nothing unless a  method with the same name is also defined as Override in the car subclass
     */
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

    /**
     * Added condition that flatbed must be lowered to increment speed.
     */
    public void flatbedIncrement(){
        flatbedAngle = maxAngle;
    }
    public void flatbedDecrement(){
        if(getCurrentSpeed() == 0){
            flatbedAngle = minAngle;
        }
    }


}
