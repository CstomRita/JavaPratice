package algorithm.leetcode.arrayproblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:29 2019-03-07
 * @ Description：要求O(logn)查找，log级别折半二分查找
 * @ Modified By：
 * @Version: $
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] reslut = new int[]{-1, -1};
        if (nums.length == 0) {
            return reslut;
        }
        int startIndex = 0, endIndex = nums.length - 1;
        int index  = 0;
        while(startIndex < endIndex) {
           index = (startIndex + endIndex + 1) / 2;
            if (nums[index] < target) {
                startIndex = index;
            }else if (nums[index] > target){
                endIndex = index;
            }else {
                //相等，如何处理向左右
                break;
            }
        }
        //找到相等
        if(nums[index] == target) {
            startIndex = index;
            endIndex = index;
            boolean flag1 = false,flag2 = false;
            while(startIndex <= endIndex) {
                if(startIndex >= 0 && nums[startIndex] == target) {
                    startIndex--;
                }else {
                    flag1 = true;
                }
                if (endIndex < nums.length && nums[endIndex] == target) {
                    endIndex++;
                }else {
                    flag2 = true;
                }
                if(flag1 && flag2) {
                    break;
                }
            }
            reslut[0] = startIndex + 1;
            reslut[1] = endIndex - 1;
        }
        return reslut;
    }
}
