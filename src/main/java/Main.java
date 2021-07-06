

public class Main {
    public static void main(String[] args) {

        final Showroom showroom = new Showroom();

        ThreadGroup group = new ThreadGroup("Покупатели");

        new Thread(group, showroom::sellAuto, "Покупатель Виктор").start();
        new Thread(group, showroom::sellAuto, "Покупатель Дмитрий").start();
        new Thread(group, showroom::sellAuto, "Покупатель Егор").start();
        new Thread(null, showroom::acceptAuto, "Производитель NISSAN-MOTORS").start();

        }
    }
