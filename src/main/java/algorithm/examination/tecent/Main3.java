package algorithm.examination.tecent;



import java.util.Scanner;


/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:26 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
           int n = sc.nextInt();
           int[] wuli = new int[n];
           int[] money = new int[n];
           for (int i = 0; i < n; i++) {
               wuli[i] = sc.nextInt();
           }
            for (int i = 0; i < n; i++) {
                money[i] = sc.nextInt();
            }
            System.out.println(getMin(0,wuli,money,0));
        }
    }

    public static int getMin(int i,int[] wuli,int[] money,int myWuli) {
        if (wuli.length == 0) return 0;
        if (i < 0 || i >= wuli.length) return 0;
        if (myWuli < wuli[i]) {
            return money[i] + getMin(i+1,wuli,money,myWuli+wuli[i]);
        }else {
            return Math.min( money[i] + getMin(i+1,wuli,money,myWuli+wuli[i]),getMin(i+1,wuli,money,myWuli));
        }
    }
}

