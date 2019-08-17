package algorithm.review.sort;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:48 2019-05-14
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Demo1 {
    /**
     * 1. 选择排序
     * 2. 冒泡排序
     * 3. 快速排序
     * 4. 归并排序
     * 5. 堆排序
     * 6. 插入排序
     * 7. 希尔排序
     */

    public void selectSort(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[index]) index = j;
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j+1] > nums[j]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 语言描述：首先快速排序使用了递归的思想，将整个数组分成多个分组排序
     * 在每一个分组中，将第一个元素作为初始元素，我们的目的是将这个元素放置到他应该在的正确位置上
     * 也就是说该位置下左边元素都比他小，右边元素都比他大
     * 为实现这个目的，我们定义左右两个指针，分别找到比初始元素小的 比初始元素大的 交换
     * @param nums
     * @param start
     * @param end
     */
    public void quickSort(int[] nums,int start,int end) {
     if (start <= end) return;
     int left = start, right = end;
     while (right > left) {
         while (right > left && nums[right] >= nums[start]) right--;
         while (right > left && nums[left] <= nums[start]) left++;
         if (right <= left) break;
         int temp = nums[right];
         nums[right] = nums[left];
         nums[left] = temp;
     }
     int temp = nums[start];
     nums[start] = nums[left];
     nums[left] = temp;
     quickSort(nums,start,left-1);
     quickSort(nums,left+1,end);
    }

    public void mergeSort(int[] nums,int start,int end) {
        if (start <= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);

        int[] temp = new int[end+1];
        int left = start,right = mid+1,index = start;
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        while (left <= mid && right <= end) {
            if (temp[left] < temp[right]) {
                nums[index++] = temp[left++];
            }else {
                nums[index++] = temp[right++];
            }
        }
        while (left <= mid) nums[index++] = temp[left++];
        while (right <= end) nums[index++] = temp[right++];
    }

    public void heapSort(int[] nums) {
        for (int i = (nums.length-1)/2; i >= 0; i--) {
            rebuild(nums,i,nums.length-1);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int max = nums[0];
            nums[0] = nums[i];
            nums[i] = max;
            rebuild(nums,0,i-1);
        }
    }
    public void rebuild(int[] nums,int index,int end) {
        int target = nums[index];
        while (index <= end) { //有子节点时
            int macChild = 2*index+1;
            if (macChild+1 <= end && nums[macChild+1] > nums[macChild]) macChild++;
           if (target < nums[macChild]) { // 需要调整
               nums[index] = nums[macChild];
               index = macChild;
           }else break;
        }
        nums[index] = target;
    }

    public void inserSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    public void shellSort(int[] nums) {
        int h = nums.length / 2;
        while (h >= 1) {
            for (int i = h; i < nums.length; i++) {
                for (int j = i; j > 0 ; j-=h) {
                    if (nums[j] < nums[j-h]) {
                        int temp = nums[j];
                        nums[j] = nums[j-h];
                        nums[j-h] = temp;
                    }
                }
            }
            h = h / 2;
        }
    }
}
