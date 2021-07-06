import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Showroom {

    int timeCollectCar = 6000;
    int timeDeliveryCar = 2000;
    int timeSellCar = 1500;
    int timeAcceptCar = 1000;
    int soldCars = 0;
    int planSales = 10;

    public Showroom() {
    }

    final AutoSeller autoSeller = new AutoSeller(this);
    List<Auto> auto = new ArrayList<>();

    public Auto sellAuto() {
        System.out.println(Thread.currentThread().getName() + " входит в автосалон.....");
        return autoSeller.sellAuto();
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

    public boolean planIsDone() {
        return soldCars >= planSales;
    }

    public Auto soldCar() {
        return auto.remove(0);
    }
}
