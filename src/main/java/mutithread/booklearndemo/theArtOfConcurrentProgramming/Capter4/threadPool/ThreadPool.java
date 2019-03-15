package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter4.threadPool;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:29 2019-03-14
 * @ Description：线程池接口
 * @ Modified By：
 * @Version: $
 */
public interface ThreadPool<MyRunnable extends Runnable> {

    /**
     * 加入一个新的任务
     * @param myRunnable
     */
    void execute(MyRunnable myRunnable);

}
