package Algorithm.SortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:48 2018/10/13
 * @ Description：归并排序
 *
 * 归并排序在于将两个有序的数组归并到第三个数组中
 * 需要先复制这个数组
 *
 * 对于一个数组的排序而言，首先要分成两个数组再归并
 *
 * 因此采用分治思想：
 * 首先分割数组成两个部分
 * 对每个部分排序
 * 然后归并
 *
 * 对每一个部分的排序同样是采用归并排序：先分割成两份再归并.....
 *
 * 因此是递归函数
 *
 * @ Modified By：
 * @Version: $
 */
public class MergeSort {

    private void merge(int[] nums,int left,int mid,int right) {
        //归并，left-mid mid+1-right为有序状态
        //temp是复制的nums
        int i= left;
        int j = mid+1;
        //需要借助第三方数组
        int[] temp = new int[right+1];
        for(int k = left; k <= right; k++) {
            temp[k] = nums[k];
        }
       while(left <= right) {
           if(i > mid) {
               //left-mid到头
               nums[left++] = temp[j++];
           }else if(j > right) {
               nums[left++] = temp[i++];
           }else if(temp[i] < temp[j]) {
                nums[left++] = temp[i++];
            }else {
                nums[left++] = temp[j++];
            }
        }

    }

    private void sort(int[] nums,int left, int right) {
        if(left >= right) return ;
        int mid = (left+right) / 2;
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    public int[] mergeSort(int[] nums) {
       sort(nums,0,nums.length-1);
        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(mergeSort(new int[]{1,7,23,90,2,0,2,7,1,78})));
    }


}
