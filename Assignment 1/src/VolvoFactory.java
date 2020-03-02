import java.util.Random;

public class VolvoFactory {


    public static Volvo240 createVolvo240(){
        Random rand = new Random();
        Volvo240 volvo = new Volvo240();

        double xs = rand.nextDouble();
        double start = 10;
        double end  = 650;
        double position = start + (xs * (end - start));

        volvo.setX(position);

        return volvo;
    }

    public static Saab95 createSaab(){
        Random rand = new Random();
        Saab95 saab = new Saab95();

        double xs = rand.nextDouble();
        double start = 10;
        double end  = 650;
        double position = start + (xs * (end - start));

        saab.setX(position);

        return saab;
    }

}
