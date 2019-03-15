package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter4.threadPool;

import java.net.Socket;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:32 2019-03-14
 * @ Description：构建请求Runnable实例
 * @ Modified By：
 * @Version: $
 */
public class RequestRunnable implements Runnable {
    private Socket socket;

    RequestRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // dosomething;
    }
}
