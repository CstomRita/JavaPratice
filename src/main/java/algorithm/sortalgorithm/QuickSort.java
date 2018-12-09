package algorithm.sortalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午9:13 2018/10/12
 * @ Description：快速排序
 *
 * 快速排序也是一种分治思想
 * 将数组划分成两个子数组分别独立排序
 * 子数组也是采用快速排序
 * 划分数组分别排序
 * 因此也是递归
 *
 * 重点在于如何划分数组
 *
 * 要求 left - mid-1 都小于mid  mid+1 -right都大于mid
 * 选定left作为划分元素，从左边开始找比left大的，右边找比left小的，两者交换，直至左右指针碰头i=j，此时nums[left]位置应该是i,再交换一下
 *
 *
 * 快速排序和归并排序的区别就在这里：
 * 归并排序的划分是随意的，划分之后两个数组再排序
 * 快速排序的划分并不是随意的，快速排序的划分时，已经对left-right间做了改动，左边的都是小的，右边的都是大的，来保证每个子数组都是有序的，且子数组之间也是有序的，整个数组就是有序的
 *
 * @ Modified By：
 * @Version: $
 */
public class QuickSort {

    private void sort(int[] nums, int left, int right) {
        if(left >= right) return;
        int mid = split(nums,left,right);
        sort(nums,left,mid-1);
        sort(nums,mid+1,right);
    }

    private int split(int[] nums, int left, int right) {
        int temp = nums[left];
        int i = left, j = right;
        while(i < j) {
            /**
             * 这里有一些需要注意的地方：
             * 判断条件为 >= 包含等于的时候，是不对等于temp的值作交换的，循环完成之后再交换i和left
             * 这个时候一定要让右指针先移动
             * 一定要让右指针先移动
             * 一定要让右指针先移动
             */
            while(i < j && nums[j] >= temp){--j;}
            while( i < j && nums[i] <= temp){++i;}
            if(i >= j) break;
            int change = nums[i];
            nums[i] = nums[j];
            nums[j] = change;
        }
        System.out.println(i +" "+j);
        int change = nums[i];
        nums[i] = nums[left];
        nums[left] = change;
        return i;
    }

    public int[] quickSort(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(quickSort(new int[]{1,4,9,21,0,2,0,4,-1,9,23,0,3})));
    }
}
