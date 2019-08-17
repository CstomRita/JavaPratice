package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter5;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:40 2019-03-19
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class LockDemo {
    ReentrantLock lock = new ReentrantLock();

    class demo extends AbstractQueuedSynchronizer{

    }

    public static void main(String[] args) {

    }
}
