package algorithm.examination.tecent;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:25 2019-03-09
 * @ Description：腾讯笔试
 * @ Modified By：
 * @Version: $
 */
import java.util.Scanner;
public class Demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int  m = in.nextInt();
            if (n >= m){
                System.out.println(1);
                return;
            }
            // n m为价格
            int result = 0;
            int num = m;
            while(num > 0) {
                int index = num / n;
                System.out.println(n + "he " +index);
                if(index == 0) {
                    index =  1;
                }
                 result += index;
                num -= index * n ;

                n--;
            }
            System.out.println(result);
        }
    }
}
