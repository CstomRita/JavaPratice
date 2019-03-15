package algorithm.offerAlgorithm.collectionProblem;

import org.junit.Test;

import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 12:19 2019-03-13
 * @ Description：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 这里需要注意的是，入栈顺序不是一直入栈一直入栈
 * 在入栈的时候是有可能出栈的
 * 因此才会有多种出栈顺序
 * @ Modified By：
 * @Version: $
 */
public class IsPopOrder {

    /**
     * 这是一种思路，通过遍历出栈的顺序，根据出栈的顺序倒退入栈的顺序，看每一个出栈是否能找到合理地入栈点
     *
     * 其实还可以更简化一些，正向推，遍历入栈的顺序，看根据给出的顺序出栈，最后栈中是否还有剩余元素
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder1(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < popA.length) {
            if (!stack.empty() && popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }else {
                while (pushIndex < pushA.length && pushA[pushIndex] != popA[popIndex]) {
                    stack.push(pushA[pushIndex++]);
                }
                if (pushIndex >= pushA.length) {
                    return false;
                }else {
                    popIndex++;
                    pushIndex++;
                }
            }
        }
        return true;
    }

    /**
     * 其实还可以更简化一些，正向推，遍历入栈的顺序，看根据给出的顺序出栈，最后栈中是否还有剩余元素
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i : pushA) {
            stack.push(i);
            //出栈条件
            while (!stack.empty() && popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    @Test
    public void test(){
        System.out.println(IsPopOrder1(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
