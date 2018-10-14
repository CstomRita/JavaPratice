package Algorithm.SortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午1:08 2018/10/13
 * @ Description：堆排序
 * 堆排序 大顶堆 小顶堆
 *
 * 數據結構：二叉堆
 * 一個二叉樹的父節點 大於 其子節點 大頂堆
 * 一個二叉樹的父節點 小於 其子節點 小頂堆
 *
 * 它的優勢在於可以快速在一個數組中快速選擇出最大值 或 最小值
 *
 * 流程：
 * 每次構建出大頂堆/小頂堆，將堆頂的元素 和 數組 最後一個元素交換之後
 * 排除最後一個元素再次構建堆
 *
 *
 * 如何構建大頂堆：父節點 大於 子節點
 * 數組下標從0開始 父節點 i-1/2 子節點 2i+1 2i+2
 * 父節點0-nums.length/2 [nums.length/2 - nums.length]都是純子節點
 *
 * 二叉堆（ 0 - end) 這些元素
 * 此時改鬢index下標的元素
 * 需要重新調整index下標 rebuildHeap(index,end)
 * 此時需要知道的是 除了index 其他元素都是合法的，這就意味著index的元素是必然小於自己父節點的 否則父節點就是不合法的
 * 是在已經構建大頂堆的基礎上調整而已
 * 只需要考慮 index的子節點
 * 找出其最大的子節點maxchild和index的值比較,如果maxchild比temp大，則將maxChild賦值到當前的節點，並在這個節點下找可以存放temp的位置
 * 重新構建的話進行下濾操作
 *
 * 調整需要和子節點比較，是否比子節點大，如果比子節點小，則和最大的子節點交換
 *
 *
 *
 *
 * @ Modified By： 堆排序的index都是對父節點來操作的 0 - (length-1)/2
 * @Version: $
 */
public class HeapSort {

    /**
     *
     * @param nums 數組
     * @param index 需要調整的父節點下標  注意是父節點 目的是見這個數 temp放在一個比子節點大的位置
     * @param end [0-end]的數組元素
     */
    private void rebuildHeap(int[] nums,int index, int end) {
        int temp = nums[index];
        while(2*index+1 <= end) { //僅需考慮父節點 index還是父節點
            int maxChild = 2 * index + 1;
            if(maxChild+1 <= end && nums[maxChild] < nums[maxChild+1]){
                maxChild++;
            }
            if(temp < nums[maxChild]) {
                nums[index] = nums[maxChild];
                index = maxChild;
            }else {
                break;
            }
        }
        nums[index] = temp;
        //最後符合條件的index就是這個temp元素應該存在的位置
    }

    private int[] heapSort(int[] nums) {
        /**
         * 1 首先構建大頂堆
         * 對父節點上濾的進行下濾操作
         */
        for(int i = (nums.length-1)/2; i >= 0; i--){
            rebuildHeap(nums,i,nums.length-1);
        }
        /**
         * 2交換每一個 0 和 數組最後一個元素
         */
        for(int end = nums.length - 1; end > 0; end--) {
            int temp = nums[0];
            nums[0] = nums[end];
            nums[end] = temp;
            /**
             * 2.2 刨除最後一個元素 再次調整
             */
            rebuildHeap(nums,0,end-1);
        }
        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(heapSort(new int[]{1,2,6,23,9,0,23,89,2,-2,78})));
    }
}
