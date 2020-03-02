import java.io.IOException;

public class CarApp {

    public static void main(String[] args) throws IOException {
        int framesizeX = 800;
        int framesizeY = 800;

        CarController carC = new CarController(framesizeX, framesizeY);
        CarView frame = new CarView("CarSim 1.0", carC, framesizeX, framesizeY);

        frame.timer.start();

    }
}
