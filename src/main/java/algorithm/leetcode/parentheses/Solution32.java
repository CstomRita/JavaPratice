package algorithm.leetcode.parentheses;

import org.junit.Test;

import javax.xml.ws.RequestWrapper;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:43 2019-03-07
 * @ Description：最长有效的回文数子串的长度
 * 一到这种回文数第一反应用堆栈
 * 一种字符入栈、一种字符出栈，当出栈不匹配时就是出错了
 * 什么是符合规则的子串，当弹出栈的字符是一种，且弹出之后stack空了，此时便是符合规则的子串
 * 虽然不一定是最大长度的子串，但是一定是符合规则的子串
 *
 * 对于求取最大长度时，不需要去在每个相对最大子串中找，在随便一个子串中寻找即可(如果随意子串比较简单)
 * @ Modified By：
 * @Version: $
 */
public class Solution32 {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int result = 0,length = 0;
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c.equals('(')) {
                // （ 入栈
                stack.push(c);
                length++;
            }else if(stack.empty() || !stack.pop().equals('(')) {
                    //说明))多了
                    result = Math.max(result,2 * length);
                    length = 0;
                }
            }

        if(!stack.empty()) {
            // 说明(多了
            result = Math.max(result,(length-stack.size()) * 2);
        }else {
            result = Math.max(result, 2 * length);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(longestValidParentheses("()(()"));
    }
}
