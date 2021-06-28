public class AutoSeller {


    private Showroom showroom;

    public AutoSeller(Showroom showroom) {
        this.showroom = showroom;
    }

    public synchronized void receiveAuto() {
        try {
            Thread.sleep(4000);
                System.out.println("Производитель: Новый автомобиль готов.");
                System.out.println("Продавец: Принимаю новый автомобиль.");
                showroom.getAuto().add(new Auto());
                Thread.sleep(2000);
                System.out.println("Новый автомобиль выставлен в главном зале.");
                notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized Auto sellAuto() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            System.out.println("Продавец: Проверяю наличие автомобилей...");
            while (showroom.getAuto().size() == 0) {
                System.out.println("Продавец: В данный момент все автомобили раскуплены!");
                wait();
                receiveAuto();
            }
            Thread.sleep(1000);
            if (showroom.getAuto().size() > 0) {
                System.out.println("Продаю автомобиль...");
                System.out.println(Thread.currentThread().getName() + " уехал на новом NISSAN");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return showroom.getAuto().remove(0);

    }
}