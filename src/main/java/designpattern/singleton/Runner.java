package designpattern.singleton;

import java.util.Random;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:24 2019-04-02
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
class MyRunner implements Runnable{

    @Override
    public void run() {
        while (true) {
            int i = new Random().nextInt(3);
            Triple t = Triple.getInstance(i);
            System.out.println("线程"+Thread.currentThread()+"获取实例"+i+"的结果"+t.number);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Runner {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunner());
        Thread thread2 = new Thread(new MyRunner());
        thread1.start();
        thread2.start();
    }

}
