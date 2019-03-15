package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:04 2019-03-11
 * @ Description： 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @ Modified By：
 * @Version: $
 */
public class ReorderArray {
    /**
     * 思路一
     * 创建一个新的数组，依次遍历把奇数分到左边，偶数分到右边
     * 再把得到的数组赋值给原数组
     *
     * 繁琐
     * 复杂度O（n）
     * @param array
     */
    public void reOrderArray(int [] array) {
        int[] result = new int[array.length];
        int left = 0, right = array.length - 1;
        int i = 0, j = array.length - 1;
        while(left < array.length || right >= 0) {
            if (left < array.length &&  array[left] % 2 == 1) {
                result[i++] = array[left];
            }
            if (right >= 0 && array[right] % 2 == 0) {
                result[j--] = array[right];
            }
            left++;
            right--;
    }
        for(int k = 0; k < array.length; k++) {
            array[k] = result[k];
        }

    }

    @Test
    public void test() {
        int[] test = new int[]{1,2,3,4,5,6,7,8};
        reOrderArray(test);
        System.out.println(Arrays.toString(test));
    }
}
