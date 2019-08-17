package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:43 2019-03-24
 * @ Description：将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要
 * 求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 *
 * @ Modified By：
 * @Version: $
 */
public class StrToInt {

    /**
     * 输入有可能存在 + 与 - 表示正负数
     * 其他情况下如果存在非数字的字符就是非合法的字符串 返回0
     *
     * 字符 0 对应的int 为 48
     * 字符 A 对应 65
     * a 对应 97
     * 思路一:从字符串的末尾开始遍历，向前遍历时 sum += index * char-48 index *= 10;
     * 在 i ！= 0 时遇到非 48 - 57内的则return0
     *
     * 另外考虑string装Integer时溢出的问题
     * 用的int存储，本身对溢出做了处理，不需要再处理
     *
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str.length() == 0) return 0;
        int i = str.length() - 1;
        int sum = 0;
        int index = 1;
        boolean flag = false;
        while (i >= 0) {
            char c = str.charAt(i);
            if (i == 0 && c == '+') return sum;
            if (i == 0 && c == '-') return -sum;
            if (c < 48 || c > 57) {
                if (c == '.' && !flag) {
                    sum = 0;
                    index = 1;
                    flag = true;
                    i--;
                    continue;
                }else {
                    return 0;
                }
            }
            sum += index * (c - 48);
            index *= 10;
            i--;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(StrToInt("09"));
    }
}
