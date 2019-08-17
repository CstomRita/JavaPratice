package algorithm.stackAndQueueAlgorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 22:23 2019-04-01
 * @ Description：维护队列的最大值，使用一个双向队列
 * 定义一个队列，并实现函数max得到队列中的最大值
 *
 * 要求max，push，pop函数时间复杂度都是O(1)
 * @ Modified By：
 * @Version: $
 */
public class QueueMax {

    private LinkedList<Integer> dqueue = new LinkedList<>();

    private Queue<Integer> queue = new LinkedList<>();

    public void push(Integer element) {
        queue.add(element);
        while (!dqueue.isEmpty() && dqueue.peekLast() <= element) {
            dqueue.removeLast();
        }
        dqueue.addLast(element);
    }

    public int pop() {
        Integer e = queue.poll();
        if (dqueue.peekFirst() == e) {
            dqueue.removeFirst();
        }
        return e;
    }

    public int max() {
        return dqueue.peekFirst();
    }

}
