

public class Main {
    public static void main(String[] args) {

        final Showroom NISSAN = new Showroom("NISSAN");

        new Thread(null, NISSAN::sellAuto, "Покупатель Виктор").start();
        new Thread(null, NISSAN::sellAuto, "Покупатель Дмитрий").start();
        new Thread(null, NISSAN::sellAuto, "Покупатель Станислав").start();

        new Thread(null, NISSAN::acceptAuto, "Производитель NISSAN-MOTORS").start();
    }
}
