package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:42 2018/9/10
 * @ Description：A的JDK代理类
 * @ Modified By：
 * @Version: $
 */
public class AProxy implements InvocationHandler {
    private Object realObject = new HelloWorldImpl();
//
//    public Object bind(Object realObject) {
//        this.realObject = realObject;
//        return proxy.newProxyInstance(realObject.getClass().getClassLoader(),realObject.getClass().getInterfaces(),this);
//    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //可以在这里写调用之前的方法
//        System.out.println("before say hello");
//        System.out.println(method.getDeclaringClass());
//        method.invoke(realObject,args);
//        if(Object.class.equals(method.getDeclaringClass())){
            Object obj = method.invoke(realObject,args);
            return obj;
//        }
        //可以在这写调用之后的方法
//        return null;
    }
}
