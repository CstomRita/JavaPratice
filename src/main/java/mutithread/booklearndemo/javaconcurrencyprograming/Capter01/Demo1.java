package mutithread.booklearndemo.javaconcurrencyprograming.Capter01;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午8:56 2018/11/26
 * @ Description：Thread不可以start两次
 * @ Modified By：
 * @Version: $
 */
class MyRunnable implements Runnable{

    private int i = 0;
    public void run() {
        System.out.println(Thread.currentThread()+"输出"+" "+i);
    }
}
public class Demo1 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.setName("Thread-12");
        System.out.println(myThread.getName());
        myThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThread.getName());
    }

}
