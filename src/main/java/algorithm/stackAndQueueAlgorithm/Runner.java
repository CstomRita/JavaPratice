package algorithm.stackAndQueueAlgorithm;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 22:27 2019-04-01
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Runner {

    @Test
    public void test() {
        QueueMax max = new QueueMax();
        max.push(3);
        max.push(2);
        max.push(8);
        System.out.println(max.max());
        max.pop();
        System.out.println(max.max());
        max.pop();
        System.out.println(max.max());
        max.push(12);
        System.out.println(max.max());
        max.push(0);
        System.out.println(max.max());
        max.pop();
        max.pop();
        System.out.println(max.max());
        max.pop();
        System.out.println(max.max());
    }
}
