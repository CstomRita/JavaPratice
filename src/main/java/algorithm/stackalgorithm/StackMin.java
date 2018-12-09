package algorithm.stackalgorithm;

import org.junit.Test;

import java.util.Stack;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午3:27 2018/10/16
 * @ Description：一个stack push pop时总能通过一个min方法获取当前stack中的最小值
 * @ Modified By：
 * @Version: $
 */
class StackMin1<T extends Comparable> {
    private Stack<T> stackMin ;
    private Stack<T> stack;

    public StackMin1(){
        this.stack = new Stack<T>();
        this.stackMin = new Stack<T>();
    }

    public void push(T obj) {
        if(stackMin.empty() || obj.compareTo(getMin()) <= 0) {
            stackMin.push(obj);
        }
        stack.push(obj);
    }

    public T pop() {
        T t = stack.pop();
        if(t.compareTo(getMin()) == 0) {
            stackMin.pop();
        }
        return t;
    }

    public T getMin() {
        return stackMin.peek();
    }
}
public class StackMin{

    @Test
    public void test() {
        StackMin1<Integer> stack = new StackMin1<Integer>();
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
