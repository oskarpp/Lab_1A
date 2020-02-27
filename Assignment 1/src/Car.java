import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Math;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public abstract class Car extends Vehicle implements Loadable{


    /**
     * Handling of cars transported on other cars.
     */
    public boolean isLoaded;
    public void setIsLoaded(boolean state){
        this.isLoaded = state;
    }
    public boolean getIsLoaded(){
        return isLoaded;
    }

    /**
     * Moves the car in the current direction, turns the car left or right
     */
    @Override
    public void move() {
        if(isLoaded){
            throw new IllegalArgumentException("Car cannot move, is loaded on another truck.");
        }
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
    @Override
    public void turnLeft() {
        if(isLoaded){
            throw new IllegalArgumentException("Car cannot move, is loaded on another truck.");
        }
        if (getDir() == direction.SOUTH){
            setDir(direction.EAST);
        }
        else if (getDir() == direction.EAST){
            setDir(direction.NORTH);
        }
        else if (getDir() == direction.NORTH){
            setDir(direction.WEST);
        }
        else if (getDir() == direction.WEST){
            setDir(direction.SOUTH);
        }
    }
    @Override
    public void turnRight() {
        if(isLoaded){
            throw new IllegalArgumentException("Car cannot move, is loaded on another truck.");
        }
        if (getDir() == direction.SOUTH){
            setDir(direction.WEST);
        }
        else if (getDir() == direction.EAST){
            setDir(direction.SOUTH);
        }
        else if (getDir() == direction.NORTH){
            setDir(direction.EAST);
        }
        else if (getDir() == direction.WEST){
            setDir(direction.NORTH);
        }
    }


}
