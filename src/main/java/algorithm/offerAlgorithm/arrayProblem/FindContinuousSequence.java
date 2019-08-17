package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:59 2019-03-21
 * @ Description：输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 *
 *
 * @ Modified By：
 * @Version: $
 */
public class FindContinuousSequence {

    /**
     * 首先 连续正数序列
     * 其次 至少包括两个数
     *
     * 思路1 ： 应该从什么地方开始找
     * 首先至少两个数，那么这个数最大就到 sum / 2
     * 最多多少数相加，是从1开始的， 1 2 3 ....加到多少是sum，也就是说明最多有多少数
     * n(n+1)/2 = sum
     * 剩下要找的就是使用滑动窗口的思想
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum < 3) return result;
        int left = 1, right = 2;
        int sum1 = 0;
        int endNumber = (sum + 1) / 2;
        while (left <= endNumber) {
            sum1 = (left + right) * (right - left + 1) / 2;
            if (sum1 > sum) {
                left++;
            }else if (sum1 < sum) {
                right++;
            }else {
                ArrayList<Integer> res = new ArrayList<>();
                for(int i = left; i <= right; i++) {
                    res.add(i);
                }
                result.add(res);
                left++;
            }
        }
        return result;
    }

  @Test
    public void test() {
      System.out.println(FindContinuousSequence(100));
    }
}
