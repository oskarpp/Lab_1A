/**
 */

import org.junit.Before;
import org.junit.Test;

import static java.lang.System.out;

import java.awt.*;

import static junit.framework.TestCase.assertTrue;

public class test {
    Volvo240 test1 = new Volvo240();
    Saab95 test2 = new Saab95();
    Scania test3 = new Scania();

    CarTransporter test4 = new CarTransporter();

    Volvo_Autoshop auto1 = new Volvo_Autoshop();
    General_Autoshop auto2 = new General_Autoshop();


    @Before
    public void init(){
    }

    @Test
    public void checkAutoshopPickup(){
        auto2.putCar(test1);
        auto2.putCar(test2);
        out.println(auto2.getList());
        auto2.pickupCar(test1);
        out.println(auto2.getList());
    }
    @Test
    public void checkAutoshop(){
        auto1.getList().add(test1);
        out.println(auto1.getList());
    }
        @Test
    public void checknrDoors(){
        assertTrue(test1.getNrDoors() == 4 && test2.getNrDoors() == 2);
    }
    @Test
    public void checkColor(){
        assertTrue(test1.getColor() == Color.black && test2.getColor() == Color.red && test3.getColor() == Color.black && test4.getColor() == Color.yellow);
        //out.println(test3.getColor());
    }
    @Test
    public void checkEnginePower(){
        assertTrue(test1.getEnginePower() == 100 && test2.getEnginePower() == 125);
    }
    @Test
    public void checkSpeedFactor(){
        assertTrue(test1.getCurrentSpeed() == 0 && test2.getCurrentSpeed() == 0);
    }
    @Test
    public void checkStartEngine(){
        test1.startEngine();
        test2.startEngine();
        assertTrue(test1.getCurrentSpeed() == 0.1 && test2.getCurrentSpeed() == 0.1);
    }
    @Test
    public void checkStopEngine(){
        test1.startEngine();
        test1.stopEngine();
        assertTrue(test1.getCurrentSpeed() == 0);
    }
    @Test
    public void checkIsTurboOff(){
        test2.setTurboOn();
        test2.setTurboOff();
        assertTrue(test2.turboOn == false);
    }
    @Test
    public void checkIsTurboOn(){
        test2.setTurboOn();
        assertTrue(test2.turboOn == true);
    }
    @Test
    public void checkBreak(){
        test1.startEngine();
        test1.brake(1);
        assertTrue(test1.getCurrentSpeed() >= 0 && test1.getCurrentSpeed() <= test1.enginePower);
    }
    @Test
    public void checkGas(){
        test1.startEngine();
        double x = test1.getCurrentSpeed();
        test1.gas(0.5);
        assertTrue(test1.getCurrentSpeed() > x);

    }
    @Test
    public void checkDiffGas(){
        test1.startEngine();
        test2.startEngine();
        test2.setTurboOn();
        test1.gas(0.75);
        test2.gas(0.75);
        assertTrue(test1.getCurrentSpeed() != test2.getCurrentSpeed());
    }
    @Test
    public void checkDiffBreak(){
        test1.startEngine();
        test2.startEngine();
        test2.setTurboOn();
        test1.gas(0.5);
        test2.gas(0.5);
        //out.println(test1.getCurrentSpeed());
        //out.println(test2.getCurrentSpeed());
        test1.brake(0.1);
        test2.brake(0.1);
        //out.println(test1.getCurrentSpeed());
        //out.println(test2.getCurrentSpeed());
        assertTrue(test1.getCurrentSpeed() != test2.getCurrentSpeed());
    }
    @Test
    public void checkMove(){
        out.println(test1.getDir());
        test1.move();
        //out.println(test1.y);
        //out.println(test1.getCurrentSpeed());
        test1.startEngine();
        test1.move();
        //out.println(test1.y);
        //out.println(test1.getCurrentSpeed());
        assertTrue(test1.getY() == test1.getCurrentSpeed());
    }
    @Test
    public void checkTurnRight(){
        test1.turnRight();
        assertTrue(test1.getDir() == Car.direction.EAST);
    }
    @Test
    public void checkTurnLeft(){
        test1.turnLeft();
        test1.turnLeft();
        assertTrue(test1.getDir() == Car.direction.SOUTH);
    }
    @Test
    public void checkColorChange(){
        Color i = test1.getColor();
        if(i != Color.ORANGE) {
            test1.setColor(Color.ORANGE);
        } else { test1.setColor(Color.darkGray);}
        assertTrue(test1.getColor() != i);
    }
    /**
     * Below are tests for lab 1 part B
     */

    /**
     * Making sure that the car cannot move if the Flatbed is in an unsafe position
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkFlatbedSafe(){
        test3.liftFlatbed(30);
        test3.startEngine();
        test3.gas(0.5);
        test3.move();
    }
    /**
     * Check that the ramp can only be lowered if carTransport is standing still
     */
    @Test
    public void checkRampLower(){
        int a = test4.getFlatbedAngle();
        test4.lowerFlatbed();
        int b = test4.getFlatbedAngle();
        assertTrue(a > b);
    }
    @Test
    public void checkRampdoesNotLower(){
        int a = test4.getFlatbedAngle();
        test4.startEngine();
        test4.gas(0.5);
        test4.lowerFlatbed();
        int b = test4.getFlatbedAngle();
        assertTrue(a == b);
    }
    /**
     * Check that the carTransport cannot load itself
     */
    //@Test(expected = IllegalArgumentException.class)
    //public void loadSelf(){
       // test4.loadCar(test4);
    //}
    /**
     * loads car on transport
     * moves transport
     * checks that car and transport still have the same coordinates
     */
    @Test
    public void transportCoordinates(){
        test4.lowerFlatbed();
        test4.loadCar(test1);
        test4.liftFlatbed();
        test4.startEngine();
        test4.gas(1);
        test4.move();
        double a = test1.getX();
        double b = test4.getX();
        double c = test1.getY();
        double d = test1.getY();
        assertTrue(a == b && c == d);


    }

}
