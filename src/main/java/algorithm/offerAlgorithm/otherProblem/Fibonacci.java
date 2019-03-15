package algorithm.offerAlgorithm.otherProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:22 2019-03-09
 * @ Description：斐波那契数列
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 * F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * @ Modified By：
 * @Version: $
 */
public class Fibonacci {

    /**
     * 递推： F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
     * 采用动态规划，使用一维数组采用非递归思想，减少计算量
     * 数组[i]表示计算出的F(i)，从0、1、2等已经知道的值开始
     * 数组[i] = 数组[j] + 数组[k]，也就是F(i) = F(j) + F(k)
     * 最后输出数组[n]的值即可
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = result[2] = 1;
        for (int i = 3; i < result.length; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[result.length-1];
    }
}
