

public class Main {
    public static void main(String[] args) {

        final Showroom showroom = new Showroom();


            // Потоки покупатели
            new Thread(null, showroom::sellAuto, "Виктор").start();
            new Thread(null, showroom::sellAuto, "Сергей").start();
            new Thread(null, showroom::sellAuto, "Антон").start();

            // Поток производитель
            new Thread(null, showroom::acceptAuto, "Производитель HONDA MOTORS").start();
        }
    }

