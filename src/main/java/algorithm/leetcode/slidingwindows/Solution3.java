package algorithm.leetcode.slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午3:37 2018/9/11
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Solution3 {
    // leetcode 第三题

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                i = map.get(c);
                result = Math.max(result, map.size());
                map.clear();
            } else {
                map.put(c, i);
            }
        }
        return Math.max(result, map.size());
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("wertyeryte"));
    }
}
