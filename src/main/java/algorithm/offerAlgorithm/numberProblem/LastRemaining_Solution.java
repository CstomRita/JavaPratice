package algorithm.offerAlgorithm.numberProblem;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:05 2019-03-23
 * @ Description：圆圈中剩下的数
 * 他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,输出这个小朋友的序号
 * (注：小朋友的编号是从0到n-1)
 * @ Modified By：
 * @Version: $
 */
public class LastRemaining_Solution {

    /**
     * 初始状态是 0 1 2 3 ....n 用一个数组记录
     * 循环 n - 1次，每次去除一个数，循环时记录上次的start位置，循环m-1次找到要去除的元素
     * 这样总共时间复杂度O(mn)
     * 记录这个被删除的元素状态，
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        int [] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = i;
        }
        int start = 0;
        int index = m;
        int count = n;
        while (count > 0) {
          if (start >= n) start -= n;
          if (res[start] != -1 && index > 1) {
              index--;
          }else if (res[start] != -1 && index == 1) {
              System.out.println(start);
              index = m;
              count --;
              res[start] = -1;
          }
          start++;
        }
        return start - 1;
    }

    @Test
    public void test() {
        System.out.println(LastRemaining_Solution(7,3));
    }
}
