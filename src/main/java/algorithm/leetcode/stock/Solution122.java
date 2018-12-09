package algorithm.leetcode.stock;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午8:39 2018/10/13
 * @ Description：Leetcode 122
 * @ Modified By：
 * @Version: $
 */
public class Solution122 {
    /**
     * 可以进行多次交易
     * 再次买入时需要先卖出
     * 多次交易的时候 看折线图就能看出来在拐点处买入买出相加之后的和 会比单次最高的和大
     * 不必去看每次的最大值，只要在上升前的一天买入，在下降前的一天卖出
     *
     * 这个买入卖出的关键点 在于 用折线图 查看变量关系
     *
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length-1; i++) {
            while(i < prices.length-1 && prices[i+1] < prices[i]){i++;}
            int buyPrice = prices[i];
            while(i < prices.length-1 && prices[i+1] > prices[i]){i++;}
            maxProfit += prices[i] - buyPrice;
        }
        return maxProfit;
    }

    /**
     * 通过折线图我们还能看出 不一定要查询到拐点的位置
     * 当一个折线在上升时，最高点减去最低点 其实就是 每个 i+1 - i 的和、
     * 故只要price[i]> price[i-1] 折线处于上升状态时 就直接相加就好
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
