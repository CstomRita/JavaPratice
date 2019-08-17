package algorithm.examination.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 14:49 2019-08-03
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            ///在这里面写就好
            int number = in.nextInt();
            int[] score = new int[number];
            for (int i = 0; i < number; i++) {
                score[i] = in.nextInt();
            }
            String[] result = new String[number];
            getResult(score,result,0,number-1,0);
//            getResult1(score);
            int askNumber = in.nextInt();
            for (int j  = 0; j  < askNumber;j++) {
                System.out.println(Double.valueOf(result[(in.nextInt() - 1)]));
            }
        }
    }

//    private static void getResult1(int[] score,float[] result) {
//        for (int i = 0; i < score.length; i++) {
//            int temp = score[i];
//            int count = 0;
//            for (int j = 0;j < score.length;j++) {
//                if (score[j] <= temp) count++;
//            }
//            float score1 = (float) (count-1) / (result.length) * 100;
//            result[i]  = score1;
//        }
//
//    }

    private static void getResult(int[] score,String[] result,int left,int right,int start) {
        if (left > right) return;
        int index = split(score,left,right);
        double score1 = (double) (index) / (result.length) * 100;
        result[start] = String.format("%.6f",score1);
        getResult(score,result,left,index-1,index);
        getResult(score,result,index+1,right,index+1);

    }
    private static int split(int[] nums, int left, int right) {
        int temp = nums[left];
        int i = left, j = right;
        while(i < j) {
            while(i < j && nums[j] >= temp){--j;}
            while( i < j && nums[i] <= temp){++i;}
            if(i >= j) break;
            int change = nums[i];
            nums[i] = nums[j];
            nums[j] = change;
        }
        int change = nums[i];
        nums[i] = nums[left];
        nums[left] = change;
        return i;
    }
}