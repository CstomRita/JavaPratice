package algorithm.leetcode.arrayproblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:08 2019-02-25
 * @ Description：
 * 实现获取下一个排列的函数，
 * 算法需要将给定数字序列重新排列成字典序中下一个更大的排列。  　　
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。  　　
 * 必须原地修改，只允许使用额外常数空间。  　　
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 　　
 * 1,2,3 → 1,3,2 　　
 * 3,2,1 → 1,2,3 　　
 * 1,1,5 → 1,5,1
 * @ Modified By：
 * @Version: $
 */
public class Solution31 {

    /**
     * 获取下一个字典序列
     */
    private HashSet<String> set = new HashSet<String>();
    public void nextPermutation(int[] nums) {
        int length = nums.length - 1;
        int index = 0;
        int resort_index = length;
        for(int i = length; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                resort_index = i + 1;
                index = i-1;
                break;
            }else if (i == 1) {
                System.out.println("最大序列");
                return;
            }
        }
        for (int i = length; i >= 0; i--) {
            if(nums[i] > nums[index] || i == 0) {
                int swap = nums[i];
                nums[i] = nums[index];
                nums[index] = swap;
                break;
            }
        }
        System.out.println(resort_index);
        for(int i = length; i > (length + resort_index)/2; i--) {
            System.out.println(i);
            int swap = nums[i];
            nums[i] = nums[length+resort_index-i];
            nums[length+resort_index-i] = swap;
        }
        set.add(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums));
       // nextPermutation(nums);
    }

    /**
     * 获取全部字典数
     */
    @Test
    public void getAllPermutation() {
        int[] nums = new int[]{1,4,3,2};
        System.out.println("原始数字 ："+ nums);
        nextPermutation(nums);
        System.out.println(set.toString());
    }
}