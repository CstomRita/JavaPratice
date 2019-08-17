package algorithm.examination.niuke;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:07 2019-03-14
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
import org.junit.Test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int x = 0,y = 0,k = 0;
                x = sc.nextInt();
                y = sc.nextInt();
                k = sc.nextInt();
            result[i] = getNum(x,y,k);
        }
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int getNum(int x,int y, int k) {
        int a = Math.abs(x);
        int b = Math.abs(y);
        if (a == b) {
            if (k < a) return -1;
            else if ((k - a) % 2 == 0) return k;
            else return k - 2;
        }
        int maxXY = Math.max(a,b);
        int step = Math.max(maxXY - a,maxXY - b);
        System.out.println(step);
        return getNum(maxXY,maxXY,k - step);
    }

    @Test
    public void test(){
        test1(173);
    }
    public void test1(int n) {
        if (n <= 1) {
            System.out.print(n);
        }else{
            test1(n/2);
            System.out.print(n%2);
        }
    }
}
