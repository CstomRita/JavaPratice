package algorithm.packageProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:23 2019-04-08
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class MultiplePackage {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int number = in.nextInt();
            int target = in.nextInt();
            int[] values = new int[number];
            int[] sizes = new int[number];
            int[] numbers = new int[number];
            for (int i = 0; i < number;i++) {
                sizes[i] = in.nextInt();
                values[i] = in.nextInt();
                numbers[i] = in.nextInt();
            }
            System.out.println(getMaxByViolence(number,target,values,sizes,numbers));
        }
    }
    public static int getMaxByViolence(int number,int target,int[] values,int[] sizes,int[] numbers) {
        int[] result = new int[target+1];
        for (int i = 1; i <= number; i++) {
            for (int j = target; j >= 0; j--) {
                //暴力法求最大值
                for (int k = 0; k <= numbers[i-1] && k * sizes[i-1] <= j; k++) {
                    result[j] = Math.max(result[j],result[j-k * sizes[i-1]]+k*values[i-1]);
                }
            }
        }
        return result[target];
    }

    /**
     * 将数字N拆分成几个数字
     * 可以凑出1-N
     * 不能凑出N+1-之后
     * @param n
     * @return
     */
    public static ArrayList<Integer> getSplit(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 1;
        while (n > (2*i-1)) {
            i = i << 1;
        }
        System.out.println(i);
        arrayList.add(n-(i-1));
        i = i >> 1;
        while (i != 0) {
            arrayList.add(i);
            i = i >> 1;
        }
        return arrayList;
    }

    @Test
    public void test() {
        System.out.println(getSplit(10));
    }
}
