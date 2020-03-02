import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class World {
    int framesizeX = 800;
    int framesizeY = 800;
    int dPsizeX = 800;
    int dPsizeY = framesizeY - 240;


    CarController carC = new CarController();
    DrawPanel dP = new DrawPanel(dPsizeX, dPsizeY, carC);
    CarView frame = new CarView("CarSim 1.0", carC, dP, framesizeX, framesizeY);

    /**
     * Konstruktor
     */

    public World () throws IOException {

        dP.timer.start();
    }


}


