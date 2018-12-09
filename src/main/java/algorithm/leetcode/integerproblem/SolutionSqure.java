package algorithm.leetcode.integerproblem;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午3:40 2018/11/4
 * @ Description：开平方运算
 * @ Modified By：
 * @Version: $
 */
public class SolutionSqure {


    /**
     *
     * @param n  需要开根号的数据
     * @param m  需要保留的精度,即几位小数
     * @return
     */
//    public  double MathSqure(int n, int m){
//        double  result = 0;
//        double index = 1;
//        for(int i = 0; i <= m; i++) {
//            int temp = squre((int)((n-result*result) / index));
//            result += temp * index;
//            index *= 0.1;
//        }
//    }

    /**
     *
     * @param n 开根号的目标数
     * @return 返回根号的整数
     */
    private int squre(int n) {
        if(n == 1) return 1;
        // 二分查找
        // i < n/2 + 1
        for(int i = 1; i < n/2+1; i++) {
            if(i * i == n) return i;
            if(i * i > n) return i-1;
        }
        return 0;
    }

}
