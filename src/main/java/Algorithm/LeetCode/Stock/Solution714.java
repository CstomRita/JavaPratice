package Algorithm.LeetCode.Stock;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午9:29 2018/10/13
 * @ Description：Leetcode 714
 * @ Modified By：
 * @Version: $
 */
public class Solution714 {
    /**
     * 依然不限制次数
     * 只是每次交易需要支付一个手续费
     *
     * 也就是说如果当前收益大于fee，就是收益的 否则就不要交易
     *
     * 需要采用动态规划
     *
     * 动态规划：得到最大值 最优解
     *
     * 两个状态 两个数组
     *
     * hold[i] = max ( hold[i-1], unhold[i-1]-prices[i] )
     * unhold[i] = max( unhold[i-1], hold[i-1]+prices[i]-fee)
     *
     * 第二点 看递归出口
     * hold[0] = -prices[0] unhold[0] = 0
     *
     * 最后的结果 unhold(length-1)
     *
     * 递归和动态规划的关系在于会有重叠子问题，即dp(n)在前面计算过的，在后面还需要再次计算
     * 因此创建一个新的dp数组，用来存放所有以及计算出的dp值
     *
     * 第三点 dp数组的计算方式（从前向后计算）
     * 要和你得到递归式的方向相反
     *
     */
    public int maxProfit(int[] prices, int fee){
        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        hold[0] = -prices[0];
        unhold[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i-1],unhold[i-1]-prices[i]);
            unhold[i] = Math.max(unhold[i-1],hold[i-1]+prices[i]-fee);
        }
        return unhold[prices.length-1];
     }

    /**
     * 一个优化：
     * 根据状态转移方程我们得知只和状态i-1有关系
     * 我们可以使用一个变量代替这个数组
     * 同样 unhold初始为0 hold初始为-prices[0]
     */
    public int maxProfit2(int[] prices, int fee){
        int hold = -prices[0];
        int unhold = 0 ;
        for(int i = 1; i < prices.length; i++) {
            hold = Math.max(hold,unhold-prices[i]);
            unhold = Math.max(unhold,hold+prices[i]-fee);
        }
        return unhold;
    }
}
