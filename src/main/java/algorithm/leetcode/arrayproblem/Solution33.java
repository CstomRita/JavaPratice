package algorithm.leetcode.arrayproblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:44 2019-02-28
 * @ Description：查找元素中的目标元素
 * 但是该数组是假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * @ Modified By：
 * @Version: $
 */
public class Solution33 {

    @Test
    public void test() {
        System.out.println(search(new int[]{1,3},3));
    }
	 public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
	     int lastIndex = nums.length - 1;
	     if(target < nums[0]) {
	         //从最后开始
             if (target > nums[lastIndex]) {
                 // 比第一个小 比最后一个大 则说明没有
                 return -1;
             }else {
                 // 否则从最后开始向前遍历，降序
                 for (int i = lastIndex; i >= 0; i--) {
                     if (target == nums[i]) {
                         return i;
                     }else if (i == 0 || nums[i - 1] > nums[i]) {
                         return -1;
                     }
                 }
             }
         }else {
	         // 比第一个元素大，说明从一个开始升序，从第一个开始升序
             for(int i = 0; i <= lastIndex; i++) {
                 if (target == nums[i]) {
                     return i;
                 } else if (i == lastIndex || nums[i + 1] < nums[i]) {
                     return -1;
                 }
             }
         }
        return -1;
    }
}
