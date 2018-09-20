package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:42 2018/9/10
 * @ Description：A的JDK代理类
 * @ Modified By：
 * @Version: $
 */
public class AProxy implements InvocationHandler {
    private Object realObject;

    public Object bind(Object realObject) {
        this.realObject = realObject;
        return Proxy.newProxyInstance(realObject.getClass().getClassLoader(),realObject.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        return null;
    }
}
