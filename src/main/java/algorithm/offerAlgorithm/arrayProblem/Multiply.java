package algorithm.offerAlgorithm.arrayProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:42 2019-03-25
 * @ Description：给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 没有乘A[i]
 * B[1] 0= A [0] A[2] A[3] ....A[n-1]
 *
 * 不能使用除法
 *
 * 只能使用乘法，将B[i]分为两个部分，一部分是A[0]...A[i-1]，一部分是A[i+1]....A[n-1]
 * 对于左部分，从B[0]开始有 B[i] = B[i-1]A[i-1]
 * 对于右部分，从B【n-1】开始有 B【i】 = B【i+1】A[I+1]
 *
 * 如此两个O(n)的for循环，一共O(n)
 *
 * @ Modified By：
 * @Version: $
 */
public class Multiply {

    /**
     * 将数的乘法分为两个部分，主要思路看上面
     * 好好看这个思路
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int []  result = new int[A.length];
        result[0] = 1;
        for (int  i = 1; i < A.length; i++) {
            result[i] = result[i-1]*A[i-1];
        }
        int temp = 1;
        for(int j = A.length - 2; j >= 0; j--) {
            temp = temp * A[j+1];
            result[j] = result[j] * temp;
        }
        return result;
    }

}
