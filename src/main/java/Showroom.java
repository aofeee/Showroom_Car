import java.util.ArrayList;
import java.util.List;

public class Showroom {

    AutoSeller seller = new AutoSeller(this);
    List<Auto> auto = new ArrayList<>(0);

    public Auto sellCar() {
        return seller.sellCar();
    }

    public void genereteCar() {
        seller.genereteCar();
    }

    public Showroom() throws InterruptedException {
    }

    List<Auto> getCars() {
        return auto;
    }


}