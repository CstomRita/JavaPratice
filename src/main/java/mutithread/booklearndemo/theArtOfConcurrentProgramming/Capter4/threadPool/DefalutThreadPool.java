package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter4.threadPool;

import java.util.LinkedList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:58 2019-03-14
 * @ Description：工作线程
 * @ Modified By：
 * @Version: $
 */


 public class DefalutThreadPool<MyRunnable extends Runnable> implements ThreadPool{

     private LinkedList<Runnable> runnables = new LinkedList<>();

    /**
     * 初始化，创建num个线程
     * @param num
     */
    private void init(int num) {
         for(int i = 0; i < num; i++) {
             Thread thread = new Thread(new Worker());
             thread.start();
         }
     }

    @Override
    public void execute(Runnable runnable) {
        if (runnable == null) return;
        synchronized (runnables) {
            runnables.addFirst(runnable);
            runnables.notify();
        }
    }


    class Worker implements Runnable{
         @Override
         public void run() {
             synchronized (runnables) {
                 while (runnables.isEmpty()) {
                     try {
                         runnables.wait();
                     } catch (InterruptedException e) {
                         return;
                     }
                 }
                 Runnable runnable = runnables.getLast();
                 if (runnable != null) {
                     runnable.run();
                 }
             }
         }
     }
}
