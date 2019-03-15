package algorithm.offerAlgorithm.collectionProblem;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:48 2019-03-12
 * @ Description：定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 * @ Modified By：
 * @Version: $
 */
public class MinStack {
    private Stack<Integer> stack = new Stack();//用于存放元素的stack
    private Stack<Integer> minStack = new Stack();
    //要求得到Min函数的时间复杂度为O(1)，stack出栈的时间复杂度就是O（1）
    //我们维护一个最小值的Stack，入栈时元素如果比当前栈顶小或相等则存放在minStack中，如果大则不操作
    //出栈时查看出栈是哪一个元素，如果比minStack元素大，不操作，如果相等minStack也要pop
    //这样可以保证无论怎么出栈，minStack的栈顶元素是剩下stack中最小的
    public void push(int node) {
        if (minStack.empty() || node <= minStack.peek()) {
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.pop() == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * 取栈顶元素
     * @return
     */
    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
