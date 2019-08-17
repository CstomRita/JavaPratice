package algorithm.examination.niuke;

import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:01 2019-07-12
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main5 {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            ///在这里面写就好
//            int number = in.nextInt();
//            if (number <= 1) {
//                System.out.println(0);
//                continue;
//            }
//            int[] temp = new int[number+1];
//            temp[0] = temp[1] = 0;
//            temp[2] = 1;
//            for (int i = 2; i <= number; i++) {
//                if (temp[i] == 0) temp[i] = temp[i-1] + 1;
//                int j = i * i;
//                if (j <= number && temp[j] == 0) temp[j] = temp[i] + 1;
//            }
//            System.out.println(temp[number]);
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            ///在这里面写就好
            String s = in.nextLine();
            int sum = 0;
            int count = 0;
            int left = 5;
            int right = 6;
            int isLeft = 0;
            for (char c : s.toCharArray()) {
                int number = c - 48;
                if (number == 0) number = 10;
                int mid = 0;
                if (Math.abs(number-left) > Math.abs(number-right)) {
                    //右手离得近
                    mid = Math.abs(number - right);
                    right = number;
                    if (isLeft == 2) {
                        count = 0;
                    }else {
                      isLeft = 2;//右边移动
                    }

                }else {
                    mid = Math.abs(number - left);
                    left = number;
                    if (isLeft == 1) {
                        count = 0;
                    }else {
                        isLeft = 1;//左边边移动
                    }

                }
                if (mid > (count)) {
                        sum += mid - (count);
                }
                count = mid + 1;
                sum += 1;
            }
            System.out.println(sum);
        }
    }
}
