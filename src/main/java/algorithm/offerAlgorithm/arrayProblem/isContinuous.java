package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:40 2019-03-23
 * @ Description：数组内的数是不是连续的
 * @ Modified By：
 * @Version: $
 */
public class isContinuous {

    /**
     * 给定的数组是否是连续的数 2 3 4 6 5 这种
     * 其中0 可以代替任何元素，0可以有多个
     *
     * 思路一：利用hashset把所有元素添加
     * 再遍历一遍查找i+1
     * 时间复杂度O(n)
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous1(int [] numbers) {
        if (numbers.length == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        int maxVluae = 0;
        int count = 0;
        for (int i : numbers) {
            if (i == 0) {
                count++;
            }else if(set.contains(i)) {
                return false;
            }else {
                set.add(i);
                maxVluae = Math.max(maxVluae,i);
            }
        }
        while (count >= 0) {
            if (!set.remove(maxVluae--)) count--;
        }
        return set.isEmpty();
    }

    /**
     * 优化算法：关于数的连续问题：
     * 将数组从小到大排序
     * 两个相邻数之间的差值-1，就是这两个数中间差多少元素
     * 如果最后差值为0，则表示为这个序列是可以组成连续序列的。
     * 时间复杂度也是O(n)
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) return false;
        Arrays.sort(numbers);
        int gap = 0;
        int numberOfZero = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                numberOfZero++;
            }else if (numbers[i] == numbers[i+1]) {
                return false;
            }else {
                gap += numbers[i+1] - numbers[i] - 1;
            }
        }
        return numberOfZero - gap >= 0;
    }

    @Test
    public void test() {
        System.out.println(isContinuous(new int[]{1,3,0,4,0}));
    }
}

