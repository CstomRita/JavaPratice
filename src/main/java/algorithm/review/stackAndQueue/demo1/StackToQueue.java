package algorithm.review.stackAndQueue.demo1;

import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:09 2019-05-14
 * @ Description：两个栈实现一个队列
 * @ Modified By：
 * @Version: $
 */
public class StackToQueue {

    /**
     * 一个栈用来push
     * 一个栈用来pop
     * push时要求元素都在pushStack中，popSatck为空
     * pop时要求元素都在popStack中，pushStack为空
     *
     * 总有一个Stack为空
     */
    Stack pushStack = new Stack();
    Stack popStack = new Stack();

    public void push(Object o) {
        while (!popStack.empty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(o);
    }

    public Object pop(){
        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
}
