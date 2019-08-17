package algorithm.offerAlgorithm.numberProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:34 2019-03-19
 * @ Description：获取第N个丑数
 * @ Modified By：
 * @Version: $
 */
public class GetUglyNumber_Solution {

    /**
     * 求按从小到大的顺序的第index个丑数。
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] res = new int[index];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(Math.min(res[p2] * 2,res[p3]*3),res[p5] * 5);
            if (res[i] == res[p2] * 2) p2++;
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
        }
        System.out.println(Arrays.toString(res));
         return res[index-1];
    }

    @Test
    public void  test() {
        System.out.println(GetUglyNumber_Solution(5));
    }
}
