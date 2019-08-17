package algorithm.sortalgorithm;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:45 2019-03-26
 * @ Description：冒泡排序
 * @ Modified By：
 * @Version: $
 */
public class BubbleSort {

    /**
     * 比较相邻的元素，把最大的移动到右边
     * 如此遍历到length-1时，就是最大的
     *
     * 再重新遍历到length-i
     *
     * 选择排序和冒泡排序的思想差不多，区别在于选择排序只记录索引，最后只交换一次，每次找最小值
     * 冒泡排序是在遍历的时候就会交换，每次找最大值
     *
     * @param array
     */
    public void bubbleSort(int [] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j+1] < array[j]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
