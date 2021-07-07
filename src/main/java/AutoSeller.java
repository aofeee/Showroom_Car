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
                log.info(Thread.currentThread().getName() + " в критической секции");
                if (showroom.getAuto().size() == 0) {
                    System.out.println("Машин нет! " + Thread.currentThread().getName() + " ожидает поставки...");
                }
                wait();
                log.info("ПРИОСТАНОВКА МЕТОДА " + Thread.currentThread().getName());
                Thread.sleep(showroom.timeSellCar);
                System.out.println("Продавец: автомобиль продан. " + Thread.currentThread().getName() + " приобрел автомобиль!!!");
                showroom.increaseSoldCarsNumber();
                log.info("КРИТСЕКЦИЯ ЗАКРЫВАЕТСЯ");
            }
            // почему после первой продажи входят в критическую секцию сразу 2 потока? и после кагда они туда вошли
            // не повторяется метод от wait(); до notify();
            // как будто  после первого потока, прекращается работа synhronized();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return showroom.soldCar();
    }

    public synchronized void receiveAuto() {
        // Должно использоваться каждый раз при входе потока в метод SellAuto. Но используется единожды, только после первого потока
        // не могу понять как заставить метод повторяться для остальных покупателей
        // использовал циклы, но все превращалось в кашу!
        log.info("НАЧАЛО СБОРКИ АВТО");
            try {
                Thread.sleep(showroom.timeCollectCar);
                System.out.println(Thread.currentThread().getName() + " выпустил 1 автомобиль!");
                showroom.getAuto().add(new Auto());
                Thread.sleep(showroom.timeDeliveryCar);
                System.out.println("Доставка автомобиля в салон...");
                Thread.sleep(showroom.timeAcceptCar);
                System.out.println("Автомобиль принят! Готов к продаже!");
                notify();
                log.info("ВОЗОБНОВЛЕНИЕ ПРИОСТАНОВЛЕНОГО МЕТОДА");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}