import java.io.IOException;

public class CarApp {

    public static void main(String[] args) throws IOException {
        int framesizeX = 800;
        int framesizeY = 800;
        int dPsizeX = 800;
        int dPsizeY = framesizeY - 240;


        CarController carC = new CarController(framesizeX, framesizeY);
        DrawPanel dP = new DrawPanel(dPsizeX, dPsizeY, carC);
        CarView frame = new CarView("CarSim 1.0", carC, dP, framesizeX, framesizeY);
        


        dP.timer.start();

    }
}
