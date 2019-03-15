package algorithm.offerAlgorithm.otherProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:33 2019-03-09
 * @ Description：一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @ Modified By：
 * @Version: $
 */
public class JumpFloor {

    /**
     * 明显的选和不选的问题，归结为动态规划的问题
     * 1. 确定边界和递推表达式，从后向前，此刻的选择只和之前的选择有关，和之后无关
     * 本题求的是跳上一个n级的台阶总共有多少种跳，f(i)表示跳上i级台阶的方法数
     * 只和之前的状态有关，表示跳上之前台阶的方法数是已知的
     * 跳上i级台阶有两种情况，一种是在i-1上跳一级，一种是i-2上跳两级
     * f(i) = f(i-1) + f(i-2)
     * 2. 使用数组代替递归，从前向后，从已经知道的条件开始向后推
     * f(0) = 0 f(1) = 1 f(2) = 2
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int[] result = new int[target];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < target; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[target - 1];
    }
}
