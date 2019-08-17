package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:16 2019-03-20
 * @ Description：统计一个数字在排序数组中出现的次数。
 * @ Modified By：
 * @Version: $
 */
public class GetNumberOfK {

    /**
     * 第一思路是遍历整个数组，找到这个数之和result++，复杂度O(n)
     *
     * 再优化：有序数组 两个指针,复杂度O(n)??
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK1(int [] array , int k) {
        if (array.length == 0) return 0;
        int left = 0, rigth = array.length - 1;
        while (left < array.length && array[left] < k) left++;
        while (rigth >= 0 && array[rigth] > k) rigth--;
        return rigth - left + 1;
    }

    /**
     * 降低复杂度，又是有序数组，考虑二分查找
     *
     * 二分查找使用递归
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k){
        if (array.length == 0) return 0;
        return GetNumberOfK(array,k,0,array.length-1);
    }
    private int GetNumberOfK(int [] array , int k,int start, int end) {
        if (start == end) {
            return array[start] == k ? 1 : 0;
        }
        int mid = (start + end) / 2;
        return GetNumberOfK(array,k,start,mid) + GetNumberOfK(array,k,mid+1,end);
    }

    @Test
    public void test() {
        System.out.println(GetNumberOfK(new int[]{1,2,3,3,4,4,5,6,8},6));
    }

}
