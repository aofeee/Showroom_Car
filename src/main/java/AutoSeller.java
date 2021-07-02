public class AutoSeller {

    private final Showroom showroom;

    public AutoSeller(Showroom showroom) {
        this.showroom = showroom;
    }

    public Auto sellAuto() {
        try {
            synchronized (showroom.autoSeller) {
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                while (showroom.auto.size() == 0) {
                    System.out.println("Машин нет!!!");
                    wait();
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " уехал на новом NISSAN");
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        return showroom.auto.remove(0);
    }


    public synchronized void receiveAuto() {
        try {
                Thread.sleep(7000);
                System.out.println(Thread.currentThread().getName() + " выпустил 1 автомобиль!");
                Thread.sleep(600);
                showroom.getAuto().add(new Auto());
                notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
