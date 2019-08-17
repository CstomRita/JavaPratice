package algorithm.packageProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:14 2019-04-08
 * @ Description：完全背包
 * @ Modified By：
 * @Version: $
 */
public class EntirePackage  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            int colum = scanner.nextInt();
            int[] values = new int[number];
            int[] colums = new int[number];
            for (int i = 0; i < number; i++) {
                colums[i] = scanner.nextInt();
                values[i] = scanner.nextInt();
            }
            System.out.println(getMax1(number,colum,values,colums));
         }
    }

    public static int getMax(int number,int column,int[] values,int[] colums) {
        int[][] result = new int[number+1][column+1];
        result[0][0] = 0;
        for (int i = 1; i <= number;i++) {
            for (int j = 0; j <= column; j++ ) {
                if (j >= colums[i-1]) {
                    result[i][j] = Math.max(result[i-1][j],result[i][j-colums[i-1]]+values[i-1]);
                }else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[number][column];
    }

    /**
     * 一维数组
     * @param number
     * @param volume
     * @param values
     * @param volumes
     * @return
     */
    public static int getMax1(int number, int volume,int[] values,int[] volumes) {
        int[] result = new int[volume+1];
        result[0] = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = volumes[i-1] ; j <= volume; j++) {
                result[j] = Math.max(result[j],result[j - volumes[i-1]]+values[i-1]);
            }
        }
        return result[volume];
    }
}
