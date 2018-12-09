package mutithread.reentlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午7:05 2018/11/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class ReentrantLockDemo {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void method() {
        lock.lock();

        System.out.println("获得锁");
        lock.unlock();
    }
}
