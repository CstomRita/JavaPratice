package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:07 2019-03-09
 * @ Description：旋转数组的最小数字
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @ Modified By：
 * @Version: $
 */
public class MinNumberInRotateArray {

    /**
     * 最普通的想法，找左元素大于右元素的
     * 时间复杂度最大为O(n)，不是最优解法
     * 对于相对有序的数组查找，尽量采用二分查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int [] array) {
        if (array.length == 0 ) return 0;
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i-1]) {
                return array[i];
            }
        }
        return array[0];
    }

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0 ) return 0;
      // 1 如果是未旋转数组，直接返回array[0]
        if(array[0] < array[array.length-1]) return array[0];
        //2 尝试二分查找
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int index = left + (right - left)/2;
            if (array[index] > array[left]){
                left = index;
            }else if (array[index] < array[left]) {
                right = index;
            }else {
                //3 如果二分查找不可用，只能顺序查找
                return minNumberInRotateArrayByOrder(array,left,right);
            }
        }
      return array[right];
    }
    private int minNumberInRotateArrayByOrder(int [] array,int left, int right) {
        for(int i = left+1; i <= right; i++) {
            if(array[i] < array[i-1]) {
                return array[i];
            }
        }
        return array[left];
    }
    @Test
    public void test() {
        System.out.println(minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }
}
