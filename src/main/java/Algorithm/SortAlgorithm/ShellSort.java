package Algorithm.SortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:52 2018/10/13
 * @ Description：希尔排序
 *
 * 希尔排序是基于快速排序的优化
 * 对于大规模乱序数组快速排序是非常慢的
 *
 * 希尔排序的思想是使数组中间隔为h的元素都是有序的
 * 将间隔为h的元素放在一个子数组中 【1 h+1 2h+1 。。。。】 【2，h+2,2h+2,........]........
 * 使用插入排序对h个子数组排序
 *
 * 不断缩小间隔h，直至h为1
 *
 * 间隔h的缩小：(不一定是这样的 只要间隔在缩小到1 就行)
 *
 * 这个间隔比较有争议，说是这样比较标准
 * 一开始
 * h值最初被赋为1，然后应用公式h=3*h+1生成序列1,4,13,40,121,364，等等。当间隔大于数组大小/3的时候，这个过程停止。
 * h=(h-1)/3
 * 直至为1
 *
 * 像下面每次缩短为2也是可行的
 *
 * @ Modified By：
 * @Version: $
 */
public class ShellSort {

    private int[] shellSort(int[] nums) {

        int h = nums.length/2;
        while (h >= 1) {
            for(int i = h; i < nums.length; i++) {
                //将a[i]插入到a[i-h] a[i-2h]。。。。中
                //这里就是一个插入排序
                //插入排序：向后遍历 向前插入
                //这里的思想理解一下：是将每个子数组的前两个元素排序之后，在排所有子数组三个元素。。。。i的一次增加是改变了一个子数组的 j的-h是对这个子数组的排序
                for(int j = i; j >= h; j -= h) {
                    if(nums[j] < nums[j-h]) {
                        int temp = nums[j];
                        nums[j] = nums[j-h];
                        nums[j-h] = temp;
                    }
                }
            }
            h = h / 2;
        }

        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(shellSort(new int[]{2,1})));
    }

}
