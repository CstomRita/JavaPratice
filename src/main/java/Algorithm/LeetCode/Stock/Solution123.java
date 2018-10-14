package Algorithm.LeetCode.Stock;

import org.junit.Test;
import org.junit.runners.Parameterized;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午9:14 2018/10/13
 * @ Description：Leetcode 123
 * @ Modified By：
 * @Version: $
 */
public class Solution123 {
    /**
     * 要求最多完成 2 次交易
     *
     * 动态规划：两种状态 2个变量
     * 两个二维数组
     * hold[i][s] 表示第i天还可以交易S次下hold状态下的最大收益
     *
     */
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[][] hold = new int[prices.length][3];
        int[][] unhold = new int[prices.length][3];
        hold[0][0] = hold[0][1] = hold[0][2] = -prices[0];
        unhold[0][0] = unhold[0][1] = unhold[0][2] = 0;
        for(int j = 1; j < prices.length; j++) {
            hold[j][0] = hold[j-1][0];
            unhold[j][0] = unhold[j-1][0];
        }
        for(int i = 1; i < prices.length; i++) {
            for(int s = 1; s <= 2 ; s++) {
                hold[i][s] = Math.max(hold[i-1][s],unhold[i-1][s-1]-prices[i]);
                unhold[i][s] = Math.max(unhold[i-1][s],hold[i-1][s]+prices[i]);
                //交易hold买入时交易次数减一
            }
        }
        return unhold[prices.length-1][2];
    }

    /**
     * 上面算法 O n^2
     * 如何优化
     * 就像714题说的，当状态i和某一个相对固定的i-1数组值有关的时候，其实是没有必要拿数组的
     * 完全可以使用某一个变量代替
     *
     * 对于二维数组如何代替呢，要令s相对固定，例如hold[i][s]就需要拿出所有s的值 0 1 2
     * 得到一个hold0 = hold[i][0] hold1 = hold[i][1] hold2 = hold[i][2]
     *
     * 初始化时hold0 = hold[0][0] hold1 = hold[0][1] hold2 = hold[0][2]
     *
     * hold[i][s] = Math.max(hold[i-1][s],unhold[i-1][s-1]-prices[i]);
     * 对于hold1来说,当前所有s都是1 hold1 = Math.max(hold1,unhold0-prices[i])
     *
     * 对unhold[i][s]来讲也是一样
     *
     * 这样拿出每个S，可以降维，将两个for循环改变成一个即可
     *
     */


    public int maxProfit2(int[] prices) {
        if(prices.length < 2) return 0;
        int hold0 = -prices[0],hold1 = -prices[0],hold2 = -prices[0];
        int unholder0 = 0,unholder1 = 0, unholder2 = 0;
        for(int i = 0; i < prices.length; i++) {
            //hold减一 unholder不减
            hold1 = Math.max(hold1,unholder0-prices[i]);
            unholder1 = Math.max(unholder1,hold1+prices[i]);
            hold2 = Math.max(hold2,unholder1-prices[i]);
            unholder2 = Math.max(unholder2,hold2+prices[i]);
        }
        return unholder2;
    }

}
