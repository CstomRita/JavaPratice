package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:46 2019-03-22
 * @ Description：汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。
 *
 *
 * @ Modified By：
 * @Version: $
 */
public class LeftRotateString {
    /**
     * 思路1 ： 循环左移的意思就是把前n为的字符串拼接到n+1 end的子字符串后面
     * 验证n的大小，取str.length的余数
     *
     * 根据剑指offer中需要考察的点是如何翻转字符串例如 xyz 翻转成 zyx
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0) return "";
        int length = str.length();
        n = n % length;
        if (n == 0) return str;
        return str.substring(n,length)+str.substring(0,n);
    }

    @Test
    public void test() {
        System.out.println(LeftRotateString("abcXYZdef",3));
    }
}
