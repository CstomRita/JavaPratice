package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:23 2019-03-15
 * @ Description： 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * @ Modified By：
 * @Version: $
 */
public class Permutation {


    /**
     * 第一点 递归的返回值不一定总是Null，也是可能是一个新创建的对象，类似于[]这种
     *
     * 第二点 审题，题目中要求按照字典序排序，字典序就是按照abcd...这样排序
     *
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return new ArrayList<>();
        if (str.length()  == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(str);
            return res;
        }
        Character c = str.charAt(0);
        ArrayList<String> result = Permutation(str.substring(1,str.length()));
        System.out.println(result);
        HashSet<String> res = new HashSet<>();
        if (result != null) {
            for(int i = 0; i < result.size(); i++) {
                String st = result.get(i);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(c).append(st);
                res.add(stringBuffer.toString());
                char[] s = st.toCharArray();
                for (int j = 0; j < s.length; j++) {
                    StringBuffer stringBuffer1 = new StringBuffer(stringBuffer);
                    if (s[j] != c) {
                        stringBuffer1.setCharAt(0,s[j]);
                        stringBuffer1.setCharAt(j+1,c);
                        res.add(stringBuffer1.toString());
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    @Test
    public void test() {
        ArrayList<String> res = Permutation("abc");
        System.out.println(res);
        System.out.println(res.contains("acab"));
    }


}
