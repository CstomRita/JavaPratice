package pratice;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:14 2019-03-26
 * @ Description：算法练习1
 * @ Modified By：
 * @Version: $
 */
public class Demo1 {

    /**
     * 选择排序，遍历
     * 记录剩下元素中最小的索引，
     * 和第i个元素交换
     *
     * 时间复杂度O(n^2)
     *
     * @param array
     */
    public void selectSort(int [] array) {
        for(int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) min = j;
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 冒泡排序
     * 遍历相邻元素时每次都交换，找最大的，把最大的移动到右边
     *
     * @param array
     */
    public void bubbleSort(int [] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-j;j++) {
                if (array[j+1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 快排的思想用的就比较多了
     * 每个分组的第一个元素，作为初始元素
     * 定义左右两个哨兵，分别找到比初始元素小的 比初始元素大的 交换
     * 目的将初始元素排到它本该在的位置，左边的都比他小，右边的都比他大
     *
     * 不交换相等的，右哨兵先行
     *
     * 时间复杂度O(nlogn)
     *
     * @param array
     */
    public void quickSort(int [] array, int start, int end) {
        if (start >= end) return;
        int i = array[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && array[right] >= i) right--;
            while (left < right && array[left] <= i) left++;
            if (left >= right) break;
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        array[start] = array[left];
        array[left] = i;
        quickSort(array,start,left-1);
        quickSort(array,left+1,end);
    }

    /**
     * 归并排序，用的也比较多
     * 从中间的下标左右递归
     *
     * 然后再排序，排序时认为左右子数组已经是排序好的数组了
     * 使用辅助数组排序
     *
     * @param array
     */
    public void mergeSort(int [] array, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        // 主要操作过程
        int[] temp = new int[end+1];
        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }
        int left = start,right = mid + 1,index = start;
        while (left <= mid && right <= end) {
            if (temp[left] < temp[right]) {
                array[index++] = temp[left++];
            }else {
                array[index++] = temp[right++];
            }
        }
        while (left <= mid) array[index++] = temp[left++];
        while (right <= end) array[index++] = temp[right++];
    }

    /**
     * 堆排序
     *
     * 重点在于重新构建大顶堆的思想
     * 重构大顶堆的原因是由于改变了index下标的值，导致index-end区间不满足，大顶堆
     * 初始条件在于index+1-end之间是维持大顶堆的特点的
     *
     * 大顶堆特点：父节点大于子节点
     * 父节点下标index，子节点下标 2*index+1 2*index+2
     * 重构时将index下标的元素放到它应该在的位置上
     * 在重构过程中，所有的比较都是面向index这个元素的，目的是找到它放置的位置
     *
     * 所有操作面向父节点  (array.length-1) / 2 为止
     *
     * @param array
     */
    public void heapSort(int[] array) {
        // 1 首先构建大顶堆，面向父节点，自顶向上
        for (int i = (array.length-1) / 2; i >= 0; i--) {
            rebuild(array,i,array.length-1);
        }
        // 2 大顶堆就是最大的元素在0的位置，交换之后重rebuild
        for (int i = array.length-1; i > 0;i--) {
            int max = array[0];
            array[0] = array[i];
            array[i] = max;
            rebuild(array,0,i-1);
        }
    }
    private void rebuild(int[] array,int index,int end) {
        int temp = array[index];
        while (2*index+1 <= end) { //index有父节点
            int macChild = 2*index+1;
            if (macChild+1 <= end && array[macChild+1] > array[macChild]) macChild++;
            if (array[macChild] > temp) {
                //子节点大于temp,把子节点放在父节点的位置，子节点放temp
                array[index] = array[macChild];
                array[macChild] = temp;
                //子节点交换之后，就变成了改变的index，为index赋值
                index = macChild;
            }else{
                //说明满足大顶堆了，可以break
                break;
            }
        }
        array[index] = temp;
    }

    /**
     * 插入排序
     *
     * 在第i次遍历时，目的是将nums[i]放置到nums[0] - nums[i]小数组中相对正确的位置
     * 其中nums[0]-nums[i-1]是满足从小到大排序的
     *
     * @param array
     */
    public void insertSort(int [] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    /**
     * 希尔排序
     * 和插入排序的思想一样
     * 只是间隔不是1，而是h
     *
     * 每次h/2直到h=1
     *
     * @param array
     */
    public void shellSort(int [] array) {
        int h = array.length/2;
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j > 0; j-=h) {
                    if (array[j] < array[j-h]) {
                        int temp = array[j];
                        array[j] = array[j-h];
                        array[j-h] = temp;
                    }
                }
            }
            h = h >> 1;
        }
    }
}
