package proxy;

import java.lang.reflect.Proxy;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:24 2018/10/27
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        AProxy aProxy = new AProxy();
        Class interfaceName = HelloWorld.class;

        HelloWorld helloWorld = (HelloWorld) Proxy.newProxyInstance(interfaceName.getClassLoader(),new Class[]{interfaceName},aProxy);
        helloWorld.sayHello();
    }
}
