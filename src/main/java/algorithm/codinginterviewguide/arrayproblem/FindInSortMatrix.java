package algorithm.codinginterviewguide.arrayproblem;

import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 08:57 2019-08-19
 * @ Description：在行列排好序的数组中找数
 * @ Modified By：
 * @Version: $
 */
public class FindInSortMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int target = scanner.nextInt();
            int[][] nums = new int[n][m];
            for (int i = 0; i < n;i++) {
                for (int j = 0;j < m; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            System.out.println(getResult1(nums,target) ? "Yes" : "No");
        }
    }

    /**
     * @Author: ChangSiteng
     * @Description: 方法一，递归，这种时间复杂度很大
     * 相当于从左上角到目标i,j下所有的i\j都循环递归了一遍
     * 而且对于每一个i，都递归右侧所有的J
     * 时间复杂度肯定是平方类别的
     * @param nums:
      * @param target:
      * @param i:
      * @param j:
     * @return: boolean
     */
    private static boolean getResult(int[][] nums,int target,int i,int j) {
        if (nums[i][j] == target) return true;

        if (nums[i][j] < target) {
            return (j < nums[0].length - 1 && getResult(nums,target,i,j+1) ) ||
                    (i < nums.length - 1 && getResult(nums,target,i+1,j));
        }
        return false;
    }

    /**
     * @Author: ChangSiteng
     * @Description:
     * 正确思路，对于排序好的二维数组，一般从右上角遍历到左下角，或者左下角遍历遍历到右上角
     * 如果小于target，那么这一行都小于target,向下面一行 i+1
     * 如果大于target，则向左遍历j--，如果找到小于target的，向下i+1，如果都比target大则false，如果找到target true
     * 在寻找过程中是按照左上角到target的路线寻找的
     * 有：小于target i++; 大于target j--;
     * 时间复杂度O(i+j)
     * @param nums:
      * @param target:
     * @return: boolean
     */
    private static boolean getResult1(int[][] nums,int target) {
        int i = 0;
        int j = nums[0].length - 1;
        while (i < nums.length && j >= 0) {
            if (nums[i][j] < target) {
                i++;
            }else if (nums[i][j] > target){
                j--;
            }else {
                return true;
            }
        }
        return false;
    }
}
