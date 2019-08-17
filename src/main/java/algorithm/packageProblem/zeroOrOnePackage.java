package algorithm.packageProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:40 2019-04-07
 * @ Description：0/1背包问题
 * @ Modified By：
 * @Version: $
 */
public class zeroOrOnePackage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int number = in.nextInt();
            int volume = in.nextInt();
            int[] values = new int[number];
            int[] volumes = new int[number];
            for (int i = 0; i < number;i++) {
                volumes[i] = in.nextInt();
                values[i] = in.nextInt();
            }
            System.out.println(getMavValue1(number,volume,values,volumes));
        }
    }

    /**
     * 二维DP
     * @return
     */
    public static int getMavValue(int number, int volume,int[] values,int[] volumes) {
        int[][] result = new int[number+1][volume+1];

        for (int i = 1; i <= number;i++) {
            for (int j = 0; j <= volume;j++) {
                if (j >= volumes[i-1]) {
                    result[i][j] = Math.max(result[i-1][j], (result[i-1][j-volumes[i-1]] + values[i-1]));
                }else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        int res = 0;
        System.out.println(Arrays.toString(result[number-1]));
        for (int j = 0; j <= volume; j++) {
            res = Math.max(res,result[number][j]);
        }
        return res;
    }


    /**
     * 一维数组
     * @param number
     * @param volume
     * @param values
     * @param volumes
     * @return
     */
    public static int getMavValue1(int number, int volume,int[] values,int[] volumes) {
        int[] result = new int[volume+1];
        result[0] = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = volume; j >= volumes[i-1]; j--) {
                result[j] = Math.max(result[j],result[j - volumes[i-1]]+values[i-1]);
            }
        }
        System.out.println(Arrays.toString(result));
        return result[volume];
     }
    }
