package algorithm.examination.tecent;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:26 2019-04-05
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String m = sc.nextLine();
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() != c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            System.out.println(stack.size());
        }
    }
}
