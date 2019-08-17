package algorithm.examination.for360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:45 2019-08-15
 * @ Description： 通过
 * @ Modified By：
 * @Version: $
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
           int n = in.nextInt();
           int m = in.nextInt();
           int[][] input = new int[n][m];
           for (int i = 0;  i < n;i++) {
               for (int j = 0; j < m; j++) {
                   input[i][j] = in.nextInt();
               }
           }
            System.out.println(getResult(input,n,m));
        }
    }
    private static int getResult(int[][] input,int n,int m) {
        int result = 0;
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m;j++) {
                int number = input[i][j];
                if (number > 0) {
                    result += number * 4 + 2;
                    if (i >= 1 && input[i-1][j] > 0) {
                        result -= 2 * Math.min(input[i-1][j],number);
                    }
                    if (j >= 1 && input[i][j-1] > 0) {
                        result -= 2 * Math.min(input[i][j-1],number);
                    }
                }
            }
        }
        return result;
    }
}
