package algorithm.combineAndArrange;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:31 2019-08-17
 * @ Description：解决Amn的问题
 * @ Modified By：
 * @Version: $
 */
public class Rank2 {


    @Test
    public void test() {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        int[] numbers = new int[]{1,2,3,4,5};
        int n = 3;
        int[] used = new int[numbers.length];
        rank(numbers,used,n,0,arrayList,stack);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }
    /**
     * @Author: ChangSiteng
     * @Description:
     * @param number:
      * @param used:
      * @param n: 需要选择N个数
      * @param k: 已经选择了K个
      * @param list:
      * @param stack:
     * @return: void
     */
    public void rank(int[] number, int[] used, int n, int k, List list, Stack stack) {

        if( n == k) {
            list.add(Arrays.toString(stack.toArray()));
            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                stack.push(number[i]);
                rank(number,used,n,k+1,list,stack);
                used[i] = 0;
                stack.pop();
            }
        }
    }
}
