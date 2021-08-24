import java.util.ArrayList;
import java.util.List;

public class Showroom {

    final int TIME_COLLECT_CAR = 6000;
    final int TIME_DELIVERY_CAR = 2000;
    final int TIME_SELL_CAR = 1500;
    final int TIME_ACCEPT_CAR = 1000;
    int soldCars = 0;

    public Showroom() {
    }

    final AutoSeller autoSeller = new AutoSeller(this);
    List<Auto> auto = new ArrayList<>(10);

    public void sellAuto() {
        autoSeller.sellAuto();
    }

    public void acceptAuto() {
        autoSeller.receiveAuto();
    }

    List<Auto> getAuto() {
        return auto;
    }

    public void increaseSoldCarsNumber() {
        soldCars++;
    }

    public void soldCar() {
        auto.remove(0);
    }
}
