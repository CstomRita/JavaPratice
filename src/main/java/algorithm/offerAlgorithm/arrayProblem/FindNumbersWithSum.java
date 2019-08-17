package algorithm.offerAlgorithm.arrayProblem;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:11 2019-03-22
 * @ Description：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @ Modified By：
 * @Version: $
 */
public class FindNumbersWithSum {

    /**
     * 递增的数组，第一反应双指针
     * 要求输出两个数乘积最小
     * 也就是从首尾开始最先找到的
     *
     * 可以想到的思路：
     * 1. 使用Hash遍历一遍，再遍历一遍看Hash中是否存在sum-array[i]，复杂度O(n)
     *
     * 2. 双指针，left从左边开始，right从右边开始
     * 如果left + right > target，说明right--，因为left移动只会增加
     * 如果left + right < target，说明left++
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right) {
            int sum1 = array[left] + array[right];
            if (sum1 > sum) {
                right--;
            }else if (sum1 < sum) {
                left++;
            }else {
                result.add(array[left]);
                result.add(array[right]);
                return result;
            }
        }
        return result;
    }
}
