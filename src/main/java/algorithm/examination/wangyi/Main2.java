package algorithm.examination.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:20 2019-08-03
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            ///在这里面写就好
            int number = in.nextInt();
            int[] score = new int[number];
            int operatorNum = in.nextInt();
            for (int i  = 0; i < number;i++) {
                score[i] = in.nextInt();
            }
            Arrays.sort(score);
            int[] result = new int[operatorNum];
            for (int j = 0; j < operatorNum; j++) {
                result[j] = (getResult(in.nextInt(),score));
            }
            for (int j = 0; j < operatorNum; j++) {
                System.out.println(result[j]);
            }
        }
    }
    private static int getResult(int num,int[] score) {
        int count = 0;
        for (int i = score.length-1; i >= 0; i--) {
            if (score[i] >= num){
                score[i] = score[i]-1;
                count++;
            }
        }
        return count;
    }

}
