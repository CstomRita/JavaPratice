package algorithm.review.stackAndQueue.demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:10 2019-05-14
 * @ Description：两个队列实现一个栈
 * @ Modified By：
 * @Version: $
 */
public class QueueToStack {

    /**
     * 两个队列实现一个栈是有区别的
     * 因为队列是先进先出的，从一个队列出来再加入另外一个队列，依然是第一个元素
     * 使用队列没有办法颠倒顺序
     *
     * 因此使用队列实现栈的方式，
     * 每次删除时，都需要借助另外一个队列，使得本队列只剩下一个元素
     * 每次pop之后，总会有一个队列为空
     *
     * 这里的队列没有pushQueue\popQueue的概念
     * 多余的队列是用来帮助pop时剩下一个元素的
     */

    Queue queue1 = new LinkedList();
    Queue queue2 = new LinkedList();

    public void push(Object o) {
       if (queue1.isEmpty()) {
           queue1.add(o);
       }else {
           queue2.add(o);
       }
    }

    public Object pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
    }
}
