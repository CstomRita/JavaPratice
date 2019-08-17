package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:56 2019-03-22
 * @ Description：翻转字符串
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @ Modified By：
 * @Version: $
 */
public class ReverseSentence {

    /**
     * 注意审题，这里不是 xyz 到 zyx的翻转
     * 他只是单词顺序不一样了，但是单词本身的顺序是对的
     * 也就是说要按照' '空格做划分
     *
     * 思路1：
     * 通过stringBuilder，从后想💰遍历，遇到空格就把单词append
     * 时间复杂对O(n)
     *
     * @param str
     * @return
     */
    public String ReverseSentence1(String str) {
        if (str.length() == 0) return str;
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = str.toCharArray();
        int endIndex = str.length() - 1,startIndex = str.length() - 1;
        while (startIndex >= 0) {
            if (startIndex == 0) {
                stringBuffer.append(str.substring(startIndex,endIndex + 1));
                endIndex = startIndex;
            } else if (chars[startIndex] == ' ') {
               stringBuffer.append(str.substring(startIndex + 1,endIndex + 1)).append(' ');
               endIndex = startIndex - 1;
           }
            startIndex--;
        }
        return stringBuffer.toString();
    }


    /**
     * 两次翻转 翻转字符串顺序
     * 先翻转每个字符
     * 再翻转所有字符
     */
    public String ReverseSentence(String str) {
        if (str.length() == 0) return str;
        char[] chars = str.toCharArray();
        int start = 0,end;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                end = i - 1;
                reverse(start,end,chars);
                start = i + 1;
            }
        }
        reverse(start,str.length()-1,chars);
        reverse(0,str.length()-1,chars);
        return String.valueOf(chars);
     }
    public void reverse(int start,int end,char[] chars) {
        System.out.println(start+""+end);
        if (start < 0 || end >= chars.length || start >= end) return;
        while (start < end) {
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
    }
    @Test
    public void test() {
        String s = "student. good a am I";
        System.out.println(ReverseSentence(s));
    }

    /**
     * 扩展 左旋
     */
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0 || n <= 0) return str;
        char[] chars = str.toCharArray();
        reverse(0,n-1,chars);
        reverse(n,chars.length-1,chars);
        reverse(0,chars.length-1,chars);
        return String.valueOf(chars);
    }
}
