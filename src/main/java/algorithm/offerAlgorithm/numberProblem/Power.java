package algorithm.offerAlgorithm.numberProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:19 2019-03-10
 * @ Description：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @ Modified By：
 * @Version: $
 */
public class Power {
    /**
     * 这里的难点一：
     * 要考虑到各种情况：
     * exponment小于0时
     * exponment等于0时，返回1 但是0的0次方是否有意义
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }
        double res = 1;
        for(int i = 0; i < exponent; i++) {
            res *= base;
        }
        return isNegative? (double) 1/res : res;
    }


    @Test
    public void test() {
        System.out.println();
        System.out.println(Power(2,-2));
    }
}
