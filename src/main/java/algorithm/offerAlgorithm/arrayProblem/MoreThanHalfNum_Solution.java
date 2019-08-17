package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:55 2019-03-15
 * @ Description：
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * @ Modified By：
 * @Version: $
 */
public class MoreThanHalfNum_Solution {

    /**
     * 普通想法：用hashMap记录元素和出现次数
     * 空间复杂度O(n)
     * 时间复杂度O（n）
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0]; //注意只有一个数组的特殊情况
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int length = array.length;
        for(int i : array) {
            if (hashMap.containsKey(i) ){
              int value = hashMap.get(i) + 1;
              hashMap.put(i,value);
              if (value > length/2) return i;
            }else {
                hashMap.put(i,1);
            }
        }
        return 0;
    }

    /**
     * 包含重复元素的获取第K小
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    public int getKmin(int[] array, int left, int right, int k) {
       int i = left, j = right;
       int temp = array[left];
       while (i < j) {
           while ( j > i && array[j] >= temp ) j--;
           while (j > i && array[i] <= temp ) i++;
           if (i >= j) break;
           int tem = array[i];
           array[i] = array[j];
           array[j] = tem;
       }
       int tem = array[i];
       array[left] = array[i];
       array[i] = tem;
       if (i > k-1) {
           return getKmin(array,left,i-1,k);
       }else if (i < k-1) {
           return getKmin(array, i + 1, right,k);
       }else {
           return array[i];
       }
    }

    /**
     * 非重复元素的获取第K小
     * @// TODO: 2019-03-17  仍未写完，如何去重
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    public int getKminNoRepeat(int[] array,int left, int right,int k) {
        if (left >= right) return array[left];
        int i = left, j = right;
        int temp = array[left];
        while (i < j) {
            while ( j > i && array[j] >= temp ) {
                j--;
                if (array[j] == temp) k++;
            }
            while (j > i && array[i] <= temp ) {
                i++;
                if (array[j] == temp) k++;
            }
            if (i >= j) break;
            int tem = array[i];
            array[i] = array[j];
            array[j] = tem;
        }
        int tem = array[i];
        array[left] = array[i];
        array[i] = tem;
        if (i > k-1) {
            return getKminNoRepeat(array,left,i-1,k);
        }else if (i < k-1) {
            return getKminNoRepeat(array, i + 1, right,k);
        }else {
            return array[i];
        }
    }

    /**
     * 特殊的，如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
     * 如果同时去掉两个不同的数字，一直到最后只剩下一个元素，那剩下的这个元素就是这个数字。
     * 如果剩下两个元素，这两个元素也应该是一样的，都是这个元素。
     * 这是用到了超出一半多元素的特殊性。
     * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。
     * 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
     * 若次数为0，则保存下一个数字，并将次数置为1。
     * 遍历结束后，所保存的数字即为所求。
     * 然后再判断它是否符合条件即可。
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++ ) {
            if (count == 0) num = array[i];
            if (array[i] == num) count++;
            else count--;
        }

        //再循环验证
        int numCount = 0;
        for(int i : array) {
            if (i == num) numCount++;
        }
        return numCount * 2 > array.length ? num : 0;
    }
    @Test
    public void test() {
        int[] ints = {5, 2, 3, 1, 1, 2, 3, 4, 0,0,0};
        System.out.println(getKmin(ints,0,ints.length-1,5));

    }
}
