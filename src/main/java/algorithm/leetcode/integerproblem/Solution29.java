package algorithm.leetcode.integerproblem;

import org.junit.Test;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午9:45 2018/10/8
 * @ Description：不使用乘法\除法\求模计算
 * 计算两个数的除法~
 * 只能使用加减的情况下
 * 类似于二分查找，每次递增 * 2 可以将复杂度变成O logN
 * 思路：
 * 定义两个变量 result=1 和 temp = 除数
 * 从除数开始每次递增temp += temp result+=result，当被除数小于temp的时候说明 除数在 result 和 2*result之间
 * 此时再使用递归去计算 被除数-temp的出发结果 + result
 * @ Modified By：
 * @Version: $
 */
public class Solution29 {
    /**
     * 除法运算：被除数中包含有多少个除数的计算
     * 类比一下 开平方的运算，log复杂度，二分查找法
     * 假设此时都是正整数
     *
     * PPS 需要考虑溢出的情况,题目要求 assume that your function returns 2^31 − 1 when the division result overflows.
     * 溢出问题的考虑
     * 1 一般是乘10 除10的时候可以考虑余数的问题
     * 但是这里要求不能使用其他运算
     * 2 对于int的话，可以考虑把数据结构提高到long，在和MAX MIN比对
     *
     */
    private long divided(long dividend, long divisor) {
       if(dividend < divisor || dividend == 0) return 0;
       long temp = divisor;
       long min = divisor;
       long result = 1;
       while(temp <= dividend) {
           min = temp;
           temp += temp;
           if(temp <= dividend) result += result;
       }
       return result+divided(dividend-min,divisor);
    }
    public int divide(int dividend,int divisor) {
        boolean isNegative = (dividend<0 && divisor >0) || (dividend>0 && divisor < 0) ? true :false;
        long result = divided(Math.abs((long) dividend),Math.abs((long) divisor));
        if(result > Integer.MAX_VALUE) return isNegative? Integer.MIN_VALUE:Integer.MAX_VALUE;
        return isNegative? -(int) result:(int) result;
    }

    @Test
    public  void test() {
        System.out.println(divide(-2147483648,1));
    }
}
