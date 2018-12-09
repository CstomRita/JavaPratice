package pratice;

import java.util.Arrays;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午7:11 2018/10/31
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class SortPratice {
    private void rebuild(int index,int[] nums,int end) {
        int temp = nums[index];
        while(2*index + 1 <= end) {
            int maxChild = 2*index+1;
            maxChild = maxChild+1 <= end && nums[maxChild+1] > nums[maxChild] ? maxChild+1 :maxChild;
            if(nums[maxChild] > temp) {
                nums[index] = nums[maxChild];
                index = maxChild;
            }else {
                break;
            }
        }
        nums[index] = temp;
    }
    public void heapSort(int[] nums) {
        for(int i = nums.length/2 - 1 ; i >= 0; i--) {
            rebuild(i,nums,nums.length-1);
        }
        for(int length = nums.length-1; length > 0;length--) {
            rebuild(0,nums,length);
            int temp = nums[0];
            nums[0] = nums[length];
            nums[length] = temp;
        }
    }
    @org.junit.Test
    public void sort() {
        int[] nums = new int[]{-1,4,9,23,0,-22,5};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void quickSort(int[] nums) {
        quickSort(0,nums.length-1,nums);
    }
    private void quickSort(int left,int right,int[] nums) {
        if(left >= right) return;
        int i = left + 1;
        int j = right;
        while(i < j) {
            while( i < j && nums[j] >= nums[left]) j--;
            while( i < j && nums[i] <= nums[left]) i++;
            if(i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
        quickSort(left,i-1,nums);
        quickSort(i+1,right,nums);
    }
    private void mergeSort(int left,int right,int[] nums) {
        if(left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(left,mid,nums);
        mergeSort(mid+1, right, nums);
        int[] temp = new int[right+1];
        for(int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left,k = left;
        int j = mid+1;
        while(k <= right) {
            if(j > right){
                nums[k++] = temp[i++];
            }else if(i > mid) {
                nums[k++] = temp[j++];
            } else if(temp[i] < temp[j]) {
                nums[k++] = temp[j++];
            } else {
                nums[k++] = temp[i++];
            }
        }

    }
    private void mergeSort(int[] nums) {
        mergeSort(0,nums.length-1,nums);
    }
    private void selectSort(int[] nums) {
        for(int i = 0; i <= nums.length-1;i++) {
            int min = i;
            for(int j = i + 1; j <= nums.length-1; j++) {
                min = nums[j] < nums[min]? j : min;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
    public void insertSort(int[] nums) {
        for(int i = 1; i <= nums.length-1; i++) {
            for(int j = i ; j > 0; j--) {
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }
    public void shellSort(int[] nums) {
        int shell = nums.length / 2;
        while (shell >= 1) {
            for(int i = shell; i < nums.length; i++) {
                if (nums[i] < nums[i - shell]) {
                    int temp = nums[i];
                    nums[i] = nums[i-shell];
                    nums[i-shell] = temp;
                }
            }
            shell /= 2;
        }
    }
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0 )|| (dividend > 0 && divisor < 0 ) ? true : false;
        dividend = dividend < 0 ? -dividend:dividend;
        divisor = divisor < 0 ? -divisor:divisor;
        int result = 0;
        while(dividend > divisor) {
            dividend = dividend - divisor;
            result ++;
        }
        return isNegative? -result:result;
    }
}
