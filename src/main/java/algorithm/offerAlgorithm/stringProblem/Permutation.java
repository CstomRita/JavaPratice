package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;

import java.util.*;

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

    public ArrayList<String> PermutationFirst(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.trim().length() == 0) return res;
         Collections.sort(Permutation(str.toCharArray(),res,0));
         return res;
    }

    /**
     * 第一点 递归的返回值不一定总是Null，也是可能是一个新创建的对象，类似于[]这种
     *
     * 第二点 审题，题目中要求按照字典序排序，字典序就是按照abcd...这样排序
     *
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation1(String str) {
        if (str.length() == 0) return new ArrayList<>();
        if (str.length()  == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(str);
            return res;
        }
        Character c = str.charAt(0);
        ArrayList<String> result = Permutation1(str.substring(1,str.length()));
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


    /**
     * 这样将一个字符串分成两个部分，前一部分是确定好的，后一部分是还未确定好的顺序
     * 每次递归是按照元素字母顺序添加到已经确定好的部分中，需要循环未确定顺序大小次，每次循环中依然要递归，知道递归出口
     * 注意回溯时需要remove最后一个元素的。
     * 当未确定好的只有一个元素时就是递归出口，此时做一下判断
     *
     * 对于需要频繁变化的字符串，可以使用char[]数组保存
     * @return
     */
    public ArrayList<String> Permutation(char[] chars,ArrayList<String> listAll,int index) {
        if (index == chars.length - 1) {
            //只剩下一个元素
            if (!listAll.contains(String.valueOf(chars))) {
                listAll.add(String.valueOf(chars));
            }
        }else {
            //开始回溯，按照元素字母顺序添加到已经确定好的部分中
            // index表示要开始添加的顺序
           // Arrays.sort(chars,index+1,chars.length);
            //这里不能写把index排序，因为有可能会改变index的值，这样由于下面index的值还有交换的步骤，会引起混乱。
             for (int i = index; i < chars.length; i++) {
                if (i != index) {
                    char temp = chars[i];
                    chars[i] = chars[index];
                    chars[index] = temp;
                }
                Permutation(chars,listAll,index + 1);
                // chars和list一样，一旦修改了就是修改了，不会因为是形参就主动回溯
                // 因此需要手动回溯，把i和index再交换回来
                if (i != index) {
                   char temp = chars[i];
                    chars[i] = chars[index];
                    chars[index] = temp;
                }
            }
        }
        return listAll;
    }
    @Test
    public void test() {
        char[] chars = "dcba".toCharArray();
        Arrays.sort(chars,1,4);
        System.out.println(chars);
        ArrayList<String> res = PermutationFirst("cbda");
        System.out.println(res);
    }


}
