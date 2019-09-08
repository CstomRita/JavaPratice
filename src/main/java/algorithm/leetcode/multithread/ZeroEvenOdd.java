package algorithm.leetcode.multithread;

import java.util.function.IntConsumer;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:48 2019-09-07
 * @ Description：相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * 01 02 03 ... 0n
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ Modified By：
 * @Version: $
 */
public class ZeroEvenOdd {

    private int n;
    private Object lock;
    private boolean isZero;
    private boolean isEven;
    private boolean isOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.lock = new Object();
        isZero = true;
        isEven = false;
        isOdd = false;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (lock) {
                while (!isZero) lock.wait();
                printNumber.accept(0);
                if (i % 2 == 0)isEven = true; else isOdd = true;
                isZero = false;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            synchronized (lock) {
                while (!isEven) lock.wait();
                printNumber.accept(i);
                isEven = false;
                isZero = true;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            synchronized (lock) {
                while (!isOdd) lock.wait();
                printNumber.accept(i);
                isOdd = false;
                isZero = true;
                lock.notifyAll();
            }
        }
    }
}
