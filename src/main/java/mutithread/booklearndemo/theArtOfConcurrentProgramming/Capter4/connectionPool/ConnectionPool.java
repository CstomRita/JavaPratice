package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter4.connectionPool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:26 2019-03-14
 * @ Description：mysql连接池实例 4.4.2示例
 * @ Modified By：
 * @Version: $
 */
public class ConnectionPool {
    //双向队列维护连接对象
    private LinkedList<Connection> pool = new LinkedList<>();

    //初始化连接池连接上线
    public ConnectionPool(int initSize) {
        if (initSize > 0) {
            for (int i = 0; i < initSize; i++) {
                pool.addFirst(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 获取Connection对象
     * mills小于等于0时表示一直等到得到对象，没有超时概念
     * mills大于才有超时概念，如果超时未获取则返回null
     * @param mills
     * @return
     */
    public Connection getConection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeLast();
            }else {
                long future = System.currentTimeMillis() + mills; //futuremill时过期
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                return pool.isEmpty() ? null : pool.removeLast();
            }
        }
    }

    /**
     * 释放Connection对象
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection == null) return;
        synchronized (pool) {
            pool.addFirst(connection);
            pool.notifyAll();
        }
    }
}
