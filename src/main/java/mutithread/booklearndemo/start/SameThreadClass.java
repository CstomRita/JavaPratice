package mutithread.booklearndemo.start;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:38 2019-03-07
 * @ Description：验证同一个实例创建出的线程是否共享内存
 * 结论：
 * 使用同一个Runnale实例构造的线程实例，是共享的；但是继承Thread类不能用一个实例构建多个线程
 * @ Modified By：
 * @Version: $
 */

import org.junit.Test;

public class SameThreadClass {
    class MyThread extends Thread{
        int i = 0;
        @Override
        public void run() {
            System.out.println(i++);
        }
    }

    @Test
    public void testThread() {
        MyThread myThread1 = new MyThread();
        myThread1.start();
        MyThread myThread2 = new MyThread();
        myThread2.start();
    }

    class MyRunnale implements Runnable{
        int i = 0;
        @Override
        public void run() {
            System.out.println(i++);
        }
    }

    @Test
    public void testRunnale() {
        MyRunnale myRunnale = new MyRunnale();
        Thread thread1 = new Thread(myRunnale);
        thread1.start();
        Thread thread2 = new Thread(myRunnale);
        thread2.start();
    }


    @Test
    public void testRunnale2() {
        MyRunnale myRunnale1 = new MyRunnale();
        MyRunnale myRunnale2 = new MyRunnale();
        Thread thread1 = new Thread(myRunnale1);
        thread1.start();
        Thread thread2 = new Thread(myRunnale2);
        thread2.start();
    }
}

