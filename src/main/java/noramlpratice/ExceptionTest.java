package noramlpratice;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午12:13 2018/9/29
 * @ Description：异常相关的Test
 * @ Modified By：
 * @Version: $
 */
public class ExceptionTest {

    /**
     * 调用方法时发生异常
     * 返回还会继续执行吗
     * 不会
     * JAVA代码一旦发生异常并不处理一直向上throw，那么后面的代码是不会执行的
     * 异常只有try catch处理之后，后面的代码才会运行
     */
    @Test
    public void methodA() {
        System.out.println("调用方法B之前");
        Integer i = methodB();
        System.out.println(i);
        System.out.println("调用方法B之后");
        Map<String,String> map = new HashMap<String, String>();
    }
    public Integer methodB() {
        System.out.println(Integer.parseInt("weq"));
        return new Integer(1);
    }
}
