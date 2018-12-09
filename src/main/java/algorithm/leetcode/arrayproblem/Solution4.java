package algorithm.leetcode.arrayproblem;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午7:40 2018/11/8
 * @ Description：两个已排序数组的中值
 * @ Modified By：
 * @Version: $
 */
public class Solution4 {

    /**
     * 要求时间复杂度log(m+n)
     * 中值是什么 左右元素数量一样
     * 左边的元素 小于等于中值
     * 右边的元素 大于等于中值
     * 有 i + j = (length1+length2 - 1 /2)
     * 这个 i 和 j其实就是中值旁边的那两个数
     * 返回两者平均数 或者 两者小者
     * 且 nums1[i] < nums2[j+1]
     *  nums2[j] < nums1[i+1]
     *  应该遍历长度比较大的一个数组，这样可以保证肯定有个i是来自这个数组的
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = (length1 + length1 - 1) / 2;
        int i = 0, j = 0;
         if(length1 >= length2) {
            for( i = 0; i < length1 - 1; i++) {
                 j = length - i;
                if(j < length2-1 && nums1[i] <= nums2[j+1] && nums1[i+1] >= nums2[j]) break;
            }
            j = length - i;
        }else {
             for( j = 0; j < length2 - 1; j++) {
                  i = length - j;
                 if(i < length1-1 && nums1[i] <= nums2[j+1] && nums1[i+1] >= nums2[j]) break;
             }
         }
        System.out.println(i+" "+j);
        return (length1+length2)%2 == 0 ? ((double) nums1[i]+(double) nums2[j])/2:Math.min(nums1[i],nums2[j]);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}
