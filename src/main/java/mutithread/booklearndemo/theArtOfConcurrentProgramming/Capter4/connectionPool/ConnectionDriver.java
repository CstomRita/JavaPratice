package mutithread.booklearndemo.theArtOfConcurrentProgramming.Capter4.connectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:29 2019-03-14
 * @ Description：通过JDK动态代理构造Connection对象
 * @ Modified By：
 * @Version: $
 */
public class ConnectionDriver {

    //1 创建一个Handler类，实现InvocationHandler接口，重写invoke方法，invoke方法用来实现具体代理的业务逻辑
    static class ConnectionHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    // 2 创建动态代理实例
    public static Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class[]{Connection.class},new ConnectionHandler());
    }

}
