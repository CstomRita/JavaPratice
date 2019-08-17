package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 21:48 2019-03-28
 * @ Description：
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @ Modified By：
 * @Version: $
 */
public class FirstNoReapt {

    private HashMap<Character,Integer> map = new HashMap<>();
    private int count  = 0;
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!map.containsKey(ch)) {
            map.put(ch,count++);
        }else {
            map.remove(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char result = '#';
        int min = Integer.MAX_VALUE;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    @Test
    public void test() {
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(map);
        System.out.println(FirstAppearingOnce());
    }
}
