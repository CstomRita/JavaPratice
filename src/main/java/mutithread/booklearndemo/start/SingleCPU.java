package mutithread.booklearndemo.start;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:20 2019-03-07
 * @ Description：验证用户级别的线程包是不是只有一个CPU
 * 根据现代操作系统第二章中：
 * 将整个线程包放在用户空间中，内核对线程包毫无知情。
 * 从内核角度就是常规的方式管理，即单线程进程，这也就是说即便在用户空间中设置了多线程，内核分给这些多线程的也只有一个CPU。
 * @ Modified By：
 * @Version: $
 */
class MyRunnable1 implements Runnable{

    int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("这是线程1输出："+ i++);
        }
    }
}

class MyRunnable2 implements Runnable{

    int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("这是线程2输出：" + i++);
        }
    }
}
public class SingleCPU {


    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable1());
        Thread thread2 = new Thread(new MyRunnable2());
        thread1.start();
        thread2.start();
    }
    @Test
    public void test() {
        Thread thread1 = new Thread(new MyRunnable1());
        Thread thread2 = new Thread(new MyRunnable2());
        thread1.start();
        thread2.start();
    }
}
