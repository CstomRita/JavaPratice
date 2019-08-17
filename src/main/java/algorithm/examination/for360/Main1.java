package algorithm.examination.for360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:00 2019-08-15
 * @ Description：超时
 * 两个m进制数都有n位，调整数字顺序，每位分别对应相加取模，得到最大的返回值
 * @ Modified By：
 * @Version: $
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
           int n = in.nextInt();
           int m = in.nextInt();
           int[] number1 = new int[n];
           int[] number2 = new int[n];
           for (int i = 0; i < n; i++) {
               number1[i] = in.nextInt();
           }
           for (int i = 0; i < n; i++){
               number2[i] = in.nextInt();
           }
            System.out.println(getResult(number1,number2,m));
        }
    }
    private static String getResult(int[] number1, int[] number2, int m) {
        int length = number1.length;
        StringBuffer s = new StringBuffer();
        int[] result = new int[length];
        for (int i = 0; i < length ; i++) {
            int maxValue = 0;
            int change1 = i;
            int change2 = i;
            for (int index1 = i; index1 < length; index1++) {
                for (int index2 = i; index2 < length; index2++) {
                    int k = (number1[index1] + number2[index2]) % m;
                    if (k > maxValue) {
                        change1 =  index1;
                        change2 = index2;
                        maxValue = k;
                        result[i]  = maxValue;
                    }
                }
            }
            change(number1,i,change1);
            change(number2,i,change2);
            s.append(maxValue).append(" ");
        }
        return String.valueOf(s);
    }
    private static void change(int[] numer,int i,int j) {
        int temp = numer[i];
        numer[i] = numer[j];
        numer[j] = temp;
    }
}
