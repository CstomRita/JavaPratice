package algorithm.leetcode.multithread;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:55 2019-09-06
 * @ Description：两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ Modified By：
 * @Version: $
 */
public class FooBar {
    private int n;
    private Object lock = new Object();
    private boolean isFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!isFoo) lock.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (isFoo) lock.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isFoo = true;
                lock.notifyAll();
            }
        }
    }

}
