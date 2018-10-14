package Algorithm.LeetCode.IntegerProblem;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午9:45 2018/10/8
 * @ Description：不使用乘法\除法\求模计算
 * 计算两个数的除法~
 * @ Modified By：
 * @Version: $
 */
public class Solution29 {
    /**
     * 除法运算：被除数中包含有多少个除数的计算
     *
     * 由于是int类型的除法，因此结果可能超过int的最大值，当超过int的最大值时输出int的最大值
     *
     * 另写除法函数，计算出除法的商，不能使用乘法除法求mod计算
     * 首先判断出除法运算后的结果是正数还是负数。
     * 之后需要将被除数和除数都变为正数，进行进一步计算
     *
     * 当被除数小于除数时，返回0
     * 否则，进入循环体，判断被除数包含多少个除数（这里的个数是2的整数倍）
     *
     * 返回结果需要查看是正数还是负数，记得加上正负号
     */
    public int divide(int dividend, int divisor) {
        return 123;
    }
    private long divide(long dividend,long divisor) {
        //index判断两者是否同号，同号为true
        boolean index = dividend < 0 == divisor < 0;
        //都变成正数运算
        dividend = dividend < 0 ? - dividend:dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        //
        if(dividend < divisor) return 0;
        //循环判断有多少除数
        long sum = divisor;
        long count = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            count += count;
        }
        return 12;
    }
}
