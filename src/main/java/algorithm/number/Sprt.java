package algorithm.number;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:12 2019-03-26
 * @ Description：开平方
 * @ Modified By：
 * @Version: $
 */
public class Sprt {

    /**
     * 使用二分法开平发，精度pre
     *
     * @param target
     * @param pre
     * @return
     */
    public double sqrt(int target,double pre) {
        double low = 0, high = target;
        while ((high - low) > pre) {
            double mid = (high + low) / 2;
            if (mid * mid > target) {
                high = mid;
            }else if (mid * mid < target){
                low = mid;
            }else{
                return mid;
            }
        }
        return (high + low) / 2;
    }

    @Test
    public void test() {
        System.out.println(sqrt(5,1e-7));
    }
}
