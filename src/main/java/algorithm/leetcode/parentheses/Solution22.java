package algorithm.leetcode.parentheses;

import org.junit.Test;

import java.util.*;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午8:55 2018/9/28
 * @ Description：成对的符号：括号、方框、大括号等等
 * @ Modified By：
 * @Version: $
 */
public class Solution22 {

    /**
     * leetcode 第22题
     * 使用n对括号生成不同的组合
     * @param n
     * @return
     */

    private Set<String> result = new HashSet<String>();

    public List<String> generateParenthesis(int n) {
        if(n < 1) return null;
        generateParenthesis1(n);
        return new ArrayList<String>(result);
    }

    private void generateParenthesis1(int n) {
        if(n < 1) return;
        if(n == 1) {
           result.add("()");
            return;
        }
        generateParenthesis1(n-1);
        HashSet<String> result1 = new HashSet<String>();
        for(String s : result) {
            result1.add("()"+s);
            result1.add("("+s+")");
            result1.add(s+"()");
        }
        result = result1;
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(4));
        String[] an = new String[]{"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        for(String s : an) {
            if(!result.contains(s)) {
                System.out.println(s);
            }
        }
    }
}
