package algorithm.offerAlgorithm.otherProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:19 2019-03-10
 * @ Description：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。可以横着或者竖着
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 像这种有多少方法等等的，第一反应就是动态规划，找f(n)的递推公式
 * @ Modified By：
 * @Version: $
 */
public class RectCover {

    /**
     * f(n) = f(n-1) + f(n-2)
     * f(i)表示覆盖完i列矩形用到的方法数
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 0) return 0;
        int[] res = new int[target+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= target; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[target];
    }

    @Test
    public void test() {
        System.out.println(RectCover(3));
    }
}
