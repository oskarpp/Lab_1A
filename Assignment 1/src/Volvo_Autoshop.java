
public class Volvo_Autoshop extends Autoshop<Volvo240>{

    public Volvo_Autoshop(){
        maxSpace = 10;
    }

    @Override
    Volvo240 pickupCar(Vehicle car){
        return super.pickupCar(car);
    }
    @Override
    void putCar(Volvo240 car){
        super.putCar(car);
    }


}
