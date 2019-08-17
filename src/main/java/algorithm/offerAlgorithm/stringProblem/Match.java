package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:06 2019-03-25
 * @ Description：请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 * @ Modified By：
 * @Version: $
 */
public class Match {

    /**
     *  * 表示的前面的字符，那么我们可以采用从后向前遍历的方式
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length != 0)  {
           // 只有 x* x*的方式可以
            if (pattern.length % 2 == 1) return false;
            for (int i = 1; i < str.length; i = i+2) {
                if (str[i] != '*') return false;
            }
            return true;
        }else if (str.length == 0 && pattern.length == 0) {
            return true;
        }else if (str.length != 0 && pattern.length == 0) {
            return false;
        }else {
            int index1 = str.length - 1;
            int index2 = pattern.length - 1;
            boolean isRepeat = false;
            while (index1 >= 0 || index2 >= 0) {
                char c1 =  str[index1] ;
                char c2 = pattern[index2];
                if (isRepeat) {
                    if (c1 == c2 || c2 == '.') {
                        index1--;
                    } else {
                        index2--;
                        isRepeat = false;
                    }
                    continue;
                }
                if (c2 == '*') {
                    // * 号的处理
                    index2--;
                    isRepeat = true;
                } else if (c2 != '.' || c1 == c2) {
                    index1--;
                    index2--;
                } else {
                    return false;
                }
            }
            System.out.println(index1);
            System.out.println(index2);
            return index1 <= 0 && index2 <= 0;
        }
    }

    @Test
    public void test() {
        System.out.println(match("a".toCharArray(),".*".toCharArray()));

    }
}
