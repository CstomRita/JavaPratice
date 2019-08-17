package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:44 2019-03-20
 * @ Description：一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * @ Modified By：
 * @Version: $
 */
public class FindNumsAppearOnce {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    /**
     * 出现了偶数次，不仅仅是两次
     * 第一个思路 使用哈希集合，集合里面有则删除，集合里面没有则添加
     * 时间复杂度O(n)
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : array) {
            if (set.contains(i)) {
                set.remove(i);
            }else {
                set.add(i);
            }
        }
       Iterator iterator = set.iterator();
        if (iterator.hasNext()) {
            num1[0] = (int) iterator.next();
        }
        if (iterator.hasNext()) {
            num2[0] = (int) iterator.next();
        }
    }

    @Test
    public void test() {
        int[] nums1 = new int[1];
        int[] nums2 = new int[1];
        FindNumsAppearOnce(new int[]{1,2,5,6,8,0,0,8,8,8,2,6,2,1},nums1,nums2);
        System.out.println(nums1[0]);
        System.out.println(nums2[0]);
    }
}
