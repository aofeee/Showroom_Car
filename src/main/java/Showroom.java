import java.util.ArrayList;
import java.util.List;

public class Showroom {

    final AutoSeller autoSeller = new AutoSeller(this);
    List<Auto> auto = new ArrayList<>(10);


    public Auto sellAuto() {
        return autoSeller.sellAuto();
    }

    public void acceptAuto() {
        autoSeller.receiveAuto();
    }

    List<Auto> getAuto() {
        return auto;
    }

}
