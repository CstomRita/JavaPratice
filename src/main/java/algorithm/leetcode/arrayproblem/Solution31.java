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
     * 31
     * @param nums
     */
    public void nextPermutation1(int[] nums) {
        int length = nums.length - 1;
        int index = 0;
        int resort_index = length;
        // 1 获取第一个左边小于右边的数字
        for(int i = length; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                index = i-1;
                resort_index = i;
                break;
            }else if (i == 1) {
                changeSort(nums,0,length);
                return;
            }
        }
        // 2 找比第一步找到的数字大的第一个数字并交换
        for (int i = length; i >= 0; i--) {
            if(nums[i] > nums[index] || i == 0) {
                int swap = nums[i];
                nums[i] = nums[index];
                nums[index] = swap;
                break;
            }
        }
        // 3 重新排序
        changeSort(nums,resort_index,length);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 从left开始 到 right的顺序颠倒
     * @param nums
     * @param left
     * @param right
     */
    public void changeSort(int[] nums, int left, int right) {
        System.out.println(left + " " + right);
        if(right <= left || right > nums.length-1 || left < 0) return;
        int index = (right - left + 1) / 2;
        System.out.println(index);
        for(int i = 0; i < index; i++) {
            int swap = nums[left + i];
            nums[left + i] = nums[right - i];
            nums[right - i] = swap;
        }
    }

    /**
     * 获取下一个字典序列
     */
    private HashSet<String> set = new HashSet<String>();
    public void nextPermutation(int[] nums) {
        int length = nums.length - 1;
        int index = 0;
        int resort_index = length;
        // 1 获取第一个左边小于右边的数字
        for(int i = length; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                index = i-1;
                resort_index = i;
                break;
            }else if (i == 1) {
                // 最大序列返回的是最小数
                System.out.println("最大序列");
                changeSort(nums,0,length);
                return;
            }
        }
        // 2 找比第一步找到的数字大的第一个数字并交换
        for (int i = length; i >= 0; i--) {
            if(nums[i] > nums[index] || i == 0) {
                int swap = nums[i];
                nums[i] = nums[index];
                nums[index] = swap;
                break;
            }
        }
        // 3 重新排序
        changeSort(nums,resort_index,length);
        // 4 循环
        set.add(Arrays.toString(nums));
        nextPermutation(nums);
    }



    /**
     * 获取全部字典数
     */
    @Test
    public void getAllPermutation() {
        int[] nums = new int[]{1,3,2};
        System.out.println("原始数字 ："+ nums);
        nextPermutation1(nums);
        System.out.println(set.toString());
    }
}