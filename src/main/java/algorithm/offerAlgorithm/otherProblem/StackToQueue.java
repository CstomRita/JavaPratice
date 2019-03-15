package algorithm.offerAlgorithm.otherProblem;

import org.junit.Test;

import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:09 2019-03-09
 * @ Description： 两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @ Modified By：
 * @Version: $
 */
public class StackToQueue {
    class StackQueue {
        /**
         * 整体思路是元素先依次进入栈1，再从栈1依次弹出到栈2，然后弹出栈2顶部的元素，整个过程就是一个队列的先进先出
         * stack1用来入栈，stack2用来出栈
         * 一直入栈时stack2是空的，
         * 一直出栈时stack1是空的
         * 入栈、出栈转换时要把一个stack清空移到另外一个stack中
         */
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }

        public int pop() {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    @Test
    public void test() {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        System.out.println(stackQueue.pop());
        stackQueue.push(3);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        stackQueue.push(4);
    }
}
