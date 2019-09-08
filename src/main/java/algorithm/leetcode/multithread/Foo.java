package algorithm.leetcode.multithread;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:06 2019-09-03
 * @ Description：按序打印
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * @ Modified By：
 * @Version: $
 */


/**
 * 一个等待与唤醒的示例
 * 使用conditon的await和signall
 * 或者 object的wait/notify都行
 */
public class Foo {

    Object lock = new Object();
    boolean first = false;
    boolean second = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!first) lock.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!second) lock.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
