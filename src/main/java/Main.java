

public class Main {
    public static void main(String[] args) {

        final Showroom showroom = new Showroom();

            new Thread(null, showroom::sellAuto, "Покупатель Виктор").start();
            new Thread(null, showroom::sellAuto, "Покупатель Дмитрий").start();
            new Thread(null, showroom::sellAuto, "Покупатель Егор").start();

        new Thread(null, showroom::acceptAuto, "Производитель NISSAN-MOTORS").start();


    }
}
