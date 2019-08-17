package algorithm.examination.tecent;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:25 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int target = sc.nextInt();
            int n = sc.nextInt();
            int[] inputs = new int[n]; //面值
            for (int i = 0; i < n; i++) {
                inputs[i] = sc.nextInt();
            }
            System.out.println(target);
            System.out.println(n);
            System.out.println(Arrays.toString(inputs));
            int[] result = new int[target]; // DP
            for (int i = 0; i < result.length; i++) {
                result[i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= target; n++) {
                    if (j >= inputs[i]) {
                        result[j] += result[j - inputs[i]]; // 状态转移方程
                    }
                }
            }
            System.out.println(Arrays.toString(result));
            System.out.println(result[target-1]);
        }
    }

}

