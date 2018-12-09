package mutithread.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午6:16 2018/11/10
 * @ Description：解释ThreadLocal为什么不直接用Map存值
 * @ Modified By：
 * @Version: $
 */
public class LocalTest {
    public static Map<Thread,Object> map = new HashMap<Thread,Object>();
    public static Integer i = 0;
    static  class Mythread implements Runnable{

        public void run() {
            if(map.get(Thread.currentThread()) == null) {
                map.put(Thread.currentThread(), new Integer(0));
            }
           Integer i = (Integer) map.get(Thread.currentThread());
            while (i<20) {
                System.out.println(Thread.currentThread().getName() + " put  i = " + i);
                map.put(Thread.currentThread(), i++);
                System.out.println(Thread.currentThread().getName() + " get  i = " + map.get(Thread.currentThread()));
            }

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Mythread());
        Thread thread2 = new Thread(new Mythread());
        Thread thread3 = new Thread(new Mythread());
         thread1.start();
         thread2.start();
         thread3.start();
    }
}
