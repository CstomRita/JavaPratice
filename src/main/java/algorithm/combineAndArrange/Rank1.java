package algorithm.combineAndArrange;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:29 2019-08-16
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Rank1 {

    /**
     * @Author: ChangSiteng
     * @Description: 
     * @param n: 选取n个数
      * @param k: 已经选取了k个数
      * @param numbers: 存放m个选择的数组
      * @param list: 存放所有选择的list
      * @param stack: 存放已经选取的数的栈结构
     * @return: void
     */
    public void rank(int n, int k, int[] numbers, ArrayList list, Stack stack){
        // 已经做完一次结果组合
        if (n == k) {
            list.add(Arrays.toString(stack.toArray()));
            return;
        }

        // 遍历number，做m次选择
        for (int number : numbers) {
            stack.push(number);
            rank(n,k+1,numbers,list,stack);
            stack.pop();
        }

    }

    @Test
    public void test() {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        int[] numbers = new int[]{1,2,3,4};
        int n = 3;
        rank(3,0,numbers,arrayList,stack);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }
}
