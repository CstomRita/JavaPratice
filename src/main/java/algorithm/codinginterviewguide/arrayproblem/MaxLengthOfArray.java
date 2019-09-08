package algorithm.codinginterviewguide.arrayproblem;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:34 2019-08-20
 * @ Description：可整合数组的最大长度
 * @ Modified By：
 * @Version: $
 */
public class MaxLengthOfArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(getResult(array));
        }
    }

    /**
     * @Author: ChangSiteng
     * @Description: 暴力法遍历所有的子数组，是否满足可整合数组，获得最大长度
     * 如何判断是否为可整合数组：因为数组中的元素都大于0 最大值 - 最小值 = 长度 - 1 就是可整合数组
     * @param array:
     * @return: int
     */
    private static int getResult(int[] array) {
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            int maxValue = array[i];
            int minValue = array[i];
            for (int j = i; j < array.length;j++) {
                maxValue = Math.max(array[j],maxValue);
                minValue = Math.min(array[j],minValue);
                if ((maxValue - minValue) == (j - i)) {
                    maxLength = Math.max((j-i+1),maxLength);
                }
            }
        }
        return maxLength;
    }
}
