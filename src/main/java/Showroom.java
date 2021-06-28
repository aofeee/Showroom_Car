import java.util.ArrayList;
import java.util.List;

public class Showroom {

    AutoSeller autoSeller = new AutoSeller(this);
    List<Auto> auto = new ArrayList<>(10);

    private String title;

    public Showroom(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


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
