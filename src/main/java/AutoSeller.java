import java.util.logging.Logger;

public class AutoSeller {

    private final Showroom showroom;


    public AutoSeller(Showroom showroom) {
        this.showroom = showroom;
    }

    public void sellAuto() {
        try {
            synchronized (showroom.autoSeller) {
                System.out.println(Thread.currentThread().getName() + " входит в автосалон.....");
                if (showroom.auto.size() == 0) {
                    System.out.println("Машин нет! " + Thread.currentThread().getName() + " ожидает поставки...");
                    wait();
                }
                Thread.sleep(showroom.TIME_SELL_CAR);
                System.out.println("Продавец: автомобиль продан. " + Thread.currentThread().getName() + " приобрел автомобиль!!!");
            }
            showroom.increaseSoldCarsNumber();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void receiveAuto() {
            try {
                Thread.sleep(showroom.TIME_COLLECT_CAR);
                showroom.getAuto().add(new Auto());
                System.out.print(Thread.currentThread().getName() + " выпустил 1 автомобиль!");
                Thread.sleep(showroom.TIME_DELIVERY_CAR);
                System.out.print(" Доставка автомобиля в салон...");
                Thread.sleep(showroom.TIME_ACCEPT_CAR);
                System.out.print(" Автомобиль принят! Готов к продаже!\n");
                notify();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}