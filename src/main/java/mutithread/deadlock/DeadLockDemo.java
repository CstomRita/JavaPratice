package mutithread.deadlock;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:50 2018/11/5
 * @ Description：死锁实例
 * @ Modified By：
 * @Version: $
 */
public class DeadLockDemo {
    static Object  locka = new Object();
    static Object lockb = new Object();

    public  static void run1() throws InterruptedException {
        synchronized (locka) {
            System.out.println("线程1 占用locka");
            Thread.sleep(2000);
            System.out.println("线程1 尝试抢占lockb");
            synchronized (lockb) {
                System.out.println("线程1 抢占lockb");
            }

        }
    }

    public static void run2() {
        synchronized (lockb) {
            System.out.println("线程2 占用lockb");
            System.out.println("线程2 尝试抢占locka");
           synchronized (locka) {
               System.out.println("线程2 抢占locka");
           }

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    DeadLockDemo.run1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                DeadLockDemo.run2();
            }
        });
        thread1.start();
        thread2.start();
    }

}
