import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Math;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public abstract class Car implements Movable{

    final static String INV_ARG = "Value not allowed"; //

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; //The car model name
    public BufferedImage carImg;


    /**
     * Handling of cars transported on other cars.
     */
    public boolean isLoaded;
    Deque<? super Car> stack = new ArrayDeque();
    private void moveCar(double x, double y){
        Iterator itr = getDeque().iterator();
        while(itr.hasNext()){
            Car car = (Car) itr.next();
            car.setX(x);
            car.setY(y);
        }
    }
    public boolean isUnsafe;

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
    public Deque getDeque(){ return stack;}

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
        if(isLoaded){
            throw new IllegalArgumentException("Car cannot move, is loaded on another truck.");
        }
        if(isUnsafe){
            throw new IllegalArgumentException("Car cannot move. Flatbed in the wrong position.");
        }
        if (dir == direction.SOUTH){
            setY(y - currentSpeed);
            if (getDeque().size() != 0) {
                double x = getX();
                double y = getY();
                moveCar(x, y);
            }
        }
        if (dir == direction.NORTH){
            setY(y + currentSpeed);
            if (getDeque().size() != 0) {
                double x = getX();
                double y = getY();
                moveCar(x, y);
            }
        }
        if (dir == direction.WEST){
            setX(x - currentSpeed);
            if (getDeque().size() != 0) {
                double x = getX();
                double y = getY();
                moveCar(x, y);
            }
        }
        if (dir == direction.EAST){
            setX(x + currentSpeed);
            if (getDeque().size() != 0) {
                double x = getX();
                double y = getY();
                moveCar(x, y);
            }
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

}
