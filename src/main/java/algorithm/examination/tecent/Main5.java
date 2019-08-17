package algorithm.examination.tecent;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:50 2019-04-13
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] res = new int[n];
            for (int i = 0 ; i < n; i++) {
                res[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 1; i <= n; i++) {
                stack.push(i);
            }
            int j = res.length - 1;
            int result = 0;
            while (!stack.isEmpty() || j < 0) {
               if (stack.peek() != res[j]) {
                    result++;
                }else{
                   j--;
               }
                stack.pop();
            }
            System.out.println(result);
        }
    }
}
