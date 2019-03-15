package algorithm.offerAlgorithm.otherProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:03 2019-03-10
 * @ Description：跳台阶II：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @ Modified By：
 * @Version: $
 */
public class JumpFloorII {

    /**
     * f(n) = f(n-1) + f(n-2) + .... + f(0)
     * f(0) = 1
     * f(1) = 1
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        int[] res = new int[target + 1];
        res[0] = 1;
        int nums = 0;
        for(int i = 1; i <= target; i++) {
            nums += res[i-1];
            res[i] = nums;
        }
        return res[target];
    }

    @Test
    public void test() {
        System.out.println(JumpFloorII(4));
    }
}
