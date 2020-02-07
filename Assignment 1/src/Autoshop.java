import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Autoshop <A extends Car>{

    int maxSpace;

    List<A> list = new ArrayList(maxSpace);

    public List<A> getList(){
        return list;
    }

    A pickupCar(Car car){
        return list.remove(list.indexOf(car));
    }

    void putCar(A car){
        list.add(car);
    }

}
