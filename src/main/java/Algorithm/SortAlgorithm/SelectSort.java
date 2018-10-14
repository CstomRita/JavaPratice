package Algorithm.SortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午9:30 2018/10/12
 * @ Description：选择排序
 *
 * 选择排序：
 * 找到数组最小的元素和第一个元素交换
 * 然后找第二小的，和第二个交换。。。
 *
 * @ Modified By：
 * @Version: $
 */
public class SelectSort {

    private int[] selectSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int min = i;//最小值的索引
            for(int j = i + 1; j < nums.length; j++) {
                min = nums[j] < nums[min] ? j : min;
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }

    @Test
    public void Test() {
        System.out.println(Arrays.toString(selectSort(new int[]{1,2,5,3,9,0,2,5})));
    }

}
