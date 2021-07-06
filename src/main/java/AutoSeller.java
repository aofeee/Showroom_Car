import java.util.logging.Logger;

public class AutoSeller {

    private final Showroom showroom;
    Logger log = Logger.getLogger("Log");


    public AutoSeller(Showroom showroom) {
        this.showroom = showroom;
    }

    public Auto sellAuto() {
        try {
            synchronized (showroom.autoSeller) {
                if (showroom.getAuto().size() == 0) {
                    System.out.println("Машин нет! " + Thread.currentThread().getName() + " ожидает поставки...");
                }
                wait();
                Thread.sleep(showroom.timeSellCar);
                System.out.println("Продавец: автомобиль продан. " + Thread.currentThread().getName() + " приобрел автомобиль!!!");
                showroom.increaseSoldCarsNumber();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return showroom.soldCar();
    }

    public synchronized void receiveAuto() {
            try {
                Thread.sleep(showroom.timeCollectCar);
                System.out.println(Thread.currentThread().getName() + " выпустил 1 автомобиль!");
                showroom.getAuto().add(new Auto());
                Thread.sleep(showroom.timeDeliveryCar);
                System.out.println("Доставка автомобиля в салон...");
                Thread.sleep(showroom.timeAcceptCar);
                System.out.println("Автомобиль принят! Готов к продаже!");
                notify();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}