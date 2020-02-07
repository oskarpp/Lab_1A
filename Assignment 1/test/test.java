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

    carTransporter test4 = new carTransporter();
    carTransporter test5 = new carTransporter();


    @Before
    public void init(){
    }
    @Test
    public void checkLoadCar(){
        test4.lowerFlatbed();
        test5.lowerFlatbed();
        test4.loadCar(test1);
        test5.loadCar(test2);

        test4.startEngine();
        test5.startEngine();

        test4.move();

        test5.turnRight();
        test5.move();

        out.println(test4.getX());
        out.println(test4.getY());
        out.println("##################-------######################");
        out.println(test1.getX());
        out.println(test1.getY());
        out.println("##############################################");
        out.println(test5.getX());
        out.println(test5.getY());
        out.println("##################-------######################");
        out.println(test2.getX());
        out.println(test2.getY());
    }

    @Test
    public void checkFlatbedAngle(){
        //out.println(test1.getFlatbedAngle());
        //out.println(test2.getFlatbedAngle());
        //out.println(test3.getFlatbedAngle());
        out.println(test4.getFlatbedAngle());
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

}
