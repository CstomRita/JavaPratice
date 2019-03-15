package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter4.threadPool;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:34 2019-03-14
 * @ Description：服务器start
 * @ Modified By：
 * @Version: $
 */
public class HttpServer {

   static ThreadPool threadPool = new DefalutThreadPool();

    static ServerSocket  serverSocket;

    public static void start(int port) throws Exception{
        serverSocket = new ServerSocket(port);
        Socket socket;
        //如果接收到请求了就调给threadPool
        while ((socket = serverSocket.accept()) != null) {
            threadPool.execute(new RequestRunnable(socket));
        }
    }
}
