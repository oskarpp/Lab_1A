import java.awt.*;

public abstract class Vehicle implements Movable{

    final static String INV_ARG = "Value not allowed"; //

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; //The car model name

    /**
     * Representations of Direction and position
     */
    private double x;
    private double y;
    private direction dir = direction.NORTH;
    public enum direction{
        NORTH, SOUTH, WEST, EAST
    }

    /**
     * Getters
     */
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public direction getDir(){
        return dir;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }

    /**
     * Setters
     * @param clr which color should be set for the car
     */
    public void setColor(Color clr){
        color = clr;
    }
    public void setX (double newX) { x = newX; }
    public void setY (double newY) { y = newY; }
    public void setDir (direction newDir){dir = newDir; }

    /**
     * Starts / Stops the engine (affects currentSpeed)
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Increases the speed of the car.
     * @param amount a value in the interval [0,1]
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            double max = this.getEnginePower();
            double i = this.getCurrentSpeed();
            incrementSpeed(amount);
            double j = this.getCurrentSpeed();
            if (i > j) {
                currentSpeed = i;
            } else if (j > max) {
                currentSpeed = max;
            }
        } else {
            throw new IllegalArgumentException(INV_ARG);
        }
    }

    /**
     * Decreases the speed of the car
     * @param amount a value in the interval [0,1]
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1){
            double min = 0;
            double i = this.getCurrentSpeed();
            decrementSpeed(amount);
            double j = this.getCurrentSpeed();
            if (i < j){
                currentSpeed = i;
            } else if (j < min) {
                currentSpeed = min;
            }
        } else { throw new IllegalArgumentException(INV_ARG);
        }
    }

    /**
     * Moves the car in the current direction, turns the car left or right
     */
    public void move() {
        if (getDir() == direction.SOUTH){
            setY(getY() - currentSpeed);
        }
        if (getDir() == direction.NORTH){
            setY(getY() + currentSpeed);
        }
        if (getDir() == direction.WEST){
            setX(getX() - currentSpeed);
        }
        if (getDir() == direction.EAST){
            setX(getX() + currentSpeed);
        }

    }
    public void turnLeft() {
        if (dir == direction.SOUTH){
            setDir(direction.EAST);
        }
        else if (dir == direction.EAST){
            setDir(direction.NORTH);
        }
        else if (dir == direction.NORTH){
            setDir(direction.WEST);
        }
        else if (dir == direction.WEST){
            setDir(direction.SOUTH);
        }
    }
    public void turnRight() {
        if (dir == direction.SOUTH){
            setDir(direction.WEST);
        }
        else if (dir == direction.EAST){
            setDir(direction.SOUTH);
        }
        else if (dir == direction.NORTH){
            setDir(direction.EAST);
        }
        else if (dir == direction.WEST){
            setDir(direction.NORTH);
        }
    }

    /**
     * Is called from the gas/brake method.
     * Does nothing unless a  method with the same name is also defined as Override in the car subclass
     */
    public void incrementSpeed(double amount){}
    public void decrementSpeed(double amount){}

    /**
     * Intersects and collision
     */
    public boolean intersects(int height, int width) {
        int availableHeight = height-300; // Hard coded value is for the the height of the panel + the height of the car image. To be fixed
        int availableWidth = width-100; // Hard coded value is for the width of the car image. To be fixed

        boolean below = this.getY() > availableHeight;
        boolean above = this.getY() < 0;
        boolean left = this.getX() < 0;
        boolean right = this.getX() > availableWidth;
        return (above || below || left || right);
    }
    public void actionCollision(double x, double y){
        this.setX(x);
        this.setY(y);

        this.stopEngine();
        this.turnRight();
        this.turnRight();
        this.startEngine();
    }

    public void movement(Vehicle m, int framesizeY, int framesizeX){
        //Saves the position of the car before moving it. Is used in actionCollision, if we collide.
        double beforeX = m.getX();
        double beforeY = m.getY();
        m.move();
        if(m.intersects(framesizeY, framesizeX)){
            m.actionCollision(beforeX, beforeY);
        }
    }


}
