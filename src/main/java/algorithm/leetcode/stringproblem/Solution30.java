package algorithm.leetcode.stringproblem;

import org.junit.Test;

import java.util.*;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:42 2019-03-06
 * @ Description：
 * 给定一个字符串s,其中所有单词都长度相同
 * 给定一个单词的数组
 * 要求返回在字符串s中包含数组组成的子串的所有起始下标
 * 子串是数组中所有的单词组成的，只有一次且不包含其他元素
 * 注意数组里单词是可能重复的，不能单纯hash
 * @ Modified By：
 * @Version: $
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(s.length() == 0 || words.length == 0) {
            return result;
        }
        int length = words[0].length();
        int count = words.length;
        String[] sentce = new String[s.length() / length];
        int startIndex = 0 ,endIndex = 0,index = 0;
        StringBuilder stringBuilder = new StringBuilder();

        // 把字符串s拆分
        for(int i = 0;i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            if((i+1) % length == 0) {
                sentce[index++] = stringBuilder.toString();
                stringBuilder = new StringBuilder();
            }
        }

       // 做一些判断
       if(sentce.length < words.length) {
           return result;
       }

       // 记录Words和次数
        HashMap<String,Integer> wordHash = new HashMap<String, Integer>();
        for(String word : words) {
            wordHash.put(word, wordHash.getOrDefault(word, 0) + 1);
        }
        HashMap<String,Integer> record = new HashMap<String, Integer>();
        // 寻找wordHash和sentce的下标
        while (endIndex < sentce.length) {
            String word = sentce[endIndex];
            if(!wordHash.containsKey(word)) {
               startIndex = endIndex + 1;
               endIndex = startIndex;
               record.clear();
            }else if (!record.containsKey(word)){
               record.put(word,1);
               count--;
               endIndex++;
            }else {
                Integer valueBase = wordHash.get(word);
                Integer value = record.get(word);
                if(value >= valueBase) {
                    //说明这个单词不能再重复了
                    String word1 = sentce[startIndex];
                    record.put(word1,record.get(word1)+1);
                    startIndex++;
                    endIndex = endIndex > startIndex? endIndex : startIndex;
                    count = count + 1;
                }else {
                    //这个单词符合规律
                    record.put(word,value+1);
                    count--;
                    endIndex++;
                }
            }
            if(count == 0) {
                result.add(length * startIndex);
                record.clear();
            }
        }
        System.out.println(result);
        return result;
    }

    @Test
    public void test() {
        findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"});
    }
}
