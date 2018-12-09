package algorithm.sortalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午9:53 2018/10/12
 * @ Description：插入排序
 *
 * 将每一个元素插入到他应该在的位置上
 * 将nums[i]插入到nums[i-1]、nums[i-2]、nums[i-3]........中
 * 向后遍历进行向前插入的操作
 * 保证i的左侧是有序的
 * 这样当i遍历到数组最右侧的时候，整个数组排序完成
 *
 * 具体插入：
 * nums[i]插入到nums[i-1]、nums[i-2]、nums[i-3]........中
 * 令j=i+1;
 * nums[j]如果比nums[j-1]小，表示nums[j]需要向后移，便和nums[j]做交换 nums[j] nums[j-1]
 * 此时nums[i-1]在后面,nums[i]在前面 j--后 nums[i]——>nums[j]
 * 在和前面的nums[i-2] nums[j-1]比较
 *
 *
 * 插入排序的时间取决于原始数组的初始顺序
 * 对于一个将近有序的数组，使用插入排序会快很多
 *
 * @ Modified By：
 * @Version: $
 */
public class InsertSort {

    private int[] insertSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i+1; j > 0; j--) {
                if(nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(insertSort(new int[]{1,2,5,3,9,0,2,5,-1})));
    }


}
