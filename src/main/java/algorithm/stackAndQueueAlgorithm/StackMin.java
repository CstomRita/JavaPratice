package algorithm.stackAndQueueAlgorithm;

import org.junit.Test;

import java.util.Stack;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午3:27 2018/10/16
 * @ Description：一个stack push pop时总能通过一个max方法获取当前stack中的最大值
 * @ Modified By：
 * @Version: $
 */
class StackMax<T extends Comparable> {
    private Stack<T> stackMax ;
    private Stack<T> stack;

    public StackMax(){
        this.stack = new Stack<T>();
        this.stackMax = new Stack<T>();
    }

    public void push(T obj) {
        if(stackMax.empty() || obj.compareTo(getMax()) >= 0) { //只存储比栈顶元素大于等于的元素
            stackMax.push(obj);
        }
        stack.push(obj);
    }

    public T pop() {
        T t = stack.pop();
        if(t.compareTo(getMax()) == 0) {
            stackMax.pop();
        }
        return t;
    }

    public T getMax() {
        return stackMax.peek();
    }
}
public class StackMin{

    @Test
    public void test() {
        StackMax<Integer> stack = new StackMax<Integer>();
        stack.push(5);
        System.out.println(stack.getMax());
        stack.push(2);
        System.out.println(stack.getMax());
        stack.push(3);
        System.out.println(stack.getMax());
        stack.push(1);
        System.out.println(stack.getMax());
        stack.push(1);
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());
    }
}
