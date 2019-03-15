package mutithread.booklearndemo.start;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:29 2019-03-07
 * @ Description：创建线程对象的两种方法 Thread Runnable
 * 所谓start等等的方法都是Thread类的方法
 * 只是创建Thread对象时可以使用Runnale实例作为构造参数
 * 因此在创建实例时两者有较为明显的不同
 * @ Modified By：
 * @Version: $
 */
public class CreateThread {
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("重写ThreadRun方法");
        }
    }

    @Test
    public void testThread() {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.start(); //一个线程只能start一次
    }

    class MyRunnale implements Runnable{
        int i = 0;
        @Override
        public void run() {
            System.out.println("重写Runable Run方法");
            System.out.println(i++);
        }
    }

    @Test
    public void testRunnale() {
        MyRunnale myRunnale = new MyRunnale();
        Thread thread1 = new Thread(myRunnale);
        thread1.start();
    }
}
