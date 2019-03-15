package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter4;

import org.junit.Test;

import static java.lang.System.out;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:23 2019-03-12
 * @ Description：第四章 并发编程基础
 * @ Modified By：
 * @Version: $
 */
public class Capter4 {
    class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            out.println("线程1运行完成");
        }
    }

    class MyRunnable2 implements Runnable {
        Thread thread;

        MyRunnable2(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            synchronized (thread) {
                while (true) {
                    out.println("线程2占有线程1实例");
                }
            }
        }
    }

    /**
     * 验证Tnterrput方法是否需要锁定线程实例
     * interrupt方法是Thread类的实例方法，
     * 在执行的时候并不需要获取Thread实例的锁定，任何线程在任何时刻，都可以通过线程实例来调用其他线程的interrupt方法。
     */
    @Test
    public void interruptTest1() {
        Thread thread1 = new Thread(new MyRunnable1());
        thread1.start();
        Thread thread2 = new Thread(new MyRunnable2(thread1));
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.println(thread1.isInterrupted());
        thread1.interrupt();
        out.println(thread1.isInterrupted());
        //Thread1被线程2占有，获取不到锁，这里是死锁
        //但是Thread1.Interrupt依然正常运行，表示是不需要获取锁的。
//        synchronized (thread1) {
//        }

    }


    class MyRunnable3 implements Runnable {
        Thread thread;

        MyRunnable3(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            synchronized (thread) {
                while (true) {

                }
            }
        }
    }

    /**
     * 测试wait、notify
     * wait\notify必须在同步方法或者同步块中使用
     * notify之后如果从wait返回需要重新获取对象锁
     * 原因是因为wait、notify机制
     * 还是因为在synchronized方法中？
     * wait notify必须在同步方法中使用，否则运行时报异常IllegalMonitorStateException
     */
    class MyRunnable8 implements Runnable{

        @Override
        public void run() {

        }
    }
    class MyRunnable9 implements Runnable{
        Object object;
        MyRunnable9(Object o){
            this.object = o;
        }
        @Override
        public void run() {
            out.println("运行9");
            synchronized (object) {
                out.println("占到锁");
            }
        }
    }

    @Test
    public void waitTest1() {
        Object o = new Object();
        Thread thread9 = new Thread(new MyRunnable9(o));
        try {
            o.wait();
            thread9.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试join是否需要获取Thread对象锁
     * 如果获取不到怎么办，会一直等待，直到获取到
     */
    @Test
    public void joinTest1() {
        Thread thread1 = new Thread(new MyRunnable1());
        Thread thread3 = new Thread(new MyRunnable3(thread1));
        thread3.start();
        try {
            Thread.sleep(20);
            thread1.start();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyRunnable4 implements Runnable {

        @Override
        public void run() {
            try {
                out.println("开始执行MyRUNNAable4");
                Thread.sleep(400);
                out.println("执行完毕MyRUNNAable4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyRunnable5 implements Runnable {
        Thread thread;

        MyRunnable5(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                out.println("RUNNABLE5");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (thread) {
                out.println("获取到的锁" + thread);
                while (true) {

                }
            }
        }
    }

    /**
     * 测试join是如何唤醒的，如果是基于notify唤醒，执行完毕之后自动执行notifyAll则需要获取线程锁
     * 如果此时线程锁被占，是否会从join方法返回
     * 并不会，如果准备notify的时候线程对象锁被占有，虽然Thread执行完毕但是依然不会从join返回
     */
    @Test
    public void joinTest2() {
        Thread thread4 = new Thread(new MyRunnable4());
        Thread thread5 = new Thread(new MyRunnable5(thread4));
        thread4.start();
        thread5.start();
        try {
            thread4.join();
            out.println("join返回");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试从join返回是否需要重新获取线程对象锁
     * 线程B执行完毕后，自动notifyAll并释放线程对锁
     * 如果此时被另外一个线程获取，是否还会从join返回
     */
    /**
     * 尝试获取Thread对象锁的线程
     */
    class MyRunnable6 implements Runnable {
        Thread thread;

        MyRunnable6(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (thread) {
                out.println("获取到的锁" + thread);
                while (true) {

                }
            }
        }
    }

    class MyRunnable7 implements Runnable {

        @Override
        public void run() {

            out.println("开始执行MyRUNNAable7");
            out.println("执行完毕MyRUNNAable7");

        }
    }

    @Test
    public void joinTest3() {
        Thread thread7 = new Thread(new MyRunnable7());
        Thread thread6 = new Thread(new MyRunnable6(thread7));
        thread7.start();
        thread6.start();
        try {
            thread7.join();
            out.println("返回join");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试join时被Interrupt是否需要获取对象锁
     * 测试之后，认为和wait一样需要重新获取对象锁
     *
     */
    class MyRunnable10 implements Runnable{
        Thread thread;
        MyRunnable10(Thread thread) {
            this.thread = thread;
        }
        @Override
        public void run() {
            out.println("10 running");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
            thread.interrupt();
            out.println("10 end");
        }
    }
    //占有线程对象
    class MyRunnable11 implements Runnable{
        Thread thread;
        MyRunnable11(Thread thread) {
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (thread) {
                out.println("获得锁");
                //while (true) {}
            }
        }
    }
    @Test
    public void joinTest4() {
        out.println(Thread.currentThread().getName());
        Thread thread10 = new Thread(new MyRunnable10(Thread.currentThread()));
        thread10.setName("thread10");
        Thread thread11 = new Thread(new MyRunnable11(thread10));
        thread11.setName("thread11");

        thread10.start();
        thread11.start();
        try {
            thread10.join();
        } catch (InterruptedException e) {
            out.println("catch" + e.toString());
        }
    }


}
