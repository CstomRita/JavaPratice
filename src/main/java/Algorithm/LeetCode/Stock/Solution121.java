package Algorithm.LeetCode.Stock;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午8:21 2018/10/13
 * @ Description：LeetCode 121
 * @ Modified By：
 * @Version: $
 */
public class Solution121 {

    /**
     * 一次交易
     * 想得到最大的收益 要求之后的价格-之前最小的价格
     * 拿出一个单独变量来记录最小的价格
     * 可以省去一个for循环
     * 因此在当前价格下，必然是在最小价格处买入是最大收益的
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices) {
            minPrice = price < minPrice? price:minPrice;
            maxProfit = (price-minPrice) > maxProfit ? price-minPrice:maxProfit;
        }
        return maxProfit;
    }
}
