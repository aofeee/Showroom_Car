

public class Main {
    public static void main(String[] args) {

        final Showroom showroom = new Showroom();

        new Thread(null, showroom::sellAuto, "Виктор").start();
        new Thread(null, showroom::sellAuto, "Сергей").start();
        new Thread(null, showroom::sellAuto, "Антуан").start();

   new Thread(null, showroom::acceptAuto, "Производитель HONDA MOTORS").start();

    }
}