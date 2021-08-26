public class AutoSeller {

    private Showroom showroom;

    public AutoSeller(Showroom showroom) throws InterruptedException {
        this.showroom = showroom;
    }

    public synchronized void genereteCar() {
        try {
            Thread.sleep(4000);
            showroom.getCars().add(new Auto());
            System.out.println("Производитель Toyota выпустил 1 авто");
            notify();
        } catch
        (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Auto sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            Thread.sleep(2000);
            while (showroom.getCars().size() == 0) {
                System.out.println("Машин нету");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        return showroom.getCars().remove(0);}
}