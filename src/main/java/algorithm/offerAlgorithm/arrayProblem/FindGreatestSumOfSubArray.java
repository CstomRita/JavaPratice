package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:01 2019-03-18
 * @ Description：找连续子序列的最大和
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，
 * @ Modified By：
 * @Version: $
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1 && array[0] <= 0) return 0;
        int[] DP = new int[array.length];
        //DP[i]表示在下标i时的最大值
        int result = Integer.MIN_VALUE;
        DP[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            DP[i] = Math.max(DP[i-1] + array[i],array[i]);
            result = Math.max(result,DP[i]);
        }
        System.out.println(Arrays.toString(DP));
        return result;
    }

    @Test
    public void test() {
        System.out.println(FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }
}
