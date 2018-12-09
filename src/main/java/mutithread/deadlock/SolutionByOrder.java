package mutithread.deadlock;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:07 2018/11/5
 * @ Description：顺序加锁
 * @ Modified By：
 * @Version: $
 */
public class SolutionByOrder {
    static Object A = new Object();
    static Object B = new Object();
    static Object C = new Object();
    static Object D = new Object();
    static Object E = new Object();

    public static void run1() {
        synchronized (A) {
            System.out.println("1获取锁A");
            synchronized (B) {
                System.out.println("1获取锁B");
                synchronized (C) {
                    System.out.println("1获取锁C");
                }
            }
        }
    }

    public  static void run2() {
        synchronized (B) {
            System.out.println("2获取锁B");
            synchronized (D) {
                System.out.println("2获取锁D");
                synchronized (E) {
                    System.out.println("2获取锁E");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                run1();
            }
        });
        Thread thread2 = new Thread(new Runnable(){
            public void run() {
                run2();
            }
        });
        thread2.start();
        thread1.start();
    }
}
