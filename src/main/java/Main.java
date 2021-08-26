public class Main {

    public static void main(String[] args) throws InterruptedException {

        final Showroom showroom = new Showroom();

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(3000);
            new Thread(null, showroom::sellCar, "Покупатель " + i).start();
            new Thread(null, showroom::genereteCar, "Продавец").start();
        }

    }
}