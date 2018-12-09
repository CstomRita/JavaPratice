package proxy.StaticProxy;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:11 2018/10/27
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {
    public static void main(String[] args) {
        Hello hello = (Hello) new HelloProxy(new HelloImpl());
        hello.sayHello();

    }
}
