package algorithm.combineAndArrange;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:53 2019-08-17
 * @ Description：解决Cmn
 * @ Modified By：
 * @Version: $
 */
public class Rank3 {

    @Test
    public void test() {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        int[] numbers = new int[]{1,2,3,4,5,6,7,8};
        int n = 4;
        int[] used = new int[numbers.length];
        rank(numbers,n,0,-1,arrayList,stack);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }

    /**
     * @Author: ChangSiteng
     * @Description:
     * @param number:
      * @param n: 需要选择n个数
      * @param k: 当前选择了K个数
      * @param index: 当前选择的第K个数的下标时(最大下标，初始化为-1)
      * @param list:
      * @param stack:
     * @return: void
     */
    public void rank(int[] number, int n, int k, int index, List list, Stack stack) {

        if ( n == k) {
            list.add(Arrays.toString(stack.toArray()));
            return;
        }

        for (int i = index + 1 ; i < number.length; i++) {
            stack.push(number[i]);
            rank(number,n,k+1,i,list,stack);
            stack.pop();
        }
    }
}
