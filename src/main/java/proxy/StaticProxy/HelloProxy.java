package proxy.StaticProxy;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:07 2018/10/27
 * @ Description：Hello的静态代理类
 * @ Modified By：
 * @Version: $
 */
public class HelloProxy implements Hello {

    private HelloImpl realObject;

    public HelloProxy(HelloImpl realObject) {
        this.realObject = realObject;
    }

    public void sayHello() {
        System.out.println("代理处理方法之前");
        this.realObject.sayHello();
    }
}
