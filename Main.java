public class Main{
    public static void main(String args[]){
        data d = new data();
        d.deger = 100;
        d.bayrak = false;
        producer p = new producer(d);
        consumer c = new consumer(d);
        Thread t = new Thread(c);
        p.start();
        t.start();
    }
}
class producer extends Thread {
    data d;

    public producer(data d) {
        this.d = d;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (d) {
                if (d.bayrak == false) {
                    d.deger++;
                    System.out.println("uretici" + d.deger);
                }
            }
        }
    }
}

class consumer implements  Runnable {
    data d;

    public consumer(data d) {
        this.d = d;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (d) {
                d.deger--;
                System.out.println("tuketici" + d.deger);
            }
        }
    }
}

class data{
    int deger;
    boolean bayrak;
}